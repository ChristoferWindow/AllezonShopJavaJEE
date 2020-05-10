package pl.jazapp.app;

import java.io.*;

public class SampleApp {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        var userContext = new UserContext(345345345L);

        var out = new ByteArrayOutputStream();
        var objOut = new ObjectOutputStream(out);
        objOut.writeObject(userContext);

        var objIn = new ObjectInputStream(new ByteArrayInputStream(out.toByteArray()));
        var readObj = (UserContext) objIn.readObject();
    }
}
