package com.isoftbao.zabbix.data;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

/**
 * 
 * <p>****************************************************************************</p>
 * <ul style="margin:15px;">
 * <li>Title      : RestTemplateHeaderInterceptor</li>
 * <li>Description : 描述</li>
 * <li>Version     : 1.0</li>
 * <li>Creation    : 2019年7月8日 下午6:44:29</li>
 * <li>Author      : Jenner</li>
 * </ul>
 * <p> 
 * </p>
 * <p>****************************************************************************</p>
 */
public class RestTemplateHeaderInterceptor implements ClientHttpRequestInterceptor {

    private static final String APPLICATION_JSON = "application/json";

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws
                                                                                                                IOException {
        HttpHeaders headers = request.getHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, APPLICATION_JSON);
        return execution.execute(request, body);
    }

}