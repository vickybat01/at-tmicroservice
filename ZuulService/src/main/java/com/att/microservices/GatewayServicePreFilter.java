package com.att.microservices;

import org.springframework.http.HttpStatus;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class GatewayServicePreFilter extends ZuulFilter {
//We can do a ton of things here. Like creating a session and wrapping in a cookie, creating jwt and a lot of URL validations
	@Override
	public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        
        String requestURI=ctx.getRequest().getRequestURI();
        String remoteHost=ctx.getRequest().getRemoteAddr();
        
        if(	requestURI != null && requestURI.contains("/att/")) {
        	ctx.addZuulRequestHeader("testHeader", "testHeader");
        	//return null;
        }else{
        	sendInvalidUrlResponse(ctx);
        }
        
		return null;
	}

	
	private void sendInvalidUrlResponse(RequestContext ctx)
    {
        ctx.setSendZuulResponse(false);
        ctx.getResponse().setContentType("'application/json'");
        ctx.setResponseStatusCode(HttpStatus.BAD_REQUEST.value());
        String response = "{\"statusCode\": \"40001\", \"description\": \"Indicates that url is incorrect and missing att\"}";
        ctx.setResponseBody(response);
    }
    
	
	
	
	
	@Override
	public boolean shouldFilter() {
		
		return true;
	}

	@Override
	public int filterOrder() {
		
		return 0;
	}

	@Override
	public String filterType() {
		
		return "pre";
	}

}
