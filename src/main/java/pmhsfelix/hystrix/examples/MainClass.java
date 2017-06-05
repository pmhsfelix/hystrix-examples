package pmhsfelix.hystrix.examples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainClass {

    private static Logger logger = LoggerFactory.getLogger(MainClass.class);

    public static void main(String[] args) throws Exception {
        logger.info("on main");
        Example1Command cmd = new Example1Command();
        logger.info("cmd.run return {}", cmd.execute());

    }

}
