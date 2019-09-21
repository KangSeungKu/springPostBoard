package kr.or.ddit.board.web;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.board.model.PostBoard;
import kr.or.ddit.board.service.IPostBoardService;
import kr.or.ddit.common.model.Page;
import kr.or.ddit.post.service.IPostService;
import kr.or.ddit.user.model.User;

@Controller
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Resource(name = "postBoardService")
	private IPostBoardService postBoardService;
	
	@Resource(name = "postService")
	private IPostService postService;
	
	@RequestMapping(path = "postBoard", method = RequestMethod.GET)
	public String postBoardView() {
		return "postboard/postBoardForm";
	}
	
	@RequestMapping(path = "postBoard", method = RequestMethod.POST)
	public String postBoard(String boardFunc, PostBoard postBoard, HttpSession session) {
		User user = (User) session.getAttribute("S_USERVO");
		
		postBoard.setUserid(user.getUserId());
		
		logger.debug("boardFunc : {}", boardFunc);
		logger.debug("user : {}", user);
		logger.debug("postBoard : {}", postBoard);
		
		if(boardFunc.equals("inse")) {	
			postBoardService.insertPostBoard(postBoard);
		}else {
			postBoardService.updatePostBoard(postBoard);
		}
		
		return "postboard/postBoardForm";
	}
	
	@RequestMapping(path = "board", method = RequestMethod.GET)
	public String boardView(@RequestParam(defaultValue = "1") int page, 
			 				@RequestParam(defaultValue = "10") int pagesize,
			 				int menuBoardSeq, Model model, HttpSession session) {
		
		Page p = new Page(page, pagesize, menuBoardSeq);
		model.addAttribute("pageVo", p);
		
		Map<String, Object> resultMap = postService.getPostList(p);
		model.addAllAttributes(resultMap);
		
		PostBoard board = postBoardService.getPostBoard(menuBoardSeq);
		
		session.setAttribute("S_POSTBOARDVO", board);
		
		return "postboard/postboard";
	}
}
