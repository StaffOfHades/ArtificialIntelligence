package system.debugging;

/**
 * Default Template. Information about thus class should go here
 * Created by mauriciog on 9/10/15 for Artificial Intelligence
 */
public class Log {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_WHITE = "\u001B[37m";

    public static void v(String sender, String msg) {
        System.out.println(ANSI_BLACK + "V/" + sender + ": " + msg + ANSI_RESET);
    }

    public static void d(String sender, String msg) {
        System.out.println(ANSI_YELLOW + "D/" + sender + ": " + msg + ANSI_RESET);
    }

    public static void i(String sender, String msg) {
        System.out.println(ANSI_BLUE + "I/" + sender + ": " + msg + ANSI_RESET);
    }

    public static void w(String sender, String msg) {
        System.out.println(ANSI_PURPLE + "W/" + sender + ": " + msg + ANSI_RESET);
    }

    public static void e(String sender, String msg) {
        System.out.println(ANSI_RED + "E/" + sender + ": " + msg + ANSI_RESET);

    }

    public static void f(String sender, String msg) {
        System.out.println(ANSI_GREEN + "F/" + sender + ": " + msg + ANSI_RESET);
    }
}
