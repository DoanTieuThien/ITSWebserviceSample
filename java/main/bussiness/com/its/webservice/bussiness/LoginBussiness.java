package com.its.webservice.bussiness;

import com.its.webservice.models.ResponseModel;

public interface LoginBussiness {
	public ResponseModel login(String userName, String password) throws Exception;
	
	public ResponseModel logout(String userName, String sessionId) throws Exception;
}
