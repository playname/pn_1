package pn_1;

import java.io.*;
import java.util.*;

public class Commands extends Variable {

    static ArrayList<String> list = new ArrayList<String>();

    static void regCmd(String name, int len) {
        list.add(name + " " + len);
        if (Pn_Main.debug)
            System.out.println("[OK] " + name + ", Length: " + len);
    }

    static void var(String name, String type, String val) {
        name = name.replace(":", "");
        newVar(name, type, val);
    }
    
    static void _if(String _a, String op, String _b) {
        String a = getVal(_a);
        String b = getVal(_b);
        
        switch(op) {
            case "==":
                if (a.equals(b)) jmp(Pn_Main.line + 1);
                else endif();
                break;
                
            case "<":
                if (a.getClass().getName().equals("java.lang.integer") && b.getClass().getName().equals("java.lang.integer") ||
                    a.getClass().getName().equals("java.lang.float") && b.getClass().getName().equals("java.lang.float"))
                    if (Integer.parseInt(a) < Integer.parseInt(b)) jmp(Pn_Main.line + 1);
                    else endif();
                else Msg.err("Cannot compare variables with different data types.", 1);
                break;
                
            case ">":
                if (a.getClass().getName().equals("java.lang.integer") && b.getClass().getName().equals("java.lang.integer") ||
                    a.getClass().getName().equals("java.lang.float") && b.getClass().getName().equals("java.lang.float"))
                    if (Integer.parseInt(a) > Integer.parseInt(b)) jmp(Pn_Main.line + 1);
                    else endif();
                else Msg.err("Cannot compare variables with different data types.", 1);
                break;
        }
    }
    
    static void endif() {
        if (Cmd.isCmd) {
            while (Pn_Main.file.get(Pn_Main.line).equals("endif")) {
                Pn_Main.line++;
            }
        }
    }

    //Print text
    static void print(String text) {
        System.out.print(text.replace("\"", ""));
    }

    static void println(String text) {
        System.out.println(text.replace("\"", ""));
    }

    //Print variable
    static void printVar(String var) {
        System.out.print(getVal(var));
    }

    static void printlnVar(String var) {
        System.out.println(getVal(var));
    }

    //Gets command line input and stores it in a variable
    static void get(String var) {
        Scanner get = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        setVal(var, get.nextLine());
    }

    static void add(String var, String val) {
        var = var.replace(",", "");
        setVal(var, "\"" + addS(getVal(var), val) + "\"");
    }
    
    static void addV(String a, String b) {
        a = a.replace("," , "");
        b = b.replace("," , "");
        setVal(a, "\"" + addS(getVal(a), getVal(b)) + "\"");
    }
    
    static void sub(String var, String val) {
        var = var.replace(",", "");
        setVal(var, "\"" + subS(getVal(var), val) + "\"");
    }
    
    static void subV(String a, String b) {
        a = a.replace("," , "");
        b = b.replace("," , "");
        setVal(a, "\"" + subS(getVal(a), getVal(b)) + "\"");
    }
    
    static void mul(String var, String val) {
        var = var.replace(",", "");
        setVal(var, "\"" + mulS(getVal(var), val) + "\"");
    }
    
    static void mulV(String a, String b) {
        a = a.replace("," , "");
        b = b.replace("," , "");
        setVal(a, "\"" + mulS(getVal(a), getVal(b)) + "\"");
    }
    
    static void div(String var, String val) {
        var = var.replace(",", "");
        setVal(var, "\"" + divS(getVal(var), val) + "\"");
    }
    
    static void divV(String a, String b) {
        a = a.replace("," , "");
        b = b.replace("," , "");
        setVal(a, "\"" + divS(getVal(a), getVal(b)) + "\"");
    }

    static void push(String arg) {
        if (arg != null)
            Pn_Main.stack.add(arg);
        else
            Msg.err("Either not enough arguments or bug in the interpreter.", 2);
    }

    static void pushVar(String var) {
        Pn_Main.stack.add(getVal(var));
    }

    static void pop(String var) {
        if (Pn_Main.stack.size() > 0) {
            setVal(var, Pn_Main.stack.get(Pn_Main.stack.size() - 1));
            Pn_Main.stack.remove(Pn_Main.stack.size() - 1);
        }
        else Msg.err("Can't remove elements when stack is empty.", 0);
    }

    static void jmp(int line) {
        Pn_Main.line = line - 1;
    }

    static void exit(int code) {
        if (!Pn_Main.debug) System.exit(code);
        else Debug.exit(code);
    }

    static String addS(String a, String b) {return String.valueOf(Integer.parseInt(a) + Integer.parseInt(b));}
    
    static String subS(String a, String b) {return String.valueOf(Integer.parseInt(a) - Integer.parseInt(b));}
    
    static String mulS(String a, String b) {return String.valueOf(Integer.parseInt(a) * Integer.parseInt(b));}
    
    static String divS(String a, String b) {return String.valueOf(Integer.parseInt(a) / Integer.parseInt(b));}
}
