package com.isoftbao.zabbix.data;

import org.springframework.dao.support.PersistenceExceptionTranslator;

/**
 * 
 * <p>****************************************************************************</p>
 * <ul style="margin:15px;">
 * <li>Title      : ZabbixConnectionFactory</li>
 * <li>Description : 描述</li>
 * <li>Version     : 1.0</li>
 * <li>Creation    : 2019年7月8日 下午6:44:49</li>
 * <li>Author      : Jenner</li>
 * </ul>
 * <p> 
 * </p>
 * <p>****************************************************************************</p>
 */
public interface ZabbixConnectionFactory {

    /**
     * @return
     */
    ZabbixConnection getConnection();

    /**
     * Exposes a shared {@link ZabbixExceptionTranslator}.
     *
     * @return will never be {@literal null}.
     */
    PersistenceExceptionTranslator getExceptionTranslator();

}
