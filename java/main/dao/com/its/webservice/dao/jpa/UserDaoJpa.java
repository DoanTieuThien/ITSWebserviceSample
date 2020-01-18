package com.its.webservice.dao.jpa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.its.webservice.dao.UserDao;
import com.its.webservice.models.UserModel;
import com.its.webservice.utils.DatabaseUtil;

@Repository("UserDao")
public class UserDaoJpa implements UserDao {
	@Autowired
	private DataSource dataSource = null;

	@Override
	public List<UserModel> loadAllUser() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String queryUserCommand = "SELECT USERNAME,PASSWORD,STATUS FROM ITS_USER";
		List<UserModel> userModels = new ArrayList<UserModel>();

		try {
			conn = this.dataSource.getConnection();
			pstmt = conn.prepareStatement(queryUserCommand);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				UserModel userModel = new UserModel();
				userModel.setUserName(rs.getString("USERNAME"));
				userModel.setPassword(rs.getString("PASSWORD"));
				userModel.setStatus(rs.getString("STATUS"));
				userModels.add(userModel);
			}
		} catch (Exception exp) {
			throw exp;
		} finally {
			DatabaseUtil.closeObject(rs);
			DatabaseUtil.closeObject(pstmt);
			DatabaseUtil.closeObject(conn);
		}
		return userModels;
	}

	@Override
	public void updateUserByUserName(UserModel userModel) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		String insertCommand = "UPDATE ITS_USER SET PASSWORD = ?, STATUS = ?  WHERE  UPPER(USERNAME) = UPPER(?)";

		try {
			conn = this.dataSource.getConnection();
			pstmt = conn.prepareStatement(insertCommand);
			pstmt.setString(1,userModel.getPassword());
			pstmt.setString(2,userModel.getStatus());
			pstmt.setString(3,userModel.getUserName());
			int index  = pstmt.executeUpdate();
			if(index < 1) {
				throw new Exception("Update user failed");
			}
		} catch (Exception exp) {
			throw exp;
		} finally {
			DatabaseUtil.closeObject(pstmt);
			DatabaseUtil.closeObject(conn);
		}
	}

	@Override
	public void deleteUserByUserName(String userName) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		String insertCommand = "DELETE FROM ITS_USER WHERE  UPPER(USERNAME) = UPPER(?)";

		try {
			conn = this.dataSource.getConnection();
			pstmt = conn.prepareStatement(insertCommand);
			pstmt.setString(1,userName);
			int index  = pstmt.executeUpdate();
			if(index < 1) {
				throw new Exception("Delete user failed");
			}
		} catch (Exception exp) {
			throw exp;
		} finally {
			DatabaseUtil.closeObject(pstmt);
			DatabaseUtil.closeObject(conn);
		}
	}

	@Override
	public void insertUser(UserModel userModel) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		String insertCommand = "INSERT INTO ITS_USER(USERNAME,PASSWORD,STATUS) VALUES (UPPER(?),?,?)";

		try {
			conn = this.dataSource.getConnection();
			pstmt = conn.prepareStatement(insertCommand);
			pstmt.setString(1,Optional.ofNullable(userModel.getUserName()).orElse("").trim());
			pstmt.setString(2,Optional.ofNullable(userModel.getPassword()).orElse("").trim());
			pstmt.setString(3,Optional.ofNullable(userModel.getStatus()).orElse("0").trim());
			int index  = pstmt.executeUpdate();
			if(index < 1) {
				throw new Exception("Insert user failed");
			}
		} catch (Exception exp) {
			throw exp;
		} finally {
			DatabaseUtil.closeObject(pstmt);
			DatabaseUtil.closeObject(conn);
		}
	}

	@Override
	public UserModel queryUserByUserName(String userName) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String queryUserCommand = "SELECT USERNAME,PASSWORD,STATUS FROM ITS_USER WHERE UPPER(USERNAME) = UPPER(?)";
		UserModel userModel = new UserModel();

		try {
			conn = this.dataSource.getConnection();
			pstmt = conn.prepareStatement(queryUserCommand);
			pstmt.setFetchSize(1);
			pstmt.setString(1, userName);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				userModel.setUserName(rs.getString("USERNAME"));
				userModel.setPassword(rs.getString("PASSWORD"));
				userModel.setStatus(rs.getString("STATUS"));
			}
		} catch (Exception exp) {
			throw exp;
		} finally {
			DatabaseUtil.closeObject(rs);
			DatabaseUtil.closeObject(pstmt);
			DatabaseUtil.closeObject(conn);
		}
		return userModel;
	}

}
