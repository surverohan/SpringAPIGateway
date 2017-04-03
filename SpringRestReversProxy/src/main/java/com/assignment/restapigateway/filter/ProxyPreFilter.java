package com.assignment.restapigateway.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class ProxyPreFilter extends ZuulFilter {
    private static final  Logger log = LoggerFactory.getLogger(ProxyPreFilter.class);

    @Override
    public String filterType() {
        return "Pre";
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
    public Object run() {
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();

        log.info( "Url: " +request.getRequestURI()+" For Method: " +request.getMethod());
        return null;
    }
}
