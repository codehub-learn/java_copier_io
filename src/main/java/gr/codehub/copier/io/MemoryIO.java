package gr.codehub.copier.io;

import java.io.*;

public class MemoryIO<T extends Object>  {

    public byte[] saveObject(T o) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bos);
        out.writeObject(o);
        out.close();
        return bos.toByteArray();
    }

    public T readObject(byte[] inFilename) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(inFilename));
        T o = (T)in.readObject();
        in.close();
        return o;
    }

    public T copyObject(T o) throws IOException, ClassNotFoundException {
        byte[] i = saveObject(o);
        T copy = (T) readObject(i);
        return copy;
    }

}
