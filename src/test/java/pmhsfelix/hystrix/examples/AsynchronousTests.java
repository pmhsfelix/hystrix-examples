package pmhsfelix.hystrix.examples;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

public class AsynchronousTests {

    private static Logger logger = LoggerFactory.getLogger(AsynchronousTests.class);

    @Test
    public void test1(){
        logger.info("on test1");
        Example1Command cmd = new Example1Command();
        cmd.observe()
                .subscribe(s -> {
                    logger.info("subscribe produces '{}'", s);
                });
        logger.info("end");
    }

    @Test
    public void test2() throws InterruptedException {
        logger.info("on test2");
        final CountDownLatch l = new CountDownLatch(1);
        Example2Command cmd = new Example2Command();
        cmd.toObservable()
                .subscribe(s -> {
                    logger.info("subscribe produces '{}'", s);
                    l.countDown();
                });
        logger.info("end");
        l.await();
    }

}
