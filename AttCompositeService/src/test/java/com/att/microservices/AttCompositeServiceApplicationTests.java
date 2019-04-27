package com.att.microservices;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.nio.charset.Charset;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
//@Ignore
@SpringBootTest(classes = AttCompositeServiceApplication.class)
@AutoConfigureMockMvc
public class AttCompositeServiceApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),MediaType.APPLICATION_JSON.getSubtype(),Charset.forName("UTF-8"));
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;

	
	@Before
	public void setup() throws Exception{
		this.mockMvc = webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void retrieveConfigurationOk() throws Exception
	{
		System.out.println("#### AttCompositeServiceApplicationTests.java: retrieveInformationOk(): Test Begin"); 
		MvcResult result = mockMvc.perform(get("/v1/retrieveInformation")
				.header("testheader", "abc")
				.contentType(contentType))
				.andExpect(status().isOk())
				.andReturn();
		System.out.println("#### retrieveInformationOk(): result.getResponse().getContentAsString(): " + result.getResponse().getContentAsString());
		System.out.println("#### AttCompositeServiceApplicationTests.java: retrieveInformationOk(): Test End"); 
		
	}
	


}
