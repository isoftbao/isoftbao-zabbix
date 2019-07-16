package com.isoftbao.zabbix.data;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * <p>****************************************************************************</p>
 * <ul style="margin:15px;">
 * <li>Title      : ZabbixPooledConnectionFactory</li>
 * <li>Description : 描述</li>
 * <li>Version     : 1.0</li>
 * <li>Creation    : 2019年7月8日 下午6:45:23</li>
 * <li>Author      : Jenner</li>
 * </ul>
 * <p> 
 * </p>
 * <p>****************************************************************************</p>
 */
public class ZabbixPooledConnectionFactory extends AbstractZabbixConnectionFactory implements InitializingBean, DisposableBean, ZabbixConnectionFactory {

    @Override
    public ZabbixConnection getConnection() {
        throw new UnsupportedOperationException();
    }

    protected ZabbixConnection postProcessConnection(ZabbixConnection connection) {
        return connection;
    }

    /**
     * Invoked by a BeanFactory on destruction of a singleton.
     *
     * @throws Exception in case of shutdown errors.
     *                   Exceptions will get logged but not rethrown to allow
     *                   other beans to release their resources too.
     */
    @Override
    public void destroy() throws Exception {

    }

    /**
     * Invoked by a BeanFactory after it has set all bean properties supplied
     * (and satisfied BeanFactoryAware and ApplicationContextAware).
     * <p>This method allows the bean instance to perform initialization only
     * possible when all bean properties have been set and to throw an
     * exception in the event of misconfiguration.
     *
     * @throws Exception in the event of misconfiguration (such
     *                   as failure to set an essential property) or if initialization fails.
     */
    @Override
    public void afterPropertiesSet() throws Exception {

    }

}
