package pmhsfelix.hystrix.examples;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Example1Command extends HystrixCommand<String> {

    private static Logger logger = LoggerFactory.getLogger(Example1Command.class);

    protected Example1Command() {
        super(HystrixCommandGroupKey.Factory.asKey("Example1Group"));
    }

    protected String run() throws Exception {
        logger.info("on run");
        return "hello world";
    }
}
