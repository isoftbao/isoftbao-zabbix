package com.isoftbao.zabbix.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.support.ErrorPageFilter;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;
import org.springframework.web.context.WebApplicationContext;

import com.isoftbao.zabbix.api.config.ZabbixApiModuleConfiguration;

/**
 * 
 * <p>****************************************************************************</p>
 * <ul style="margin:15px;">
 * <li>Title      : ZabbixApiApplication</li>
 * <li>Description : 描述</li>
 * <li>Version     : 1.0</li>
 * <li>Creation    : 2019年7月8日 下午6:40:52</li>
 * <li>Author      : Jenner</li>
 * </ul>
 * <p> 
 * </p>
 * <p>****************************************************************************</p>
 */
@SpringBootApplication
@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class,DataSourceAutoConfiguration.class})
@Import({ZabbixApiModuleConfiguration.class})
public class ZabbixApiApplication extends SpringBootServletInitializer {


    @Override
    protected WebApplicationContext run(SpringApplication application) {
        application.getSources().remove(ErrorPageFilter.class);
        return super.run(application);
    }

    public static void main(String[] args) {
        SpringApplication.run(ZabbixApiApplication.class, args);
    }

}
