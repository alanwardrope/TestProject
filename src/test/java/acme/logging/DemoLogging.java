package acme.logging;

import org.apache.log4j.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
//import org.testng.log4testng.Logger;

import java.util.*;

/**
 * Created by vanwh on 22/02/2017.
 */
public class DemoLogging {

    static Logger log = Logger.getLogger(DemoLogging.class);
    static Appender append;

    @BeforeClass
    public static void setUpBeforeClass()throws Exception {
        final PatternLayout layout = new PatternLayout();
        layout.setConversionPattern("%d{yyyy-MM-dd} --%-10p %c{1} -%m%n");
        append = new ConsoleAppender(layout);
        log.addAppender(append);
        log.setLevel(Level.DEBUG);

        log.info("Running before method");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {

        log.debug("Running after method");
    }

    @Test
    public void test(){
        log.info("Running test method");

    }

}
