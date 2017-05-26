package pn_1;

import java.util.ArrayList;

public class Function {

    public static ArrayList<String> functions = new ArrayList<String>();
    public static ArrayList<Integer> callStack = new ArrayList<Integer>();

    public static void reg(String name, int line) {
        functions.add(name + "," + line);
    }

    public static int find(String name) {
        for (int i = 0; i < functions.size(); i++)
            if (functions.get(i).split(",")[0].equals(name))
                return Integer.parseInt(functions.get(i).split(",")[1]);
        Msg._err("Function '" + name + "' not found.", 2);
        return 0;
    }

    public static void call(String name) {
        callStack.add(Pn_Main.line);
        Pn_Main.line = find(name);
    }

    public static void ret() {
        if (!callStack.isEmpty()) {
            Pn_Main.line = callStack.get(callStack.size() - 1);
            callStack.remove(callStack.size() - 1);
        } else if (callStack.isEmpty() && !Pn_Main.debug) {
            System.exit(0);
        } else if (callStack.isEmpty() && Pn_Main.debug) {
            Debug.exit(0);
        }
    }
}
