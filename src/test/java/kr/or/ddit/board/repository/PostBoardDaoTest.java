package kr.or.ddit.board.repository;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.board.model.PostBoard;
import kr.or.ddit.config.test.RootTestConfig;

public class PostBoardDaoTest extends RootTestConfig {
	@Resource(name = "postBoardDao")
	private IPostBoardDao postBoardDao;

	@Test
	public void insertPostBoardTest() throws ParseException {
		/***Given***/
		PostBoard board = new PostBoard();
		board.setBoardnm("공지사항");
		board.setUserid("brown");
		board.setBoard_dt(new SimpleDateFormat("yyyy-MM-dd").parse("2019-09-20"));

		/***When***/
		int insertCnt = postBoardDao.insertPostBoard(board);

		/***Then***/
		assertEquals(1, insertCnt);
	}

	@Test
	public void updatePostBoardTest() throws ParseException {
		/***Given***/
		PostBoard board = new PostBoard();
		board.setBoardseq(3);
		board.setBoardnm("공지사항(수정)");
		board.setUserid("brown");
		board.setBoard_dt(new SimpleDateFormat("yyyy-MM-dd").parse("2019-09-20"));

		/***When***/
		int updateCnt = postBoardDao.updatePostBoard(board);

		/***Then***/
		assertEquals(1, updateCnt);
	}
	
	@Test
	public void deletePostBoardTest() {
		/***Given***/
		int boardSeq = 3;

		/***When***/
		int deleteCnt = postBoardDao.deletePostBoard(boardSeq);
		
		/***Then***/
		assertEquals(1, deleteCnt);
	}
	
	@Test
	public void getPostBoardListTest() {
		/***Given***/

		/***When***/
		List<PostBoard> list = postBoardDao.getPostBoardList();

		/***Then***/
		assertEquals(7, list.size());
	}

	@Test
	public void getPostBoardTest() {
		/***Given***/
		int boardSeq = 1;

		/***When***/
		PostBoard postBoard = postBoardDao.getPostBoard(boardSeq);

		/***Then***/
		assertEquals("자유게시판", postBoard.getBoardnm());
	}
}
