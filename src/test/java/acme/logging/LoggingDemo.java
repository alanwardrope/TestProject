package acme.logging;

import java.util.*;
import org.apache.log4j.*;

/**
 * Created by vanwh on 22/02/2017.
 */
public class LoggingDemo {

    static Logger log = Logger.getLogger(LoggingDemo.class);

    /*
    * Debug
    * Info
    * Warn
    * Error
    * Fatal
    * @param args
     */
    public static void main(String[] args){

        //BasicConfigurator.configure();
        Properties log4jprop = new Properties();
        log4jprop.setProperty("log4j.rootLogger", "DEBUG, CA");
        log4jprop.setProperty("log4j.appender.CA", "org.apache.log4j.ConsoleAppender");
        log4jprop.setProperty("log4j.appender.CA.layout", "org.apache.log4j.PatternLayout");
        log4jprop.setProperty("log4j.appender.CA.layout.ConversionPattern", "%d{yyyy-MM-dd} -- %-10p %c - %m%n");
        PropertyConfigurator.configure(log4jprop);
        log.info("This message is of type info");
        runMethod();
        log.debug("This message is of type debug");

    }

    public static void runMethod(){
        log.info("This message is of type info from runMethod");
    }
}
