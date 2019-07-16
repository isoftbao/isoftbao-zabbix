package com.isoftbao.zabbix.data;

import org.springframework.dao.DataAccessException;

/**
 * 
 * <p>****************************************************************************</p>
 * <ul style="margin:15px;">
 * <li>Title      : ZabbixConnection</li>
 * <li>Description : 描述</li>
 * <li>Version     : 1.0</li>
 * <li>Creation    : 2019年7月8日 下午6:44:45</li>
 * <li>Author      : Jenner</li>
 * </ul>
 * <p> 
 * </p>
 * <p>****************************************************************************</p>
 */
public interface ZabbixConnection extends ZabbixCommands {

    /**
     * Init the connection.
     *
     * @throws DataAccessException
     */
    void init() throws DataAccessException;

    /**
     * Indicates whether the underlying connection is initialized or not.
     *
     * @return true if the connection is initialized, false otherwise.
     */
    boolean isInitialized();

    /**
     * Closes (or quits) the connection.
     *
     * @throws DataAccessException
     */
    void close() throws DataAccessException;

    /**
     * Indicates whether the underlying connection is closed or not.
     *
     * @return true if the connection is closed, false otherwise.
     */
    boolean isClosed();

}
