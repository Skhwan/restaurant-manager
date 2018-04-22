package com.restaurant.util;

import org.springframework.stereotype.Service;

/**
 * Created by khwanchanok on 4/22/2018 AD.
 */
@Service
public class ResponseWrapper {

    private String responseCode;
    private String responseDesc;
    private String responseStatus;

    public void setResponseCode(String responseCode){
        this.responseCode = responseCode;
    }

    public void setResponseDesc(String responseDesc){
        this.responseDesc = responseDesc;
    }

    public void setResponseStatus(String responseStatus){
        this.responseStatus = responseStatus;
    }

    public String getResponseCode(){
        return responseCode;
    }

    public String getResponseDesc(){
        return responseDesc;
    }

    public String getResponseStatus(){
        return responseStatus;
    }

    @Override
    public String toString(){
        return "ResponseWrapper:{" +
                " resultCode=" + getResponseCode() +
                " resultStatus=" + getResponseStatus() +
                " resultDesc=" + getResponseDesc() +
                " }";
    }
}
