package kr.or.ddit.board.repository;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.board.model.PostBoard;

@Repository
public class PostBoardDao implements IPostBoardDao {
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	/**
	* Method : insertPostBoard
	* 작성자 : PC-16
	* 변경이력 :
	* @param sqlSession
	* @param board
	* @return
	* Method 설명 : 게시판 생성
	*/
	@Override
	public int insertPostBoard(PostBoard board) {
		return sqlSession.insert("postboard.insertPostBoard", board);
	}

	/**
	* Method : updatePostBoard
	* 작성자 : PC-16
	* 변경이력 :
	* @param sqlSession
	* @param board
	* @return
	* Method 설명 : 게시판 수정
	*/
	@Override
	public int updatePostBoard(PostBoard board) {
		return sqlSession.update("postboard.updatePostBoard", board);
	}

	/**
	* Method : deletePostBoard
	* 작성자 : PC-16
	* 변경이력 :
	* @param sqlSession
	* @param boardSeq
	* @return
	* Method 설명 : 게시판 삭제
	*/
	@Override
	public int deletePostBoard(int boardSeq) {
		return sqlSession.delete("postboard.deletePostBoard", boardSeq);
	}

	/**
	* Method : getPostBoardList
	* 작성자 : PC-16
	* 변경이력 :
	* @param sqlSession
	* @return
	* Method 설명 : 게시판 전체조회
	*/
	@Override
	public List<PostBoard> getPostBoardList() {
		return sqlSession.selectList("postboard.getPostBoardList");
	}

	/**
	* Method : getPostBoard
	* 작성자 : PC-16
	* 변경이력 :
	* @param sqlSession
	* @param boardSeq
	* @return
	* Method 설명 : 게시판 단일조회
	*/
	@Override
	public PostBoard getPostBoard(int boardSeq) {
		return sqlSession.selectOne("postboard.getPostBoard", boardSeq);
	}

}
