package pn_1;

import java.io.*;
import java.util.*;

public class Pn_Main {

    public static ArrayList<String> stack = new ArrayList();
    public static String fileName;
    public static BufferedReader in;
    public static List<String> file;
    public static int line;

    public static boolean debug = false;
    public static String version = "1.0";

    // Args: pn [-d (DEBUG)] [-v] [PATH TO FILE]
    public static void main(String[] args) throws IOException {
        if (args.length == 0 && !debug) Msg.sysErr("You must specify, which file should be interpreted.", -1);
        else if (args.length > 0) {
            File f = null;
            
            if (args.length == 2 && "-d".equals(args[0])) {debug = true; f = new File(args[1]);}
            else if (args.length == 1) f = new File(args[0]);
            
            if (f.exists()) in = new BufferedReader(new FileReader(f));
            else if (args.length == 1 && "-v".equals(args[0])) {Msg.inf("PN Version " + version); System.exit(0);}
            else Msg.sysErr("File not found: '" + args[0] + "'.", line);
            
            fileName = args[0];
        }
        file = getLines(in);

        if (!debug) {
            Cmd.regAll();

            preLoad();
            read();
        } else {
            Debug.debug();
        }

        in.close();
    }

    public static void preLoad() throws IOException {
        for (line = 0; line < file.size(); line++)
            if (Reader.read(file.get(line))[0].equals("void"))
                Function.reg(Reader.read(file.get(line))[1], line);
    }

    public static void read() throws IOException {
        for (line = Function.find("main"); line < file.size(); line++)
            Cmd.read(file.get(line));
    }

    public static List<String> getLines(BufferedReader f) throws IOException {
        List<String> lines = new ArrayList<>();
        String l;
        while ((l = f.readLine()) != null) {
            lines.add(l);
        }
        return lines;
    }
}
