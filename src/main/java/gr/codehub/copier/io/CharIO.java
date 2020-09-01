package gr.codehub.copier.io;

import java.io.*;

public class CharIO {

    public static void copyFile(String inFilename, String outFilename) throws IOException {

        FileReader  in = new FileReader(inFilename);
        FileWriter out = new FileWriter(outFilename);

        boolean finished = false;
        while (!finished) {
            int b = in.read();
            if (b == 'E')
                System.out.println("hello");
            if (b == -1)
                finished = true;
            else
                out.write(b);
        }
        in.close();
        out.close();
    }
}

