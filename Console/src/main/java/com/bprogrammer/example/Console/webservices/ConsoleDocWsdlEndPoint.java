package com.bprogrammer.example.Console.webservices;

import com.bprogrammer.example.Console.repository.ServiceStatusRepo;
import com.bprogrammer.example.Console.services.IntegrifyDocService;
import com.bprogrammer.example.Console.services.implementation.IntegrifyDocServiceImpl;
import com.bprogrammer.console.doc.integrify_console_service.GetConsoleDocRequest;
import com.bprogrammer.console.doc.integrify_console_service.GetConsoleDocResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * Created by B. Programmer on 28/12/2018.
 */
@Endpoint
public class ConsoleDocWsdlEndPoint {
    private static final String NAMESPACE_URI = "http://console.bprogrammer.com/doc/integrify-console-service";
    private static final Logger logger = LoggerFactory.getLogger(ConsoleDocWsdlEndPoint.class);

    @Autowired
    private IntegrifyDocService integrifyDocService;

    @Autowired
    private ServiceStatusRepo consoleStatusRepo;


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getConsoleDocRequest")
    @ResponsePayload
    public GetConsoleDocResponse getConsoleStatus(@RequestPayload GetConsoleDocRequest request) {
        GetConsoleDocResponse response = new GetConsoleDocResponse();
        logger.info("ConsoleDocRequest payload from SOAP service: {}", request);
//        serviceStatusRepo = integrifyDocService.updateBCDocumentsFromIntegrify(request);
        response.setServiceStatus(ServiceStatusRepo.getConsoleStatus(consoleStatusRepo));

        return response;
    }
}