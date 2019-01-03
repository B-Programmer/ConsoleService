package com.bprogrammer.example.Console.models;

/**
 * Created by B. Programmer on 28/12/2018.
 */
public class IntegrifyRequest {
    private String AccountNumber;
    private String AccountType;
    private String DocProvided;
    private String SchemeCode;
    private String AccountCategory;
    private String DeferralInPlace;
    private String DeferralApprover;
    private String DeferralExpiryDate;

    public  IntegrifyRequest(){}

    public String getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        AccountNumber = accountNumber;
    }

    public String getAccountType() {
        return AccountType;
    }

    public void setAccountType(String accountType) {
        AccountType = accountType;
    }

    public String getDocProvided() {
        return DocProvided;
    }

    public void setDocProvided(String docProvided) {
        DocProvided = docProvided;
    }

    public String getSchemeCode() {
        return SchemeCode;
    }

    public void setSchemeCode(String schemeCode) {
        SchemeCode = schemeCode;
    }

    public String getAccountCategory() {
        return AccountCategory;
    }

    public void setAccountCategory(String accountCategory) {
        AccountCategory = accountCategory;
    }

    public String getDeferralInPlace() {
        return DeferralInPlace;
    }

    public void setDeferralInPlace(String deferralInPlace) {
        DeferralInPlace = deferralInPlace;
    }

    public String getDeferralApprover() {
        return DeferralApprover;
    }

    public void setDeferralApprover(String deferralApprover) {
        DeferralApprover = deferralApprover;
    }

    public String getDeferralExpiryDate() {
        return DeferralExpiryDate;
    }

    public void setDeferralExpiryDate(String deferralExpiryDate) {
        DeferralExpiryDate = deferralExpiryDate;
    }

    @Override
    public String toString() {
        return "IntegrifyRequest{" +
                "AccountNumber=" + AccountNumber +
                ", AccountType='" + AccountType + '\'' +
                ", DocProvided='" + DocProvided + '\'' +
                ", SchemeCode='" + SchemeCode + '\'' +
                ", AccountCategory='" + AccountCategory + '\'' +
                ", DeferralInPlace='" + DeferralInPlace + '\'' +
                ", DeferralApprover='" + DeferralApprover + '\'' +
                ", DeferralExpiryDate='" + DeferralExpiryDate + '\'' +
                '}';
    }
}
