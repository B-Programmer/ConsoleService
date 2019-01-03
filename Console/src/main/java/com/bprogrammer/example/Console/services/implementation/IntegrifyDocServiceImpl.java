package com.bprogrammer.example.Console.services.implementation;

import com.bprogrammer.example.Console.models.IntegrifyRequest;
import com.bprogrammer.example.Console.repository.ServiceStatusRepo;
import com.bprogrammer.example.Console.services.IntegrifyDocService;
import com.bprogrammer.console.doc.integrify_console_service.GetIntegrifyDocRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by B. Programmer on 28/12/2018.
 */
@Service
public class IntegrifyDocServiceImpl implements IntegrifyDocService {

    private static final Logger logger = LoggerFactory.getLogger(IntegrifyDocServiceImpl.class);
    @Autowired
    private RestTemplate restTemplate;

    @Value("${operations.restURL}")
    String serviceURL;

    @Bean
    public RestTemplate rest() {
        return new RestTemplate();
    }

    /***
     * This method is to get the updated documents from Integrify and do necessary update on branch console.
     * This method calls a REST webservice from BranchConsole application to do the update
     * @return
     */
    @Override
    public ServiceStatusRepo updateBCDocumentsFromIntegrify(GetIntegrifyDocRequest postRequest){
        ServiceStatusRepo serviceStatusRepo = new ServiceStatusRepo();
        if(postRequest != null){
            String response = updateDocumentsOnBC(postRequest);
            logger.info("response from rest service is: {}", response);
            if(response.equals("Success")){
                serviceStatusRepo.setStatus("SUCCESS");
                serviceStatusRepo.setMessage("OK");
            }
            else {
                serviceStatusRepo.setStatus("FAILURE");
                serviceStatusRepo.setMessage(response);
            }
            return serviceStatusRepo;
        }
        else {
            serviceStatusRepo.setStatus("FAILURE");
            serviceStatusRepo.setMessage("Empty request payload");
        }
        return serviceStatusRepo;
    }

    /***
     * This is the POST method the communicate to the REST service provided by BC application in order to update its documents
     * @return
     */
    @Override
    public String updateDocumentsOnBC(GetIntegrifyDocRequest postRequest) {
//        return restTemplate.getForObject(setRequestForRest(postRequest,serviceURL), String.class); // this is for GET
        return restTemplate.postForObject(serviceURL, createIntegrifyRequest(postRequest), String.class); //this is for POST
    }

    private Object createIntegrifyRequest(GetIntegrifyDocRequest postRequest) {
        IntegrifyRequest integrifyRequest = new IntegrifyRequest();
        integrifyRequest.setAccountNumber(postRequest.getAccountNumber());
        integrifyRequest.setAccountType(postRequest.getAccountType());
        integrifyRequest.setDocProvided(postRequest.getDocProvided());
        integrifyRequest.setSchemeCode(postRequest.getSchemeCode());
        integrifyRequest.setAccountCategory(postRequest.getAccountCategory());
        integrifyRequest.setDeferralInPlace(postRequest.getDeferralInPlace());
        integrifyRequest.setDeferralApprover(postRequest.getDeferralApprover());
        integrifyRequest.setDeferralExpiryDate(postRequest.getDeferralExpiryDate());
        logger.info("Request for the rest service is: {}", integrifyRequest);
        return integrifyRequest;
    }

    public String setRequestForRest(GetIntegrifyDocRequest postRequest, String restUrl) {
        IntegrifyRequest integrifyRequest = (IntegrifyRequest)createIntegrifyRequest(postRequest);
//        http://172.27.15.69:9000/integrify/documentUpdate/?AccountNumber=4390456011&AccountType=IND NEW&DocProvided=Initial Deposit Taken,KYC Form Verified,Passport Photograph,Utility Bill,BVN&SchemeCode=OD255&AccountCategory=&DeferralInPlace=Not Applicable&DeferralApprover=NULL&DeferralExpiryDate=NULL
        return restUrl+"?" +
                "AccountNumber=" + integrifyRequest.getAccountNumber() +
                "&AccountType='" + integrifyRequest.getAccountType() +
                "&DocProvided='" + integrifyRequest.getDocProvided() +
                "&SchemeCode='" + integrifyRequest.getSchemeCode() +
                "&AccountCategory='" + integrifyRequest.getAccountCategory() +
                "&DeferralInPlace='" + integrifyRequest.getDeferralInPlace() +
                "&DeferralApprover='" + integrifyRequest.getDeferralApprover() +
                "&DeferralExpiryDate='" + integrifyRequest.getDeferralExpiryDate() +
                "";
    }

}
