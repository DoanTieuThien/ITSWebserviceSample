package com.its.webservice.config;

import javax.servlet.Filter;
import javax.xml.ws.Endpoint;
import javax.xml.ws.soap.SOAPBinding;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.its.webservice.filter.ITSWebserviceFilter;
import com.its.webservice.services.ITSWebservice;
import com.its.webservice.utils.ErrorMessageProp;
import com.its.ws.ITSWebServicePortType;

@Configuration
public class ITSWebserviceConfig {

	@Bean(name = Bus.DEFAULT_BUS_ID)
	public SpringBus bus() {
		return new SpringBus();
	}

	@Bean
	public Endpoint endpoint() throws Exception {
		EndpointImpl endpoint = new EndpointImpl(bus(), itsWebServicePortType(), SOAPBinding.SOAP12HTTP_BINDING);
		endpoint.publish("/ITSService");
		endpoint.setWsdlLocation("ITSSample.wsdl");
		return endpoint;
	}

	@Bean
	public ITSWebServicePortType itsWebServicePortType() {
		return new ITSWebservice();
	}

	@Bean("errorConfigFileMessage")
	public ErrorMessageProp errorMessage() {
		return new ErrorMessageProp("config/ErrorMessage.txt");
	}

	@Bean
	public Filter filter() {
		return new ITSWebserviceFilter();
	}
}
