import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

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

    public void constructorTwoHalfFile(String fileName, int bufferSize) throws IOException {
        InputStream in = new FileInputStream(fileName);
        byte[] mass = new byte[bufferSize];
        long fileSize = Files.size(Paths.get(fileName));
        long pieceFileSize = fileSize / 2;
        for (int i = 0; i < 2; i++) {
            OutputStream out = new FileOutputStream(fileName + "_" + i);
            long recordingVolume = 0;
            while (true) {
                recordingVolume = recordingVolume + bufferSize;
                if (i == 0 && pieceFileSize < recordingVolume) {
                    byte[] mass2 = new byte[(int) (bufferSize - (recordingVolume - pieceFileSize))];
                    int buf2 = in.read(mass2);
                    out.write(mass2, 0, buf2);
                    break;
                }
                int buf = in.read(mass);
                if (buf == -1) {
                    break;
                }
                    out.write(mass, 0, buf);
            }
            out.close();
        }
    }
}
