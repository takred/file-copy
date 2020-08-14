import java.io.*;

public class Constructor {
    public void constructorPiece(String fileName) throws IOException {
        InputStream in = new FileInputStream(fileName);
        byte[] mass = new byte[10240000];
        int i = 0;
        while (true) {
            int buf = in.read(mass);
            OutputStream out = new FileOutputStream(fileName + "_" + i);
            out.write(mass, 0, buf);
            out.close();
            i++;
            if (buf != 10240000) {
                break;
            }
        }
        in.close();
    }

    public void constructorFile(String filePieceName, String fileName) throws IOException {
        OutputStream out = new FileOutputStream(fileName);
        byte[] mass = new byte[10240000];
        int i = 0;
        while (new File(filePieceName + "_" + i).exists()) {
            InputStream in = new FileInputStream(filePieceName + "_" + i);
            int buf = in.read(mass);
            out.write(mass, 0, buf);
            in.close();
            i++;
        }
        out.close();
    }
}
