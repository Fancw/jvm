package xyz.fanchw.log;

import org.apache.log4j.Logger;

public class LogOut {

    public static void main(String[] args) {
        final Logger logger = Logger.getLogger(LogOut.class);
        final Logger saveUserLog = Logger.getLogger("saveUserLog");
        if (logger.isDebugEnabled()) {
            logger.debug("debug");
        }

        logger.info("info");
        logger.error("error");

        saveUserLog.info("张三,男,26岁,北京大学,2018-05-19,学霸");
    }
}
