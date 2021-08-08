package com.example.demo;

import com.example.demo.grpc.HelloWorldClient;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private HelloWorldClient helloWorldClient;

	@Test
	public void testSayHello() {
		assertThat(helloWorldClient.sayHello("John", "Doe"))
				.isEqualTo("Hello John Doe!");
	}

}
