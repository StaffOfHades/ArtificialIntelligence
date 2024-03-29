package system.debugging;

/**
 * Default Template. Information about thus class should go here
 * Created by mauriciog on 9/10/15 for Artificial Intelligence
 */
public class Log {

    private static final String ANSI_RESET = "\u001B[0m";
    public static final String
            ANSI_BLACK = "\u001B[30m",
            ANSI_RED = "\u001B[31m",
            ANSI_GREEN = "\u001B[32m",
            ANSI_YELLOW = "\u001B[33m",
            ANSI_BLUE = "\u001B[34m",
            ANSI_PURPLE = "\u001B[35m",
            ANSI_CYAN = "\u001B[36m",
            ANSI_WHITE = "\u001B[37m";

    public final static int
            VERBOSE = 0,
            DEBUG = 1,
            INFO = 2,
            WARNING = 3,
            ERROR = 4,
            FATAL = 5;

    private static boolean
            VERBOSE_ON = true,
            DEBUG_ON = true,
            INFO_ON = true,
            WARNING_ON = true,
            ERROR_ON = true,
            FATAL_ON = true;

    private static void printLog(String level, String color, String sender, String msg) {
        String time = " " + System.currentTimeMillis();
        System.out.println(color + level + "/" + sender + " : " + msg + ANSI_RESET);
    }

    public static void v(String sender, String msg) {
        if (VERBOSE_ON)
            printLog("V", ANSI_BLACK, sender, msg);
    }

    public static void v(String sender, String msg, String color) {
        if (VERBOSE_ON)
            printLog("V", color, sender, msg);
    }

    public static void d(String sender, String msg) {
        if (DEBUG_ON)
            printLog("D", ANSI_PURPLE, sender, msg);
    }

    public static void d(String sender, String msg, String color) {
        if (DEBUG_ON)
            printLog("D", color, sender, msg);
    }

    public static void i(String sender, String msg) {
        if (INFO_ON)
            printLog("I", ANSI_GREEN, sender, msg);
    }

    public static void i(String sender, String msg, String color) {
        if (INFO_ON)
            printLog("I", color, sender, msg);
    }

    public static void w(String sender, String msg) {
        if (WARNING_ON)
            printLog("W", ANSI_YELLOW, sender, msg);
    }

    public static void w(String sender, String msg, String color) {
        if (WARNING_ON)
            printLog("W", color, sender, msg);
    }

    public static void e(String sender, String msg) {
        if (ERROR_ON)
            printLog("E", ANSI_RED, sender, msg);
    }

    public static void e(String sender, String msg, String color) {
        if (ERROR_ON)
            printLog("E", color, sender, msg);
    }

    public static void f(String sender, String msg) {
        if (FATAL_ON)
            printLog("F", ANSI_BLUE, sender, msg);
    }

    public static void f(String sender, String msg, String color) {
        if (FATAL_ON)
            printLog("F", color, sender, msg);
    }

    public static void setAllOn() {
        VERBOSE_ON = true;
        DEBUG_ON = true;
        INFO_ON = true;
        WARNING_ON = true;
        ERROR_ON = true;
        FATAL_ON = true;
    }

    public static void setAllOff() {
        VERBOSE_ON = false;
        DEBUG_ON = false;
        INFO_ON = false;
        WARNING_ON = false;
        ERROR_ON = false;
        FATAL_ON = false;
    }

    public static void setOnly(int level) {
        setAllOff();
        setOn(level);
    }

    public static void setOn(int level) {
        boolean set = true;
        switch (level) {
            case VERBOSE:
                VERBOSE_ON = set;
                break;
            case DEBUG:
                DEBUG_ON = set;
                break;
            case INFO:
                INFO_ON = set;
                break;
            case WARNING:
                WARNING_ON = set;
                break;
            case ERROR:
                ERROR_ON = set;
                break;
            case FATAL:
                FATAL_ON = set;
                break;
        }
    }

    public static void setOff(int level) {
        boolean set = false;
        switch (level) {
            case VERBOSE:
                VERBOSE_ON = set;
                break;
            case DEBUG:
                DEBUG_ON = set;
                break;
            case INFO:
                INFO_ON = set;
                break;
            case WARNING:
                WARNING_ON = set;
                break;
            case ERROR:
                ERROR_ON = set;
                break;
            case FATAL:
                FATAL_ON = set;
                break;
        }
    }
}
