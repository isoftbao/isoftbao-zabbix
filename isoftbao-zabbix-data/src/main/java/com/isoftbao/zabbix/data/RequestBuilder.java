package com.isoftbao.zabbix.data;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * <p>****************************************************************************</p>
 * <ul style="margin:15px;">
 * <li>Title      : RequestBuilder</li>
 * <li>Description : 描述</li>
 * <li>Version     : 1.0</li>
 * <li>Creation    : 2019年7月8日 下午6:44:23</li>
 * <li>Author      : Jenner</li>
 * </ul>
 * <p> 
 * </p>
 * <p>****************************************************************************</p>
 */
public class RequestBuilder {

    private static final AtomicInteger nextId = new AtomicInteger(1);

    private ZabbixRequest request = new ZabbixRequest();

    private RequestBuilder() {

    }

    static public RequestBuilder newBuilder() {
        return new RequestBuilder();
    }

    public ZabbixRequest build() {
        if (request.getId() == null) {
            request.setId(nextId.getAndIncrement());
        }
        return request;
    }

    public RequestBuilder version(String version) {
        request.setJsonrpc(version);
        return this;
    }

    public RequestBuilder paramEntry(String key, Object value) {
        request.putParam(key, value);
        return this;
    }

    /**
     * Do not necessary to call this method.If don not set id, ZabbixOperation will auto set request auth..
     *
     * @param auth
     * @return
     */
    public RequestBuilder auth(String auth) {
        request.setAuth(auth);
        return this;
    }

    public RequestBuilder method(String method) {
        request.setMethod(method);
        return this;
    }
    
    public RequestBuilder param(Map<String, Object> params) {
        request.setParams(params);
        return this;
    }

    /**
     * Do not necessary to call this method.If don not set id, RequestBuilder will auto generate.
     *
     * @param id
     * @return
     */
    public RequestBuilder id(Integer id) {
        request.setId(id);
        return this;
    }

}
