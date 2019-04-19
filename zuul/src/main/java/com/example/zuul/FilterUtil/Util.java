package com.example.zuul.FilterUtil;

import com.netflix.zuul.context.RequestContext;

import javax.ws.rs.HEAD;
import java.util.Map;
import java.util.UUID;

public class Util {
    public static final String HADER_ID = "lccid";
    public static String getRequestID(){
        RequestContext context = RequestContext.getCurrentContext();
        Map<String, String> headers = context.getZuulRequestHeaders();
        String id = headers.get(HADER_ID);
        if(id != null) {
            return id;
        }
        String uuID = UUID.randomUUID().toString();
        context.addZuulRequestHeader(HADER_ID,uuID);
         return uuID;
    }
}
