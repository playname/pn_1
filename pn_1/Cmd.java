package pn_1;

import java.util.*;

public class Cmd extends Commands {

    public static ArrayList<String> cache = new ArrayList();
    public static boolean isCmd = false;

    public static void read(String s) {
        for (int i = 0; i < test(Reader.read(s)[0]); i++)
            cache.add(Reader.read(s)[i]);

        if (Pn_Main.debug) Msg.debug("Line " + Pn_Main.line + ": " + cache.toString() + ", " + cache.size());
        execute();
    }

    public static void execute() {
        //TODO sort commands by speed (slow -> fast)
        try {
            switch (cache.get(0)) {
                case "var":
                    var(cache.get(1), cache.get(2), cache.get(4));
                    break;
                case "if":
                    isCmd = true;
                    _if(cache.get(1), cache.get(2), cache.get(3));
                    break;
                case "endif":
                    endif();
                    break;
                case "print":
                    isCmd = true;
                    print(cache.get(1));
                    break;
                case "println":
                    isCmd = true;
                    println(cache.get(1));
                    break;
                case "printVar":
                    isCmd = true;
                    printVar(cache.get(1));
                    break;
                case "printlnVar":
                    isCmd = true;
                    printlnVar(cache.get(1));
                    break;
                case "get":
                    isCmd = true;
                    get(cache.get(1));
                    break;
                case "add":
                    isCmd = true;
                    add(cache.get(1), cache.get(2));
                    break;
                case "addV":
                    isCmd = true;
                    addV(cache.get(1), cache.get(2));
                    break;
                case "sub":
                    isCmd = true;
                    sub(cache.get(1), cache.get(2));
                    break;
                case "subV":
                    isCmd = true;
                    subV(cache.get(1), cache.get(2));
                    break;
                case "mul":
                    isCmd = true;
                    mul(cache.get(1), cache.get(2));
                    break;
                case "mulV":
                    isCmd = true;
                    mulV(cache.get(1), cache.get(2));
                    break;
                case "div":
                    isCmd = true;
                    div(cache.get(1), cache.get(2));
                    break;
                case "divV":
                    isCmd = true;
                    divV(cache.get(1), cache.get(2));
                    break;
                case "push":
                    isCmd = true;
                    push(cache.get(1));
                    break;
                case "pushVar":
                    isCmd = true;
                    pushVar(cache.get(1));
                    break;
                case "pop":
                    isCmd = true;
                    pop(cache.get(1));
                    break;
                case "call":
                    isCmd = true;
                    Function.call(cache.get(1));
                    break;
                case "jmp":
                    isCmd = true;
                    jmp(Integer.parseInt(cache.get(1)));
                    break;
                case "ret":
                    isCmd = true;
                    Function.ret();
                    break;
                case "exit":
                    exit(Integer.parseInt(cache.get(1)));
                    break;
                case "void":
                    break;
                case "//":
                    break;
                case "\n":
                    break;
                default:
                    Msg.err("Command '" + cache.get(0) + "' not found.", 1);
            }
        } catch (IndexOutOfBoundsException e) {
            Msg.err("Not enough arguments.", 2);
        }
        cache.removeAll(cache);
        isCmd = false;
    }

    public static int test(String c) {
        for (int i = 0; i < list.size(); i++) {
            String s[] = list.get(i).split(" ");
            if (c.equals(s[0]))
                return Integer.parseInt(s[1]);
        }
        return 0;
    }

    public static void regAll() {
        regCmd("var", 5);
        regCmd("if", 4);
        regCmd("endif", 1);
        regCmd("print", 2);
        regCmd("println", 2);
        regCmd("printVar", 2);
        regCmd("printlnVar", 2);
        regCmd("get", 2);
        regCmd("add", 3);
        regCmd("addV", 3);
        regCmd("sub", 3);
        regCmd("subV", 3);
        regCmd("mul", 3);
        regCmd("mulV", 3);
        regCmd("div", 3);
        regCmd("divV", 3);
        regCmd("push", 2);
        regCmd("pushVar", 2);
        regCmd("pop", 2);
        regCmd("call", 2);
        regCmd("jmp", 2);
        regCmd("ret", 1);
        regCmd("void", 2);
        regCmd("exit", 2);
        regCmd("//", 1);
    }
}
