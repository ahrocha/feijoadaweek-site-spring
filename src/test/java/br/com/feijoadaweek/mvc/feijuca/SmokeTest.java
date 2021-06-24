package br.com.feijoadaweek.mvc.feijuca;

import static org.junit.jupiter.api.Assertions.fail;
//import static org.junit.jupiter.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.feijoadaweek.mvc.feijuca.controller.IndexController;

@SpringBootTest
class SmokeTest {

	@Autowired
	private IndexController controller;
	
	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

//	void test() {
//		fail("Not yet implemented");
//	}

}
