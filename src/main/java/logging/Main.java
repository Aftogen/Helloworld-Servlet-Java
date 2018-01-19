package logging;

import java.io.IOException;
import java.util.logging.*;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) throws IOException {
        //-Djava.util.logging.config.file=C:\Users\A\Desktop\kek\src\main\java\logging\logging.properties
        // LogManager.getLogManager().readConfiguration();
        // logger.info("msge");
        //System.out.println(System.getProperty("java.util.logging.config.file"));
        Handler console= new ConsoleHandler();
        Handler fileHandler = new FileHandler();
        logger.setUseParentHandlers(false);
        logger.addHandler(fileHandler);

        logger.log(Level.FINER, "finer");
        logger.log(Level.INFO, "info");
        logger.log(Level.WARNING, "warning");
        logger.info("asdasd");
        logger.info("asdasdmax");

    }
    static class MuFilter implements Filter{
        @Override
        public boolean isLoggable(LogRecord record) {
            return false;
        }
    }
}
