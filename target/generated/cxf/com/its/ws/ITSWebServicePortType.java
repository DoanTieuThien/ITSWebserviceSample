package com.its.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.3.2
 * 2020-01-18T10:47:06.361+07:00
 * Generated source version: 3.3.2
 *
 */
@WebService(targetNamespace = "http://ws.its.com", name = "ITSWebServicePortType")
@XmlSeeAlso({ObjectFactory.class, com.its.ws.itsdatatypes.ObjectFactory.class})
public interface ITSWebServicePortType {

    @WebMethod(action = "urn:login")
    @Action(input = "urn:login", output = "ur:processAPIRetResponse")
    @RequestWrapper(localName = "login", targetNamespace = "http://ws.its.com", className = "com.its.ws.Login")
    @ResponseWrapper(localName = "processAPIResponse", targetNamespace = "http://ws.its.com", className = "com.its.ws.ProcessAPIResponse")
    @WebResult(name = "return", targetNamespace = "http://ws.its.com")
    public com.its.ws.itsdatatypes.RetResultType login(

        @WebParam(name = "UserName", targetNamespace = "http://ws.its.com")
        java.lang.String userName,
        @WebParam(name = "Password", targetNamespace = "http://ws.its.com")
        java.lang.String password
    );
}
