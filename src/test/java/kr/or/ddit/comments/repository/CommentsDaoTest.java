package kr.or.ddit.comments.repository;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.comments.model.Comments;
import kr.or.ddit.config.test.RootTestConfig;

public class CommentsDaoTest extends RootTestConfig{
	@Resource(name = "commentsDao")
	private ICommentsDao commentsDao;
	
	@Test
	public void insertCommTest() {
		/***Given***/
		Comments comm = new Comments();
		comm.setCommcont("테스트코드 댓글입니다.");
		comm.setCommwriter("brown");
		comm.setPostseq(1);

		/***When***/
		int insertCnt = commentsDao.insertComm(comm);

		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	@Test
	public void updateCommTest() {
		/***Given***/
		Comments comm = new Comments();
		comm.setCommcont("댓글입니다.(테스트코드 - 수정)");
		comm.setCommwriter("brown");
		comm.setPostseq(1);
		comm.setCommseq(6);

		/***When***/
		int updateCnt = commentsDao.updateComm(comm);

		/***Then***/
		assertEquals(1, updateCnt);
	}
	
	@Test
	public void deleteCommTest() {
		/***Given***/
		Comments comm = new Comments();
		comm.setCommcont("댓글입니다.(삭제 - 테스트코드)");
		comm.setCommwriter("brown");
		comm.setPostseq(1);
		comm.setCommseq(6);

		/***When***/
		int deleteCnt = commentsDao.deleteComm(comm);

		/***Then***/
		assertEquals(1, deleteCnt);
	}
	
	@Test
	public void getCommList() {
		/***Given***/
		int postSeq = 1;

		/***When***/
		List<Comments> list = commentsDao.getCommList(postSeq);

		/***Then***/
		assertEquals(1, list.size());
	}
}
