package kr.or.ddit.post.repository;

import java.util.List;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.post.model.Post;

public interface IPostDao {
	/**
	* Method : insertPost
	* 작성자 : PC-16
	* 변경이력 :
	* @param sqlSession
	* @param bpost
	* @return
	* Method 설명 :	게시글 생성
	*/
	int insertPost(Post bpost);
	
	/**
	* Method : insertReplyPost
	* 작성자 : PC-16
	* 변경이력 :
	* @param sqlSession
	* @param bpost
	* @return
	* Method 설명 : 답변작성
	*/
	int insertReplyPost(Post bpost);
	
	/**
	* Method : updatePost
	* 작성자 : PC-16
	* 변경이력 :
	* @param sqlSession
	* @param bpost
	* @return
	* Method 설명 : 게시글 수정
	*/
	int updatePost(Post bpost);
	
	/**
	* Method : deletePost
	* 작성자 : PC-16
	* 변경이력 :
	* @param sqlSession
	* @param postseq
	* @return
	* Method 설명 : 게시글 삭제(테이블 삭제 안함)
	*/
	int deletePost(int postseq);
	
	/**
	* Method : getPostList
	* 작성자 : PC-16
	* 변경이력 :
	* @param sqlSession
	* @return
	* Method 설명 : 해당 게시판의 게시글 전체조회(페이지네이션 적용)
	*/
	List<Post> getPostList(Page page);
	
	/**
	* Method : getPostTotalCnt
	* 작성자 : PC-16
	* 변경이력 :
	* @param sqlSession
	* @param boardseq
	* @return
	* Method 설명 : 전체 사용자 건수 조회
	*/
	int getPostTotalCnt(int boardseq);
	
	/**
	* Method : getPost
	* 작성자 : PC-16
	* 변경이력 :
	* @param postseq
	* @return
	* Method 설명 : 게시글 단일조회
	*/
	Post getPost(int postseq);
	
	/**
	* Method : dropPost
	* 작성자 : PC-16
	* 변경이력 :
	* @param sqlSession
	* @param postseq
	* @return
	* Method 설명 : 게시글 삭제
	*/
	int dropPost(int postseq);
	
	/**
	* Method : getMaxPostNum
	* 작성자 : PC-16
	* 변경이력 :
	* @param sqlSession
	* @return
	* Method 설명 : 게시글 번호의 최대값 조회
	*/
	int getMaxPostNum();
}
