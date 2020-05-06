package xyz.fanchw.async;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.fanchw.FanApp;
import xyz.fanchw.task.impl.DefaultAsyncTask;

@SpringBootTest(classes = {FanApp.class})
@RunWith(SpringRunner.class)
@Slf4j
public class AsyncTaskTest {
    @Autowired
    private DefaultAsyncTask defaultAsyncTask;

    @Test
    public void testAsync() throws Exception {
        log.info("{}", defaultAsyncTask.result().get());
    }
}
