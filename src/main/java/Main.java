import javax.xml.crypto.Data;
import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        OutputStream out = new FileOutputStream("newfile");
        OutputStream out2 = new BufferedOutputStream(new FileOutputStream("newvideofile.mp4"));
        OutputStream out3 = new FileOutputStream("neweso.exe");
        InputStream in = new FileInputStream("file");
        InputStream in2 = new BufferedInputStream(new FileInputStream("zoom_0.mp4"));
        InputStream in3 = new FileInputStream("Install_ESO.exe");

        Constructor constructor = new Constructor();

//        constructor.constructorPiece("Install_ESO.exe");
//        constructor.constructorFile("Install_ESO.exe", "NEW_Install_ESO.exe");
//        constructor.constructorFile("Install_ESO.exe", "NEW_Install_ESO.exe");
        constructor.constructorTwoHalfFile("Green.Book.avi", 102400000);

//        while (true) {
//            int element = in2.read();
//            if (element == -1) {
//                break;
//            }
//            out2.write(element);
//        }
//        byte[] mass = new byte[10000];
//            List<Integer> elements = new ArrayList<>();
//            elements = in2.read(elements);
//        mass = in2.read(mass);
//        while (true) {
//            int f = in3.read(mass);
//            if (f != mass.length) {
//                out3.write(mass, 0, f);
//                break;
//            }
//            out3.write(mass, 0, f);
//        }

//            out2.write(elements);
        out.close();
        out2.close();
        out3.close();
        in.close();
        in2.close();
        in3.close();
    }
}
