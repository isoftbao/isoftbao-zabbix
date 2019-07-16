package com.isoftbao.zabbix.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.isoftbao.zabbix.api.service.ZabbixService;
import com.isoftbao.zabbix.data.RequestBuilder;
import com.isoftbao.zabbix.data.ZabbixRequest;
import com.isoftbao.zabbix.data.ZabbixResponse;
import com.isoftbao.zabbix.data.ZabbixTemplate;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * <p>****************************************************************************</p>
 * <ul style="margin:15px;">
 * <li>Title      : ZabbixServiceImpl</li>
 * <li>Description : 描述</li>
 * <li>Version     : 1.0</li>
 * <li>Creation    : 2019年7月8日 下午6:38:28</li>
 * <li>Author      : Jenner</li>
 * </ul>
 * <p> 
 * </p>
 * <p>****************************************************************************</p>
 */
@Slf4j
@Service
public class ZabbixServiceImpl implements ZabbixService {

    @Autowired
    private ZabbixTemplate zabbixTemplate;

    @Override
    public String getApiVersion() {
        return zabbixTemplate.apiVersion();
    }

	/**
	 * 
	* (non-Javadoc)
	* <p>Title:query</p> 
	* <p>Description: </p> 
	* @param params
	* @param method
	* @return 
	* @see com.isoftbao.zabbix.api.service.ZabbixService#query(com.alibaba.fastjson.JSONObject, java.lang.String)
	 */
	@Override
	public ZabbixResponse query(JSONObject params, String method) {
		return zabbixTemplate.execute(connection -> {
			ZabbixRequest request = RequestBuilder.newBuilder().method(method).build();
			if (params != null) {
				request.setParams(params);
			}
            return connection.execute(request);
        });
	}
}
