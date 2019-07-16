package com.isoftbao.zabbix.api.web.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.isoftbao.zabbix.api.service.ZabbixService;
import com.isoftbao.zabbix.data.RequestBuilder;
import com.isoftbao.zabbix.data.ZabbixRequest;
import com.isoftbao.zabbix.data.ZabbixResponse;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * <p>****************************************************************************</p>
 * <ul style="margin:15px;">
 * <li>Title      : ZabbixRestController</li>
 * <li>Description : 描述</li>
 * <li>Version     : 1.0</li>
 * <li>Creation    : 2019年7月8日 下午6:41:47</li>
 * <li>Author      : Jenner</li>
 * </ul>
 * <p> 
 * </p>
 * <p>****************************************************************************</p>
 */
@RequestMapping("/api/")
@RestController
public class ZabbixRestController {

	@Resource
    private ZabbixService zabbixService;

    @RequestMapping(value = "version", method = RequestMethod.GET)
    public ZabbixResponse getApiVerison() {
    	return zabbixService.query(null, "apiinfo.version");
    }
    
    /**
     * 
     * <li>Title       : query</li>
     * <li>Description : 描述</li>
     * <li>Version     : 1.0</li>
     * <li>Creation    : 2019年7月9日 下午2:19:46</li>
     * <li>Author      : Jenner</li>
     * </ul>
     * <p>
     * @param method
     * @return 
     * </p>
     */
    @RequestMapping(value = "/{method}", method = RequestMethod.GET,produces = {"application/json;charset=UTF-8"},consumes= {"application/json"})
    public ZabbixResponse query(@PathVariable("method") String method) {
        return zabbixService.query(null,method);
    }
    
    
    /**
     * 
     * <li>Title       : query</li>
     * <li>Description : 查询 API</li>
     * <li>Version     : 1.0</li>
     * <li>Creation    : 2019年7月9日 上午11:00:56</li>
     * <li>Author      : Jenner</li>
     * </ul>
     * <p>
     * @param params
     * @param method
     * @return 
     * 
     * produces:指定返回值类型,设定返回值的字符编码
     * consumes:仅处理request Content-Type为“application/json”类型的请求
     * </p>
     */
    @RequestMapping(value = "/{method}", method = RequestMethod.POST,produces = {"application/json;charset=UTF-8"},consumes= {"application/json"})
    public ZabbixResponse query(@RequestBody JSONObject params,@PathVariable("method") String method) {
        return zabbixService.query(params,method);
    }


}
