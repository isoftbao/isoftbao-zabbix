package com.isoftbao.zabbix.data;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;


/**
 * 
 * <p>****************************************************************************</p>
 * <ul style="margin:15px;">
 * <li>Title      : ZabbixRequest</li>
 * <li>Description : 描述</li>
 * <li>Version     : 1.0</li>
 * <li>Creation    : 2019年7月8日 下午6:45:27</li>
 * <li>Author      : Jenner</li>
 * </ul>
 * <p> 
 * </p>
 * <p>****************************************************************************</p>
 */
@Data
public class ZabbixRequest {

    private String jsonrpc = Constants.JSONRPC_VERSION;

    private Map<String, Object> params = new HashMap<>();

    private String method;

    private String auth;

    private Integer id;

    public void putParam(String key, Object value) {
        params.put(key, value);
    }

    public Object removeParam(String key) {
        return params.remove(key);
    }

}
