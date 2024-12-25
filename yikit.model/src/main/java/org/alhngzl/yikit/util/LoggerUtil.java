package org.alhngzl.yikit.util;

import java.util.logging.Logger;

public class LoggerUtil {
    private LoggerUtil() {throw new IllegalStateException(LoggerUtil.class.getName());}

    static Logger logger = Logger.getLogger(LoggerUtil.class.getName());

    public static void printInfo(String text){
        logger.info(text);
    }

    public static void printWarning(String text){
        logger.warning(text);
    }
}
