package encoderDecoder;
/**
 * get the md5 value of  mysql driver
 * the result should be 387bd57f0fb07e3880d10f0c21b81686
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            File file =new File("D:\\软件\\mysql-installer-web-community-8.0.12.0.msi");
            fileInputStream = new FileInputStream(file);
            byte[] b = new byte[1024];
            while (fileInputStream.read(b) != -1){
                md.update(b);
            }
            byte[] r=md.digest();
            System.out.println(String.format("%032x",new BigInteger(1,r)));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileInputStream != null){
                fileInputStream.close();
            }
        }
    }
}
