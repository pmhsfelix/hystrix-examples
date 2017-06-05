package pmhsfelix.hystrix.examples;

import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixObservableCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rx.Observable;

import java.util.concurrent.TimeUnit;

public class Example2Command extends HystrixObservableCommand<String> {

    private static Logger logger = LoggerFactory.getLogger(Example2Command.class);

    protected Example2Command() {
        super(
              Setter
                    .withGroupKey(HystrixCommandGroupKey.Factory.asKey("Example2Group"))
                    .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                            .withExecutionTimeoutInMilliseconds(2000)
                    )
                );
    }

    @Override
    protected Observable<String> construct() {
        logger.info("on construct");
        return Observable
                .just("hello world")
                .delay(1000, TimeUnit.MILLISECONDS);
    }
}
