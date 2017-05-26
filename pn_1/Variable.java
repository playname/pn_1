package pn_1;

import java.util.ArrayList;
import java.util.Arrays;

public class Variable {

    //var -> [name, type, value]
    public static ArrayList<String> vars = new ArrayList<String>();
    
    public static void newVar(String name, String type, String val) {
        if (find(name) == -1) {
            if ("string".equals(type) || 
                "int".equals(type) ||
                "float".equals(type) ||
                "bool".equals(type))
                vars.add(name + "\b" + type + "\b" + val);
            else
                Msg.err("Type '" + type + "' does not exist.", 1);
        }
        else Msg.warn("Variable '" + name + "' already exists.");
    }
    
    public static void remove(String name) {
        vars.remove(find(name));
    }

    public static void setVal(String name, String val) {
        String[] var = vars.get(find(name)).split("\b");
        var[2] = val;
        vars.set(find(name), Arrays.toString(var).replace("[", "").replace("]", "").replace(",", ""));
        vars.set(find(name), vars.get(find(name)).replace(" ", "\b"));
    }

    public static String getVal(String name) {
        return vars.get(find(name)).split("\b")[2].replace("\"", "");
    }

    public static String getType(String name) {
        return vars.get(find(name)).split("\b")[1];
    }

    //Returns index of specified variable in vars
    public static int find(String name) {
        for (int i = 0; i < vars.size(); i++) {
            String[] var = vars.get(i).split("\b")[0].split("");
            if (var[0].equals(name))
                return i;
        }
        if (Pn_Main.debug) Msg.debug("Variable '" + name + "' not found.");
        if (Cmd.isCmd) Msg.err("Variable '" + name + "' does not exist.", 1);
        return -1;
    }
}
