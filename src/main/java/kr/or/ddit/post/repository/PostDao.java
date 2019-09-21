package kr.or.ddit.post.repository;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.post.model.Post;

@Repository
public class PostDao implements IPostDao {
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;

	@Override
	public int insertPost(Post bpost) {
		return sqlSession.insert("bPost.insertPost", bpost);
	}

	@Override
	public int updatePost(Post bpost) {
		return sqlSession.update("bPost.updatePost", bpost);
	}

	@Override
	public int deletePost(int postseq) {
		return sqlSession.delete("bPost.deletePost", postseq);
	}

	@Override
	public List<Post> getPostList(Page page) {
		return sqlSession.selectList("bPost.getPostList", page);
	}
	
	@Override
	public int getPostTotalCnt(int boardseq) {
		return sqlSession.selectOne("bPost.getPostTotalCnt", boardseq);
	}

	@Override
	public Post getPost(int postseq) {
		return sqlSession.selectOne("bPost.getPost", postseq);
	}

	@Override
	public int dropPost(int postseq) {
		return sqlSession.delete("bPost.dropPost", postseq);
	}

	@Override
	public int insertReplyPost(Post bpost) {
		return sqlSession.insert("bPost.insertReplyPost", bpost);
	}

	@Override
	public int getMaxPostNum() {
		return sqlSession.selectOne("bPost.getMaxPostNum");
	}

}
