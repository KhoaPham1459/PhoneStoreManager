import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
 
public class CopyFileStream {
 
    public static void main(String[] args) throws IOException {
 
        File source = new File("huawei-mate-20-black-400x460.jpg");
        File dest = new File("test/cc.jpg");
 
        InputStream is = null;
        OutputStream os = null;
 
        try {
             
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
             
            byte[] buffer = new byte[1024];
            int length;
             
            while ((length = is.read(buffer)) > 0) {
                 
                os.write(buffer, 0, length);
            }
             
        } finally {
 
            if (is != null) {
                is.close();
            }
 
            if (os != null) {
                os.close();
            }
        }
    }
}