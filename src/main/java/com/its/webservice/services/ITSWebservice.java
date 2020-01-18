package com.its.webservice.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.its.webservice.bussiness.ITSWebserviceBussiness;
import com.its.ws.ITSWebServicePortType;
import com.its.ws.itsdatatypes.RetResultType;

public class ITSWebservice implements ITSWebServicePortType {
	private static final Logger log = LoggerFactory.getLogger(ITSWebservice.class);

	@Autowired
	private ITSWebserviceBussiness bussiness = null;

	@Override
	public RetResultType login(String userName, String password) {
		RetResultType retResultType = new RetResultType();
		String functionName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			log.info("Have request execute function " + functionName);
			retResultType = this.bussiness.login(userName, password);
		} catch (Exception exp) {
			exp.printStackTrace();
			log.error("Error request execute function " + functionName, exp);
		}
		log.info("Finished request execute function " + functionName);
		return retResultType;
	}

}
