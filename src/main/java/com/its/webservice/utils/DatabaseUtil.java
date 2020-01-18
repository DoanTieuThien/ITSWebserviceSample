package com.its.webservice.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseUtil {
	public static void closeObject(Object o) {
		if (o == null) {
			return;
		}
		if (o instanceof ResultSet) {
			try {
				((ResultSet) o).close();
			} catch (Exception exp) {
			}
			o = null;
		} else if (o instanceof PreparedStatement) {
			try {
				((PreparedStatement) o).close();
			} catch (Exception exp) {
			}
			o = null;
		} else if (o instanceof Connection) {
			try {
				((Connection) o).close();
			} catch (Exception exp) {
			}
			o = null;
		}
	}
}
