package com.bprogrammer.example.Console.repository;

import com.bprogrammer.console.doc.integrify_console_service.ServiceStatus;
import com.bprogrammer.console.doc.integrify_console_service.ConsoleStatus;

/**
 * Created by B. Programmer on 28/012/2018.
 */

public class ServiceStatusRepo {
    private String status;
    private String message;

    public ServiceStatusRepo(){}

    public ServiceStatusRepo(String status, String message){
        this.status = status;
        this.message =message;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static ServiceStatus getServiceStatus(ServiceStatusRepo serviceStatusRepo){
        ServiceStatus serviceStatus = new ServiceStatus();
        serviceStatus.setStatus(serviceStatusRepo.getStatus());
        serviceStatus.setMessage(serviceStatusRepo.getMessage());
        return serviceStatus;
    }

    public static ConsoleStatus getConsoleStatus(ServiceStatusRepo serviceStatusRepo){
        ConsoleStatus serviceStatus = new ConsoleStatus();
        serviceStatus.setStatus(serviceStatusRepo.getStatus());
        serviceStatus.setMessage(serviceStatusRepo.getMessage());
        return serviceStatus;
    }
}
