package com.passwordmeter.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.passwordmeter.dto.PasswordResponseDTO.PasswordResponseBuilder;
import com.passwordmeter.service.PasswordService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PasswordController.class)
@AutoConfigureMockMvc
@EnableWebMvc
public class PasswordControllerTest {

	@Autowired
    private MockMvc mockMvc;
	
	@MockBean
	private PasswordService passwordService;

	@Test
	public void shouldOkWithVeryWeakPassword() throws Exception {
		when(passwordService.meter(anyString()))
			.thenReturn(new PasswordResponseBuilder()
					.withComplexity("Muito fraca")
					.withScore(4)
					.build());
		
		mockMvc.perform(post("/api/v1/password/meter")
						.contentType(APPLICATION_JSON_UTF8)
						.content("{\"password\":\"1234\"}"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$.score", is(4)))
				.andExpect(jsonPath("$.complexity", is("Muito fraca")));
	}
	
	@Test
	public void shouldOkWithVeryStringPassword() throws Exception {
		when(passwordService.meter(anyString()))
			.thenReturn(new PasswordResponseBuilder()
					.withComplexity("Muito forte")
					.withScore(100)
					.build());
		
		mockMvc.perform(post("/api/v1/password/meter")
						.contentType(APPLICATION_JSON_UTF8)
						.content("{\"password\":\"123KJBdsajkbD!d@)*dBDK!BJ@\"}"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$.score", is(100)))
				.andExpect(jsonPath("$.complexity", is("Muito forte")));
	}
	
	@Test
	public void shouldBadRequest() throws Exception {
		mockMvc.perform(post("/api/v1/password/meter")
						.contentType(APPLICATION_JSON_UTF8)
						.content(""))
				.andExpect(status().isBadRequest());
	}
}
