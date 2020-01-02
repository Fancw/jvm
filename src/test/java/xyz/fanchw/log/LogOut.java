package xyz.fanchw.log;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.fanchw.FanApp;

@SpringBootTest(classes = {FanApp.class})
@RunWith(Runner.class)
public class LogOut {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void simpleLog4j() {
        logger.trace("这是trace日志...");
        logger.debug("这是debug日志...");
        //SpringBoot默认给我们使用的是info级别的，没有指定级别的就用SpringBoot默认规定的级别；root级别
        logger.info("这是info日志...");
        logger.warn("这是warn日志...");
        logger.error("这是error日志...");

    }
}
