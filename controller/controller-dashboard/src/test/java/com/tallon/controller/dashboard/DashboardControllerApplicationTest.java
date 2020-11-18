package com.tallon.controller.dashboard;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DashboardControllerApplication.class)
public class DashboardControllerApplicationTest {

	@Resource
	private BCryptPasswordEncoder encoder;

	@Test
	public void password() {
		// TODO 生成token密码
		System.out.println(encoder.encode("123456"));
	}

}