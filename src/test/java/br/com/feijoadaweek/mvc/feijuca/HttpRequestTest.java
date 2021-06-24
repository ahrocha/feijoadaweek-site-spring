package br.com.feijoadaweek.mvc.feijuca;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void greetingShouldReturnDefaultMessage() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/",
				String.class)).contains("feijoada");
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/cervejas",
				String.class)).contains("feijoada");
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/cerveja/penelope-red-ipa",
				String.class)).contains("feijoada");
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/restaurante/apolo-feijoada-todos-os-dias",
				String.class)).contains("feijoada");
	}
}
