package com.tallon.repository.core.mapper;

import com.tallon.repository.core.CoreRepositoryApplication;
import com.tallon.repository.core.domain.CoreAdmin;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CoreRepositoryApplication.class)
public class CoreAdminMapperTest {

	@Resource
	private CoreAdminMapper mapper;

	@Resource
	private TbPermissionMapper tbPermissionMapper;

	@Test
	public void test() {
		System.out.println("Hello World");
	}

	@Test
	public void get1() {
		List<CoreAdmin> coreAdmins = mapper.selectList(null);
		coreAdmins.forEach(System.out::print);
		Assert.assertNotNull(coreAdmins);
	}

	@Test
	public void get2() {
		List<String> urls = tbPermissionMapper.tbAdminPermissionUrls("eric");
		urls.forEach(System.out::println);
	}
}