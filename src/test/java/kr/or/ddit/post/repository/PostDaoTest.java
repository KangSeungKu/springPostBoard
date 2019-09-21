package kr.or.ddit.post.repository;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.attafile.model.AttaFile;
import kr.or.ddit.attafile.repository.IAttaFileDao;
import kr.or.ddit.common.model.Page;
import kr.or.ddit.config.test.RootTestConfig;
import kr.or.ddit.post.model.Post;

public class PostDaoTest extends RootTestConfig{
	@Resource(name = "postDao")
	private IPostDao postDao;
	
	@Resource(name = "attaFileDao")
	private IAttaFileDao attaDao;
	
	@Test
	public void insertPostTest() {
		/***Given***/
		//int postseq = 1;
		//postDao.dropPost(sqlSession, postseq);
		
		Post bpost = new Post();
		bpost.setBoardseq(1);
		bpost.setPosttitle("공부 열심히 하라능");
		bpost.setPostcont("힘내세요");
		bpost.setUserid("brown");
		bpost.setPostdel("Y");
		
		AttaFile attaFile = new AttaFile();
		attaFile.setAttafilename("pom.png");
		attaFile.setAttarealfilename("alfjdlskalfkssldfj.png");

		/***When***/
		int insertCnt = postDao.insertPost(bpost);
		attaFile.setPostseq(bpost.getPostseq());
		int aInsertCnt = attaDao.insertAttaFile(attaFile);

		/***Then***/
		assertEquals(1, insertCnt);
		assertEquals(1, aInsertCnt);
	}
	
	@Test
	public void updatePostTest() {
		/***Given***/
		Post bpost2 = new Post();
		bpost2.setPostseq(3);
		bpost2.setPosttitle("공부 열심히 하라능");
		bpost2.setPostcont("힘내세요(수정)");

		/***When***/
		int updateCnt = postDao.updatePost(bpost2);

		/***Then***/
		assertEquals(1, updateCnt);
	}
	
	@Test
	public void deletePostTest() {
		/***Given***/
		int postseq = 2;

		/***When***/
		int deleteCnt = postDao.deletePost(postseq);

		/***Then***/
		assertEquals(1, deleteCnt);
	}
	
	@Test
	public void getPostListTest() {
		/***Given***/
		int boardseq = 1;
		Page page = new Page();
		page.setBoardseq(boardseq);
		page.setPage(1);
		page.setPagesize(10);

		/***When***/
		List<Post> list = postDao.getPostList(page);

		/***Then***/
		assertEquals(10, list.size());
	}

	@Test
	public void getPostTotalCntTest() {
		/***Given***/
		int boardseq = 1;

		/***When***/
		int totalCnt = postDao.getPostTotalCnt(boardseq);

		/***Then***/
		assertEquals(31, totalCnt);
	}
	
	@Test
	public void getPostTest() {
		/***Given***/
		int postseq = 3;

		/***When***/
		Post bpost = postDao.getPost(postseq);

		/***Then***/
		assertEquals("세번째 글은 두번째 글의 답글입니다", bpost.getPosttitle());
	}
}
