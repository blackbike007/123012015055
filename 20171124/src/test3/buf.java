package test3;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class buf {
        public static void main(String[] args) {

                BufferedInputStream bufis = null;
                BufferedOutputStream bufos = null;

                try {
                        bufis = new BufferedInputStream(new FileInputStream(
                                        "e:\\myeclipse\\20171124\\src.txt"));
                        bufos = new BufferedOutputStream(new FileOutputStream(
                                        "e:\\myeclipse\\20171124\\dest.txt"));

                        int byt = 0;
                        while ((byt = bufis.read()) != -1) {
                                bufos.write(byt);
                        }
                } catch (IOException e) {
                        throw new RuntimeException("øΩ±¥ ß∞‹");
                } finally {
                        try {
                                if (bufis != null)
                                        bufis.close();
                        } catch (IOException e) {
                                throw new RuntimeException("∂¡»°πÿ±’ ß∞‹");
                        }
                        try {
                                if (bufos != null)
                                        bufos.close();
                        } catch (IOException e) {
                                throw new RuntimeException("–¥»Îπÿ±’ ß∞‹");
                        }
                }
        }
}
