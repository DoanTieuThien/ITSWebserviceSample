package com.its.webservice.bussiness.manager;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.its.webservice.bussiness.ITSWebserviceBussiness;
import com.its.webservice.bussiness.LoginBussiness;
import com.its.webservice.models.ResponseModel;
import com.its.webservice.utils.APIReturnCode;
import com.its.webservice.utils.ErrorMessageProp;
import com.its.ws.itsdatatypes.RetResultType;

@Service("ITSWebserviceBussiness")
public class ITSWebserviceBussinessManager implements ITSWebserviceBussiness {

	@Autowired
	private LoginBussiness loginBussiness = null;
	@Autowired
	private ErrorMessageProp errorMessage = null;

	@Override
	public RetResultType login(String userName, String password) throws Exception {
		RetResultType retResultType = new RetResultType();
		ResponseModel responseModel = this.loginBussiness.login(Optional.ofNullable(userName).orElse("").trim(),
				Optional.ofNullable(password).orElse("").trim());
		String statusCode = responseModel.getCode();
		retResultType.setStatus(statusCode);
		retResultType.setMessage(this.errorMessage.getValue(statusCode));
		if (APIReturnCode.API_SUCCESSFULL.equals(statusCode)) {
			retResultType.setPayload(UUID.randomUUID().toString());
		}
		return retResultType;
	}

}
