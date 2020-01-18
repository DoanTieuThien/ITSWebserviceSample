package com.its.ws;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.3.2
 * 2020-01-18T10:47:06.404+07:00
 * Generated source version: 3.3.2
 *
 */
@WebServiceClient(name = "ITSWebService",
                  wsdlLocation = "file:/E:/TNSDemoApp/WebserviceDemo/config/ITSSample.wsdl",
                  targetNamespace = "http://ws.its.com")
public class ITSWebService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://ws.its.com", "ITSWebService");
    public final static QName ITSWebServiceHttpSoap12Endpoint = new QName("http://ws.its.com", "ITSWebServiceHttpSoap12Endpoint");
    static {
        URL url = null;
        try {
            url = new URL("file:/E:/TNSDemoApp/WebserviceDemo/config/ITSSample.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(ITSWebService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "file:/E:/TNSDemoApp/WebserviceDemo/config/ITSSample.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public ITSWebService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public ITSWebService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ITSWebService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public ITSWebService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public ITSWebService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public ITSWebService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns ITSWebServicePortType
     */
    @WebEndpoint(name = "ITSWebServiceHttpSoap12Endpoint")
    public ITSWebServicePortType getITSWebServiceHttpSoap12Endpoint() {
        return super.getPort(ITSWebServiceHttpSoap12Endpoint, ITSWebServicePortType.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ITSWebServicePortType
     */
    @WebEndpoint(name = "ITSWebServiceHttpSoap12Endpoint")
    public ITSWebServicePortType getITSWebServiceHttpSoap12Endpoint(WebServiceFeature... features) {
        return super.getPort(ITSWebServiceHttpSoap12Endpoint, ITSWebServicePortType.class, features);
    }

}