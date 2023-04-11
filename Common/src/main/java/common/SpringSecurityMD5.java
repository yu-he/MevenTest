package common;

import org.apache.shiro.util.ByteSource;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

public class SpringSecurityMD5 {
    public static void main(String[] args) {
        Md5PasswordEncoder md5encoder = new Md5PasswordEncoder();
        md5encoder.setIterations(1024);

        String credentials = "123456";
        Object salt = ByteSource.Util.bytes("user");
        int hashIterations = 1024;

        md5encoder.setIterations(hashIterations);
        String result = md5encoder.encodePassword(credentials, null);
        System.out.println(result);
    }
}
