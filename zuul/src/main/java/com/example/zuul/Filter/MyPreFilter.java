package com.example.zuul.Filter;

import com.example.zuul.FilterUtil.Util;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.stereotype.Component;

//@Component
public class MyPreFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
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
