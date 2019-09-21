package kr.or.ddit.comments.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.comments.model.Comments;
import kr.or.ddit.comments.repository.ICommentsDao;

@Service
public class CommentsService implements ICommentsService {
	
	@Resource(name = "commentsDao")
	private ICommentsDao commentsDao;
	
	@Override
	public int insertComm(Comments comm) {
		return commentsDao.insertComm(comm);
	}

	@Override
	public int updateComm(Comments comm) {
		return commentsDao.updateComm(comm);
	}

	@Override
	public int deleteComm(Comments comm) {
		return commentsDao.deleteComm(comm);
	}

	@Override
	public List<Comments> getCommList(int postSeq) {
		return commentsDao.getCommList(postSeq);
	}

}
