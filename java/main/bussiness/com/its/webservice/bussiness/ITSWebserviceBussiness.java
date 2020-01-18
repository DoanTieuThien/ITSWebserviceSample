package com.its.webservice.bussiness;

import com.its.ws.itsdatatypes.RetResultType;

public interface ITSWebserviceBussiness {
	public RetResultType login(String userName, String password) throws Exception;
}
