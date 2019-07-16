package com.isoftbao.zabbix.data;

import org.springframework.dao.*;
import org.springframework.dao.support.PersistenceExceptionTranslator;
import org.springframework.util.ClassUtils;

/**
 * 
 * <p>****************************************************************************</p>
 * <ul style="margin:15px;">
 * <li>Title      : ZabbixExceptionTranslator</li>
 * <li>Description : 描述</li>
 * <li>Version     : 1.0</li>
 * <li>Creation    : 2019年7月8日 下午6:45:09</li>
 * <li>Author      : Jenner</li>
 * </ul>
 * <p> 
 * Simple {@link PersistenceExceptionTranslator} for Zabbix. Convert the given runtime exception to an appropriate
 * exception from the {@code org.springframework.dao} hierarchy. Return {@literal null} if no translation is
 * appropriate: any other exception may have resulted from user code, and should not be translated.
 * </p>
 * <p>****************************************************************************</p>
 */
public class ZabbixExceptionTranslator implements PersistenceExceptionTranslator {

    /*
     * (non-Javadoc)
     * @see org.springframework.dao.support.PersistenceExceptionTranslator#translateExceptionIfPossible(java.lang.RuntimeException)
     */
    @Override
    public DataAccessException translateExceptionIfPossible(RuntimeException ex) {

        String exception = ClassUtils.getShortName(ClassUtils.getUserClass(ex.getClass()));

        //TODO

        // All other ZabbixExceptions
        if (ex instanceof ZabbixException) {
            //TODO
        }

        // If we get here, we have an exception that resulted from user code,
        // rather than the persistence provider, so we return null to indicate
        // that translation should not occur.
        return null;
    }

    public static final class ZabbixErrorCodes {

    }
}
