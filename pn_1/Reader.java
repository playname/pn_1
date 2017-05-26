package pn_1;

import java.util.*;

public class Reader {
    /*
        -Split spaces but not when in ""
    
    Example:
        var hello: string = "Hello World!"
        |-> ["var", "hello:", "string" "=", "Hello World!"]
    */
    public static String[] read(String string) {
        List<String> chars = Arrays.asList(string.split(""));
        boolean s = false;

        for (int i = 0; i < chars.size(); i++) {
            if (chars.get(i).equals("\"") && !s) s = true;
            else if (chars.get(i).equals("\"") && s) s = false;

            if (!s && chars.get(i).equals(" "))
                chars.set(i, "\b");
        }
        String _string = String.join("", chars);

        return _string.split("\b");
    }
}
