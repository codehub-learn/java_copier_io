package gr.codehub.copier.io;

import java.io.*;

public class MemoryIO {

    public static byte[] saveObject(Object o) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bos);
        out.writeObject(o);
        out.close();
        return bos.toByteArray();
    }

    public static Object readObject(byte[] inFilename) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(inFilename));
        Object o = in.readObject();
        in.close();
        return o;
    }

    public static <T> T copyObject(T o) throws IOException, ClassNotFoundException {
        byte[] i = saveObject(o);
        T copy = (T) readObject(i);
        return copy;
    }

}
