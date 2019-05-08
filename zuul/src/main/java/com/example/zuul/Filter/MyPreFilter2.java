package com.example.zuul.Filter;

import com.example.zuul.FilterUtil.Util;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

//@Component
public class MyPreFilter2 extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 2;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        String id = Util.getRequestID();
        System.out.println("Type:"+ filterType() + "order:" +filterOrder() +"  "+ id);
        return null;
    }


}
