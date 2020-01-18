package com.its.webservice.bussiness.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.its.webservice.bussiness.LoginBussiness;
import com.its.webservice.dao.UserDao;
import com.its.webservice.models.ResponseModel;
import com.its.webservice.models.UserModel;
import com.its.webservice.utils.APIReturnCode;

@Service("LoginBussiness")
public class LoginBussinessManager implements LoginBussiness {

	@Autowired
	private UserDao userDao = null;

	@Override
	public ResponseModel login(String userName, String password) throws Exception {
		ResponseModel responseModel = new ResponseModel();

		try {
			if("".equals(userName) || "".equals(password)) {
				responseModel.setCode(APIReturnCode.API_USERORPASSCANNOTBENULLVALUE);
				return responseModel;
			}
			if(userName.length() > 50) {
				responseModel.setCode(APIReturnCode.API_USEROVER50CHAR);
				return responseModel;
			}
			if(password.length() > 50) {
				responseModel.setCode(APIReturnCode.API_PASSWORDOVER50CHAR);
				return responseModel;
			}
			UserModel userModel = this.userDao.queryUserByUserName(userName);
			
			if(!"1".equals(userModel.getStatus())) {
				responseModel.setCode(APIReturnCode.API_USERISDISABLED);
				return responseModel;
			}
			if(!userName.equals(userModel.getUserName()) || !password.equals(userModel.getPassword())) {
				responseModel.setCode(APIReturnCode.API_USERORPASSWORDINCORRECT);
				return responseModel;
			}
			responseModel.setCode(APIReturnCode.API_SUCCESSFULL);
		} catch (Exception exp) {
			exp.printStackTrace();
			responseModel.setCode(APIReturnCode.API_EXCEPTION);
		}
		return responseModel;
	}

	@Override
	public ResponseModel logout(String userName, String sessionId) throws Exception {
		ResponseModel responseModel = new ResponseModel();

		try {

		} catch (Exception exp) {
			exp.printStackTrace();
			responseModel.setCode(APIReturnCode.API_EXCEPTION);
		}
		return responseModel;
	}

}
