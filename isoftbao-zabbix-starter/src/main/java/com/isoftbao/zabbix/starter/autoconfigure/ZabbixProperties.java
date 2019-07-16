package com.isoftbao.zabbix.starter.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.isoftbao.zabbix.data.ConnectOptions;

/**
 * 
 * <p>****************************************************************************</p>
 * <ul style="margin:15px;">
 * <li>Title      : ZabbixProperties</li>
 * <li>Description : Configuration properties for Zabbix.</li>
 * <li>Version     : 1.0</li>
 * <li>Creation    : 2019年7月8日 下午6:00:04</li>
 * <li>Author      : Jenner</li>
 * </ul>
 * <p> 
 * </p>
 * <p>****************************************************************************</p>
 */
@ConfigurationProperties(prefix = "com.isoftbao.zabbix")
public class ZabbixProperties extends ConnectOptions {

    private ZabbixProperties.Pool pool;

    public Pool getPool() {
        return pool;
    }

    public void setPool(Pool pool) {
        this.pool = pool;
    }

    public static class Pool {

        private int maxIdle = 8;
        private int minIdle = 0;
        private int maxActive = 8;
        private int maxWait = -1;

        public Pool() {
        }

        public int getMaxIdle() {
            return this.maxIdle;
        }

        public void setMaxIdle(int maxIdle) {
            this.maxIdle = maxIdle;
        }

        public int getMinIdle() {
            return this.minIdle;
        }

        public void setMinIdle(int minIdle) {
            this.minIdle = minIdle;
        }

        public int getMaxActive() {
            return this.maxActive;
        }

        public void setMaxActive(int maxActive) {
            this.maxActive = maxActive;
        }

        public int getMaxWait() {
            return this.maxWait;
        }

        public void setMaxWait(int maxWait) {
            this.maxWait = maxWait;
        }
    }
}
