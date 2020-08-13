import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        OutputStream out = new FileOutputStream("newfile");
        InputStream in = new FileInputStream("file");
        while (true) {
            int element = in.read();
            if (element == -1) {
                break;
            }
            out.write(element);
        }
        out.close();
        in.close();
    }
}
