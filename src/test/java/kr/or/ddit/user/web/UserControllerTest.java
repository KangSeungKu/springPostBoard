package kr.or.ddit.user.web;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.config.test.WebTestConfig;

public class UserControllerTest extends WebTestConfig{

	@Test
	public void viewTest() throws Exception {
		/***Given***/

		/***When***/
		MvcResult mvcResult =  mockMvc.perform(MockMvcRequestBuilders.get("/login")).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		
		/***Then***/
		assertEquals("login/login", mav.getViewName());
	}

}
