package com.tallon.controller.dashboard;

import com.tallon.common.util.RedisUtil;
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

	@Resource
	private RedisUtil redisUtil;

	@Test
	public void password() {
		// TODO 生成token密码
		System.out.println(encoder.encode("123456"));
	}

	@Test
	public void testRedis() {
		boolean set = redisUtil.set("1", "1");
		Object o = redisUtil.get("1");
		System.out.println(o);
	}

}