/**
 * 
 */
package com.saika.pharmacydemo;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;

/**
 * @author vinodbottu
 *
 */
public class CORSFilter implements ContainerResponseFilter {

	@Override
	public void filter(ContainerRequestContext requestCtx, ContainerResponseContext responseCtx) throws IOException {
		MultivaluedMap<String, Object> headersMap = responseCtx.getHeaders();
		headersMap.add("Access-Control-Allow-Origin", "*");
		headersMap.add("Access-Control-Allow-Methods", "GET,POST,DELETE,PUT,OPTIONS");
		headersMap.add("Access-Control-Allow-Headers", "X-Requested-With,Content-Type,X-Codingpedia");
	}

}
