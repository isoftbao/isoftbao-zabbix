package com.isoftbao.zabbix.data;

import org.apache.commons.lang3.StringUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.PermissionDeniedDataAccessException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;

import lombok.extern.slf4j.Slf4j;


/**
 * 
 * <p>
 * ****************************************************************************
 * </p>
 * <ul style="margin:15px;">
 * <li>Title : ZabbixRestConnection</li>
 * <li>Description : 描述</li>
 * <li>Version : 1.0</li>
 * <li>Creation : 2019年7月8日 下午6:45:37</li>
 * <li>Author : Jenner</li>
 * </ul>
 * <p>
 * </p>
 * <p>
 * ****************************************************************************
 * </p>
 */
@Slf4j
public class ZabbixRestConnection implements ZabbixConnection {

	private boolean initialized = false;

	private ConnectOptions connectOptions;

	private RestTemplate restTemplate;

	private String authToken;

	public ZabbixRestConnection(RestTemplate restTemplate, ConnectOptions connectOptions) {
		this.restTemplate = restTemplate;
		this.connectOptions = connectOptions;
	}

	/**
	 * Init the connection.
	 */
	@Override
	public void init() {
		if (!this.initialized) {
			// do auth
			ZabbixRequest request = RequestBuilder.newBuilder().paramEntry("user", this.connectOptions.getUsername())
					.paramEntry("password", this.connectOptions.getPassword()).method("user.login").build();

			JSONObject zabbixResponse = this.restTemplate.postForObject(this.connectOptions.getUrl(), request,JSONObject.class);

			String auth = zabbixResponse.getString("result");
			if (auth != null && !auth.isEmpty()) {
				this.authToken = auth;
				this.initialized = true;
			} else {
				throw new ZabbixException("Incorrect username or credential");
			}
		}
	}

	/**
	 * Indicates whether the underlying connection is initialized or not.
	 *
	 * @return true if the connection is initialized, false otherwise.
	 */
	@Override
	public boolean isInitialized() {
		return this.initialized;
	}

	@Override
	public ZabbixResponse execute(ZabbixRequest zabbixRequest) {
		if (StringUtils.isEmpty(zabbixRequest.getAuth())) {
			if (!this.initialized) {
				throw new ZabbixException("The connection is not initialized.");
			}

			if (!zabbixRequest.getMethod().contains("apiinfo")) {
				zabbixRequest.setAuth(this.authToken);
			}
			
		}

		// do rest quest
		// get
		// post
		// put
		// delete
		// others
		return doExecute(zabbixRequest);
		// throw new ZabbixException(String.format("Unsupported zabbix request method
		// %s", zabbixRequest.getMethod()));
	}

	private ZabbixResponse doExecute(ZabbixRequest zabbixRequest) {
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.add("org", "isoftbao.com");
		requestHeaders.add("dev", "Jenner Michael");
//		requestHeaders.add("Accept", "application/json");
//		requestHeaders.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> requestEntity = new HttpEntity(zabbixRequest, requestHeaders);
		
		log.debug("zabbixRequest:{}",requestEntity);
		
		ResponseEntity<ZabbixResponse> response = restTemplate.exchange(this.connectOptions.getUrl(), HttpMethod.POST,requestEntity, ZabbixResponse.class);
		
		log.debug("zabbixResponse:{}",response);
		log.debug("zabbixResponse.body:{}",response.getBody());
		return response.getBody();
	}

	/**
	 * Closes (or quits) the connection.
	 *
	 * @throws DataAccessException
	 */
	@Override
	public void close() throws DataAccessException {
	}

	/**
	 * Indicates whether the underlying connection is closed or not.
	 *
	 * @return true if the connection is closed, false otherwise.
	 */
	@Override
	public boolean isClosed() {
		return false;
	}
}
