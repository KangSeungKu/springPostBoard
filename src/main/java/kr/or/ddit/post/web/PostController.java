package kr.or.ddit.post.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.attafile.model.AttaFile;
import kr.or.ddit.attafile.service.IAttaFileService;
import kr.or.ddit.board.model.PostBoard;
import kr.or.ddit.comments.model.Comments;
import kr.or.ddit.comments.service.ICommentsService;
import kr.or.ddit.post.model.Post;
import kr.or.ddit.post.service.IPostService;
import kr.or.ddit.user.model.User;

@Controller
public class PostController {
	private static final Logger logger = LoggerFactory.getLogger(PostController.class);
	
	@Resource(name = "postService")
	private IPostService postService;
	
	@Resource(name = "attaFileService")
	private IAttaFileService attaFileService;
	
	@Resource(name = "commentsService")
	private ICommentsService commService;
	
	@RequestMapping(path = "detail", method = RequestMethod.GET)
	public String postDetailView(int postseq, Model model) {
		Post bPost = postService.getPost(postseq);
		List<AttaFile> attaList = attaFileService.getAttaFileList(postseq);
		List<Comments> commList = commService.getCommList(postseq);
		
		model.addAttribute("commList", commList);
		model.addAttribute("attaList", attaList);
		model.addAttribute("bPost", bPost);
		
		return "/post/postDetail";
	}
	
	@RequestMapping(path = "detail", method = RequestMethod.POST)
	public String postDetailView(String pmode, HttpSession session, 
					int delpostseq, int commpostseq, String commcomment, int commseq, int commdelpostseq) {
		logger.debug("pmode : {}", pmode);
		
		return "main";
//		if(pmode.equals("del")) {
//			try {
//				PostBoard boardVo = (PostBoard) session.getAttribute("S_POSTBOARDVO");
//				
//				int deleteCnt = postService.deletePost(delpostseq);
//				if(deleteCnt == 1) {
//					return "redirect:/board?menuBoardSeq=" + boardVo.getBoardseq();
//				}else {
//					return "/post/postDetail";
//				}
//			}catch(Exception e) {
//				return "/post/postDetail";
//			}
//		}else if(pmode.equals("insComm")) {
//			User user = (User) session.getAttribute("S_USERVO");
//			
//			logger.debug("seq : {}, comment : {}, writer : {}", commpostseq, commcomment, user.getUserId());
//			Comments comm = new Comments();
//			comm.setCommwriter(user.getUserId());
//			comm.setCommcont(commcomment);
//			comm.setPostseq(commpostseq);
//			
//			int insertCnt = commService.insertComm(comm);
//			if(insertCnt == 1) {
//				return "redirect:/detail?postseq=" + commpostseq;
//			}else {
//				return "/post/postDetail";
//			}
//		}else if(pmode.equals("commdele")) {
//			logger.debug("seq : {}", commseq);
//			Comments comm = new Comments();
//			comm.setCommseq(commseq);
//			
//			int deleteCnt = commService.deleteComm(comm);
//			if(deleteCnt == 1) {
//				return "redirect:/detail?postseq=" + commdelpostseq;
//			}else {
//				return "/post/postDetail";
//			}
//		}else {
//			return "/post/postDetail";
//		}
	}
	
	@RequestMapping(path = "postForm", method = RequestMethod.GET)
	public String postFormView() {
		return "post/postForm";
	}
	
	@RequestMapping(path = "postForm", method = RequestMethod.POST)
	public String postForm(String posttitle, HttpSession session) {
		PostBoard postBoardVo = (PostBoard) session.getAttribute("S_POSTBOARDVO");
		User userVo = (User) session.getAttribute("S_USERVO");
		
		logger.debug("postForm - posttitle : {}", posttitle);
		logger.debug("postForm - postBoardVo : {}", postBoardVo);
		logger.debug("postForm - userVo : {}", userVo);
		
		return "post/postForm";
	}
}
