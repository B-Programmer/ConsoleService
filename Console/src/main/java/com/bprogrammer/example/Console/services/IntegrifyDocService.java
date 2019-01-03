package com.bprogrammer.example.Console.services;

import com.bprogrammer.example.Console.repository.ServiceStatusRepo;
import com.bprogrammer.console.doc.integrify_console_service.GetIntegrifyDocRequest;

/**
 * Created by B. Programmer on 28/12/2018.
 */
public interface IntegrifyDocService {
    ServiceStatusRepo updateBCDocumentsFromIntegrify(GetIntegrifyDocRequest postRequest);
    String updateDocumentsOnBC(GetIntegrifyDocRequest postRequest);

}