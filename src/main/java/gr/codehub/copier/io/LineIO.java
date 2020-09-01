package gr.codehub.copier.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LineIO {

    public static List<String> readFile(String inFilename) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(inFilename)));
        List<String> lines = new ArrayList<>();
        boolean finished = false;
        while (!finished) {
            String s = in.readLine();
            if (s == null)
                finished = true;
            else
                if (!s.isEmpty() && !s.startsWith("//"))
                    lines.add(s);
        }
        in.close();
        return lines;
    }

    public static void writeFile(String outFilename, List<String> lines) {

//        out PrintWriter;
//        List of lines
//
//        open out
//        println lines
//        close out
    }


}

