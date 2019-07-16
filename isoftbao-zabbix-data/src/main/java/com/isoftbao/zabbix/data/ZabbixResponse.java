package com.isoftbao.zabbix.data;


import lombok.Data;

/**
 * 
 * <p>****************************************************************************</p>
 * <ul style="margin:15px;">
 * <li>Title      : ZabbixResponse</li>
 * <li>Description : 描述</li>
 * <li>Version     : 1.0</li>
 * <li>Creation    : 2019年7月8日 下午6:45:32</li>
 * <li>Author      : Jenner</li>
 * </ul>
 * <p> 
 * </p>
 * <p>****************************************************************************</p>
 */
@Data
public class ZabbixResponse {

    private String jsonrpc = Constants.JSONRPC_VERSION;

    private Object result;

    private Integer id;

}
