package com.example.learning;

import com.example.learning.repository.EmploeeRepository;
import com.example.learning.service.EmploeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
class LearningApplicationTests {

	MockMvc mvc;
	@Autowired
	WebApplicationContext webApplicationContext;
	@Autowired
	EmploeeRepository emploeeRepository;
	@Test
	void getAllEmploeesTest() throws Exception {
		String url ="/employees";
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(url)
				.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		Assertions.assertEquals(200,status);
	}

}
