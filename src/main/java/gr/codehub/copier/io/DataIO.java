package gr.codehub.copier.io;

import java.io.*;

public class DataIO {

    public static void saveData(String outFilename) throws IOException {

        DataOutputStream out = new DataOutputStream(new BufferedOutputStream(
                new FileOutputStream(outFilename)));
        double yyyy = 3.17;
        out.writeDouble(yyyy);
        out.writeInt(9999);
        out.writeUTF("Πολύ ωραία");
        out.close();

        DataInputStream in = new DataInputStream(new
                BufferedInputStream(new FileInputStream(outFilename)));
        double pi = in.readDouble();
        int almostHundred = in.readInt();
        String greeting = in.readUTF();
        in.close();

        System.out.println("pi = " + pi);
        System.out.println("almostHundred = " + almostHundred);
        System.out.println("greeting = " + greeting);
    }

}
