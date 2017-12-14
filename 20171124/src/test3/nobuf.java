package test3;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class nobuf {

        public static void main(String[] args) {

                FileInputStream fis = null;
                FileOutputStream fos = null;

                try {
                        fis = new FileInputStream("e:\\myeclipse\\20171124\\src.txt");
                        fos = new FileOutputStream("e:\\myeclipse\\20171124\\dest.txt");

                        byte[] buf = new byte[1024];
                        int len = 0;
                        while ((len = fis.read(buf)) != -1) {
                                fos.write(buf, 0, len);
                        }

                } catch (IOException e) {
                        throw new RuntimeException("øΩ±¥ ß∞‹");
                } finally {
                        try {
                                if (fis != null)
                                        fis.close();
                        } catch (IOException e) {
                                throw new RuntimeException("∂¡»°πÿ±’ ß∞‹");
                        }
                        try {
                                if (fos != null)
                                        fos.close();
                        } catch (IOException e) {
                                throw new RuntimeException("–¥»Îπÿ±’ ß∞‹");
                        }
                }
        }
}
