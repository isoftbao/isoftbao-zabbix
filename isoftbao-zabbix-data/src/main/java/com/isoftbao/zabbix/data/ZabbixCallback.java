package com.isoftbao.zabbix.data;

import org.springframework.dao.DataAccessException;

/**
 * 
 * <p>****************************************************************************</p>
 * <ul style="margin:15px;">
 * <li>Title      : ZabbixCallback</li>
 * <li>Description : 描述</li>
 * <li>Version     : 1.0</li>
 * <li>Creation    : 2019年7月8日 下午6:44:35</li>
 * <li>Author      : Jenner</li>
 * </ul>
 * <p>
 * @param <T> 
 * </p>
 * <p>****************************************************************************</p>
 */
public interface ZabbixCallback<T> {

    /**
     * Gets called by {@link ZabbixTemplate} with an active Zabbix connection. Does not need to care about activating or
     * closing the connection or handling exceptions.
     *
     * @param connection active Zabbix connection
     * @return a result object or {@code null} if none
     * @throws DataAccessException
     */
    T doInZabbix(ZabbixConnection connection) throws DataAccessException;

}
