package hxc.manage;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author hxc
 * @version 1.0
 * @date 2019/12/27 15:52
 */

@SpringBootTest
public class ManageServerApplicationTest {

    @Test
    public void pass(){
        String pass = "123456";
        BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
        String hashPass = bcryptPasswordEncoder.encode(pass);
        System.out.println(hashPass);

        boolean f = bcryptPasswordEncoder.matches("123456",hashPass);
        System.out.println(f);

    }
}
