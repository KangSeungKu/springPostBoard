package kr.or.ddit.post.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.attafile.model.AttaFile;
import kr.or.ddit.attafile.service.IAttaFileService;
import kr.or.ddit.board.model.PostBoard;
import kr.or.ddit.comments.model.Comments;
import kr.or.ddit.comments.service.ICommentsService;
import kr.or.ddit.post.model.Post;
import kr.or.ddit.post.service.IPostService;
import kr.or.ddit.user.model.User;
import kr.or.ddit.util.FileUtil;
import kr.or.ddit.util.model.FileInfo;

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
	
	@RequestMapping(path = "delPost", method = RequestMethod.GET)
	public String delPost(int delpostseq, HttpSession session) {
		try {
			PostBoard boardVo = (PostBoard) session.getAttribute("S_POSTBOARDVO");
			int deleteCnt = postService.deletePost(delpostseq);
			if(deleteCnt == 1) {
				return "redirect:/board?menuBoardSeq=" + boardVo.getBoardseq();
			}else {
				return "/post/postDetail";
			}
		} catch (Exception e) {
			return "/post/postDetail";
		}
	}
	
	@RequestMapping(path = "insertComm", method = RequestMethod.GET)
	public String instComm(HttpSession session, Comments comm) {
		try {
			User user = (User) session.getAttribute("S_USERVO");
			comm.setCommwriter(user.getUserId());
			int insertCnt = commService.insertComm(comm);
			if(insertCnt == 1) {
				return "redirect:/detail?postseq=" + comm.getPostseq();
			}else {
				return "/post/postDetail";
			}
		} catch (Exception e) {
			return "/post/postDetail";
		}
	}
	
	@RequestMapping(path = "delComm", method = RequestMethod.GET)
	public String delComm(Comments comm) {
		try {
			int deleteCnt = commService.deleteComm(comm);
			if(deleteCnt == 1) {
				return "redirect:/detail?postseq=" + comm.getPostseq();
			}else {
				return "/post/postDetail";
			}
		} catch (Exception e) {
			return "/post/postDetail";
		}
	}
	
	@RequestMapping(path = "postForm", method = RequestMethod.GET)
	public String postFormView() {
		return "post/postForm";
	}
	
	@RequestMapping(path = "postForm", method = RequestMethod.POST)
	public String postForm(Post post, HttpSession session, @RequestPart("picture") List<MultipartFile> partFile) {
		PostBoard postBoardVo = (PostBoard) session.getAttribute("S_POSTBOARDVO");
		User userVo = (User) session.getAttribute("S_USERVO");
		
		post.setBoardseq(postBoardVo.getBoardseq());
		post.setUserid(userVo.getUserId());
		post.setPostdel("Y");
		logger.debug("post : {}", post);
		
		List<AttaFile> attaList = new ArrayList<AttaFile>();
		
		for(MultipartFile p : partFile) {
			if(p.getSize() > 0) {
				if("picture".equals(p.getName())) {
					FileInfo fileInfo = FileUtil.getFileInfo(p.getOriginalFilename());
					logger.debug("postForm - fileInfo : {}", fileInfo);
					
					AttaFile file = new AttaFile(p.getOriginalFilename(), fileInfo.getPath());
					attaList.add(file);
					try {
						p.transferTo(fileInfo.getFile());
					} catch (IllegalStateException | IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		int insertCnt =  postService.insertPost(post, attaList);
		
		int nextSeq = postService.getMaxPostNum();
		
		return "redirect:/detail?postseq=" + nextSeq;
	}
	
	@RequestMapping(path = "replyForm", method = RequestMethod.GET)
	public String replyFormView(int reppostseq, Model model) {
		Post bpost = postService.getPost(reppostseq);
		
		model.addAttribute("rPost", bpost);
		return "post/replyForm";
	}
	
	@RequestMapping(path = "replyForm", method = RequestMethod.POST)
	public String replyForm(Post post, HttpSession session, @RequestPart("picture") List<MultipartFile> partFile) {
		User userVo = (User) session.getAttribute("S_USERVO");
		PostBoard postBoardVo = (PostBoard) session.getAttribute("S_POSTBOARDVO");
		int boardseq = postBoardVo.getBoardseq();
		post.setBoardseq(postBoardVo.getBoardseq());
		post.setUserid(userVo.getUserId());
		post.setPostdel("Y");
		logger.debug("replyForm - post : {}", post);
		
		List<AttaFile> attaList = new ArrayList<AttaFile>();
		
		for(MultipartFile p : partFile) {
			if(p.getSize() > 0) {
				if("picture".equals(p.getName())) {
					FileInfo fileInfo = FileUtil.getFileInfo(p.getOriginalFilename());
					logger.debug("postForm - fileInfo : {}", fileInfo);
					
					AttaFile file = new AttaFile(p.getOriginalFilename(), fileInfo.getPath());
					attaList.add(file);
					try {
						p.transferTo(fileInfo.getFile());
					} catch (IllegalStateException | IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		int replyCnt = postService.insertReplyPost(post, attaList);
		
		int nextSeq = postService.getMaxPostNum();
		
		return "redirect:/detail?postseq=" + nextSeq;
	}
	
	@RequestMapping(path = "postModifyForm", method = RequestMethod.GET)
	public String postModifyFormView(int modipostseq, Model model) {
		Post mPost = postService.getPost(modipostseq);
		List<AttaFile> attaList = attaFileService.getAttaFileList(modipostseq);
		
		model.addAttribute("mPost", mPost);
		model.addAttribute("attaList", attaList);
		
		return "post/postModifyForm";
	}
	
	@RequestMapping(path = "postModifyForm", method = RequestMethod.POST)
	public String postModifyForm(Post post, @RequestPart("picture") List<MultipartFile> partFile) {
		for(MultipartFile p : partFile) {
			if(p.getSize() > 0) {
				if("picture".equals(p.getName())) {
					FileInfo fileInfo = FileUtil.getFileInfo(p.getOriginalFilename());
					logger.debug("postForm - fileInfo : {}", fileInfo);
					
					AttaFile file = new AttaFile(p.getOriginalFilename(), fileInfo.getPath(), post.getPostseq());
					attaFileService.insertAttaFile(file);
					try {
						p.transferTo(fileInfo.getFile());
					} catch (IllegalStateException | IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		int updateCnt = postService.updatePost(post);
		
		if(updateCnt == 1) {
			return "redirect:/detail?postseq=" + post.getPostseq();
		}else {
			return "post/postModifyForm";
		}
	}
	
	@RequestMapping(path = "delFile", method = RequestMethod.GET)
	public String delFile(int postseq, int attaseq) {
		try {
			int deleteCnt = attaFileService.deleteAttaFile(attaseq);
			if(deleteCnt == 1) {
				return "redirect:/postModifyForm?modipostseq=" + postseq;
			}else {
				return "post/postModifyForm";
			}
		} catch (Exception e) {
			return "post/postModifyForm";
		}
	}
	
	@RequestMapping(path = "attaFileDown", method = RequestMethod.GET)
	public String downFile(int atseq, Model model) {
		AttaFile attaFile = attaFileService.getAttaFile(atseq);
		model.addAttribute("pictureName", attaFile);
		
		return "fileDownloadView";
	}
}
