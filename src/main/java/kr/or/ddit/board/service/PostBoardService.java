package kr.or.ddit.board.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.board.model.PostBoard;
import kr.or.ddit.board.repository.IPostBoardDao;

@Service
public class PostBoardService implements IPostBoardService{
	
	@Resource(name = "postBoardDao")
	private IPostBoardDao postBoardDao;
	
	@Override
	public int insertPostBoard(PostBoard board) {
		return postBoardDao.insertPostBoard(board);
	}

	@Override
	public int updatePostBoard(PostBoard board) {
		return postBoardDao.updatePostBoard(board);
	}

	@Override
	public int deletePostBoard(int boardSeq) {
		return postBoardDao.deletePostBoard(boardSeq);
	}

	@Override
	public List<PostBoard> getPostBoardList() {
		return postBoardDao.getPostBoardList();
	}

	@Override
	public PostBoard getPostBoard(int boardSeq) {
		return postBoardDao.getPostBoard(boardSeq);
	}

}
