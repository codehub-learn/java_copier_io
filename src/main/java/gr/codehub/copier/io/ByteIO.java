package gr.codehub.copier.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteIO {

    public static void copyFile(String inFilename, String outFilename) throws IOException {

        FileInputStream in = new FileInputStream(inFilename);
        FileOutputStream out = new FileOutputStream(outFilename);

        boolean finished = false;
        while (!finished) {
            int b = in.read();
            if (b == -1)
                finished = true;
            else
                out.write(b);
        }
        in.close();
        out.close();
    }
}

