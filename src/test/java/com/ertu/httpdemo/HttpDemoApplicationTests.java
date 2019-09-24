package com.ertu.httpdemo;

import com.ertu.httpdemo.pojo.User;
import com.ertu.spider.utils.StringUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HttpDemoApplication.class)
public class HttpDemoApplicationTests {

	@Autowired
	private RestTemplate restTemplate;

	@Test
	public void httpGet() {
		User user = this.restTemplate.getForObject("http://localhost/hello", User.class);
		System.out.println(user);
	}

	@Test
	public void regTest() {
		String s = "jQuery17206571463072632691_1568901836495({resultCode:\"0000\",redirectURL:\"null\"})";
		String resultByReg = StringUtil.getResultByReg(s, "resultCode:\"(.*?)\"");
		System.out.println(resultByReg);
	}
}
