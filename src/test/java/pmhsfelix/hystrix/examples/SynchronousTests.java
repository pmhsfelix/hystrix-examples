package pmhsfelix.hystrix.examples;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SynchronousTests {

    private static Logger logger = LoggerFactory.getLogger(SynchronousTests.class);

    @Test
    public void test1(){
        logger.info("on test1");
        Example1Command cmd = new Example1Command();
        logger.info("cmd.run return {}", cmd.execute());
    }

}
