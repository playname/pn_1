package pn_1;

import java.io.IOException;
import static pn_1.Pn_Main.*;

public class Debug {

    static void debug() throws IOException {
        System.out.println("File: " + fileName + "\n");

        reg();
        preLoad();

        Msg.debug("Runing code...");
        run();
    }

    static void reg() {
        Cmd.regAll();
        Msg.debug("Done loading commands.");
    }

    public static void preLoad() throws IOException {
        for (line = 0; line < file.size(); line++) {
            if (Reader.read(file.get(line))[0].equals("void")) {
                Function.reg(Reader.read(file.get(line))[1], line);
                Msg.debug("Found function '" + Reader.read(file.get(line))[1] + "' at line " + line);
            }
        }
        System.out.println();
    }

    public static void run() throws IOException {
        System.out.println("\n");

        for (line = Function.find("main"); line < file.size(); line++)
            Cmd.read(file.get(line));
    }

    static void check() {
        System.out.println("Variables:");
        Variable.vars.forEach((s) -> {
            System.out.println("\t" + s.replace("\b", " -> "));
        });
        System.out.println();

        System.out.println("Call stack:");
        Function.callStack.forEach((s) -> {
            System.out.println("\t" + s);
        });
    }

    static void exit(int code) {
        Msg.debug("The program returned: " + code + "\n\n");
        check();
        System.exit(code);
    }
}
