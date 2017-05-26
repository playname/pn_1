package pn_1;

public class Msg {

    public static void warn(String msg) {
        System.out.println("[WARNING] " + msg);
    }

    public static void err(String msg, int code) {
        System.err.println("Error at " + Pn_Main.fileName + ", line " + Pn_Main.line + ": " + msg);
        Debug.exit(code);
    }

    public static void _err(String msg, int code) {
        System.err.println("Error in " + Pn_Main.fileName + ": " + msg);
        Debug.exit(code);
    }

    public static void inf(String msg) {
        System.out.println("[INFO] " + msg);
    }

    public static void debug(String msg) {
        System.out.println("[DEBUG] " + msg);
    }

    public static void sysErr(String msg, int code) {
        System.err.println(msg);
        System.exit(code);
    }
}
