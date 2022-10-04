package org.artevseev.funcs;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmailsToList {
    public static List<String> emailsToList(String filePath) throws IOException {
        List<String> res = new ArrayList<>(List.of());

        FileReader fr = new FileReader(filePath);
        BufferedReader reader = new BufferedReader(fr);
        String line = reader.readLine();
        while (line != null) {
            res.add(line);
            line = reader.readLine();
        }
        return res;
    }
}
