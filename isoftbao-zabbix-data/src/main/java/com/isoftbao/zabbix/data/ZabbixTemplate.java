package com.isoftbao.zabbix.data;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.dao.support.PersistenceExceptionTranslator;
import org.springframework.util.Assert;

/**
 * 
 * <p>****************************************************************************</p>
 * <ul style="margin:15px;">
 * <li>Title      : ZabbixTemplate</li>
 * <li>Description : 描述</li>
 * <li>Version     : 1.0</li>
 * <li>Creation    : 2019年7月8日 下午6:43:09</li>
 * <li>Author      : Jenner</li>
 * </ul>
 * <p> 
 * </p>
 * <p>****************************************************************************</p>
 */
public class ZabbixTemplate implements ZabbixOperations, InitializingBean, ApplicationContextAware {

    private ApplicationEventPublisher applicationContext;

    private ZabbixConnectionFactory connectionFactory;

    private final PersistenceExceptionTranslator exceptionTranslator;

    public ZabbixTemplate(ZabbixConnectionFactory zabbixConnectionFactory) {
        Assert.notNull(zabbixConnectionFactory);

        this.connectionFactory = zabbixConnectionFactory;
        this.exceptionTranslator = zabbixConnectionFactory.getExceptionTranslator();
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public ZabbixConnectionFactory getConnectionFactory() {
        return connectionFactory;
    }

    public PersistenceExceptionTranslator getExceptionTranslator() {
        return exceptionTranslator;
    }

    public void afterPropertiesSet() {
        Assert.notNull(connectionFactory, "ZabbixConnectionFactory is required");
    }

    @Override
    public <T> T execute(ZabbixCallback<T> action) {
        Assert.notNull(action);

        try {
            ZabbixConnection conn = this.getConnection();
            return postProcessResult(action.doInZabbix(conn));
        } catch (RuntimeException e) {
            throw potentiallyConvertRuntimeException(e, exceptionTranslator);
        }
    }

    @Override
    public String apiVersion() {
        return execute(connection -> {
            ZabbixRequest request = RequestBuilder.newBuilder().method("apiinfo.version").build();;
            ZabbixResponse response = connection.execute(request);
            return response.getResult().toString();
        });
    }

    private ZabbixConnection getConnection() {
        return getConnectionFactory().getConnection();
    }

    private static RuntimeException potentiallyConvertRuntimeException(RuntimeException ex,
                                                                       PersistenceExceptionTranslator exceptionTranslator) {
        RuntimeException resolved = exceptionTranslator.translateExceptionIfPossible(ex);
        return resolved == null ? ex : resolved;
    }

    protected <T> T postProcessResult(T result) {
        return result;
    }

}
