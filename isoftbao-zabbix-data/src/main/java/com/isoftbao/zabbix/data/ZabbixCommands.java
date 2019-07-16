package com.isoftbao.zabbix.data;

/**
 * 
 * <p>****************************************************************************</p>
 * <ul style="margin:15px;">
 * <li>Title      : ZabbixCommands</li>
 * <li>Description : 描述</li>
 * <li>Version     : 1.0</li>
 * <li>Creation    : 2019年7月8日 下午6:44:40</li>
 * <li>Author      : Jenner</li>
 * </ul>
 * <p> 
 * </p>
 * <p>****************************************************************************</p>
 */
public interface ZabbixCommands {

    ZabbixResponse execute(ZabbixRequest zabbixRequest);
}
