package com.oauth;

import com.tallon.oauth.AuthApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * test
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-11-20 20:15
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AuthApplication.class)
public class TestMethod {

    @Resource
    private BCryptPasswordEncoder encoder;

    @Test
    public void password() {
        System.out.println(encoder.encode("123456"));
    }
}
