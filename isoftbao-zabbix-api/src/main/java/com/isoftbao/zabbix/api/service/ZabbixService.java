package com.isoftbao.zabbix.api.service;

import java.util.HashMap;

import com.alibaba.fastjson.JSONObject;
import com.isoftbao.zabbix.data.ZabbixRequest;
import com.isoftbao.zabbix.data.ZabbixResponse;

/**
 * @author dz
 */
public interface ZabbixService {

    String getApiVersion();


	/**
	 * <li>Title       : query</li>
	 * <li>Description : 描述</li>
	 * <li>Version     : 1.0</li>
	 * <li>Creation    : 2019年7月9日 上午11:35:56</li>
	 * <li>Author      : Jenner</li>
	 * </ul>
	 * <p>
	 * @param params
	 * @param method
	 * @return 
	 * </p>
	 */
	ZabbixResponse query(JSONObject params, String method);


}
