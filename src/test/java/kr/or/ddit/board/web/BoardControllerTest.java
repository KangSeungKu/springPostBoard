package kr.or.ddit.board.web;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.springframework.mock.web.MockHttpSession;

import kr.or.ddit.board.model.PostBoard;
import kr.or.ddit.config.test.WebTestConfig;
import kr.or.ddit.user.model.User;

public class BoardControllerTest extends WebTestConfig{

	@Test
	public void postBoardViewTest() throws Exception {
		mockMvc.perform(get("/postBoard"))
			.andExpect(view().name("postboard/postBoardForm"));
	}

	@Test
	public void postBoardTest() throws Exception {
		MockHttpSession session = new MockHttpSession();
		User user = new User();
		user.setUserId("brown");
		user.setPass("brown1234");
		session.setAttribute("S_USERVO", user);
		
		mockMvc.perform(post("/postBoard")
			.param("boardnm", "테스트게시판")
			.param("boardFunc", "inse")
			.session(session)
			.param("boardusage", "Y"))
				.andExpect(view().name("postboard/postBoardForm"));
	}
	
	@Test
	public void boardViewTest() throws Exception {
		MockHttpSession session = new MockHttpSession();
		
		mockMvc.perform(get("/board")
			.param("menuBoardSeq", "1")
			.param("page", "1")
			.param("pagesize", "10")
			.session(session))
				.andExpect(model().attributeExists("pageVo"))
				.andExpect(model().attributeExists("postList"))
				.andExpect(model().attributeExists("paginationSize"))
				.andExpect(view().name("postboard/postboard"));
			
		PostBoard board = (PostBoard) session.getAttribute("S_POSTBOARDVO");
		assertNotNull(board);
	}
}
