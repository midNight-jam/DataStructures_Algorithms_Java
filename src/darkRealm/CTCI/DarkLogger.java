package darkRealm.CTCI;

import java.io.IOException;
import java.util.logging.*;

/**
 * Created by Jayam on 12/20/2016.
 */
public class DarkLogger {
  private static FileHandler fileTxt;
  private static SimpleFormatter formatter;

  public static void setup() throws IOException {
    Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    // suppressing logging in Console
    Logger rootLogger = Logger.getLogger("");
    Handler[] handlers = rootLogger.getHandlers();
    if (handlers[0] instanceof ConsoleHandler) {
      rootLogger.removeHandler(handlers[0]);
    }

    logger.setLevel(Level.INFO);
    fileTxt = new FileHandler("megaCTCI.log",true);
    formatter = new SimpleFormatter();
    fileTxt.setFormatter(formatter);
    logger.addHandler(fileTxt);
  }
}