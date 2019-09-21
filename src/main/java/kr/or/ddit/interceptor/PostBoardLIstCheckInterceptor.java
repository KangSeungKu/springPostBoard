package kr.or.ddit.interceptor;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.or.ddit.board.model.PostBoard;
import kr.or.ddit.board.service.IPostBoardService;

public class PostBoardLIstCheckInterceptor extends HandlerInterceptorAdapter{
	private static final Logger logger = LoggerFactory.getLogger(PostBoardLIstCheckInterceptor.class);
	
	@Resource(name = "postBoardService")
	private IPostBoardService postBoardService;
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.debug("postHandle()");
		List<PostBoard> boardList = postBoardService.getPostBoardList();
		logger.debug("boardList : {}", boardList);
		request.setAttribute("boardList", boardList);
	}
}
