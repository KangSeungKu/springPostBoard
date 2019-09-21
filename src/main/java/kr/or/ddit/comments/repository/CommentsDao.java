package kr.or.ddit.comments.repository;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.comments.model.Comments;

@Repository
public class CommentsDao implements ICommentsDao {
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int insertComm(Comments comm) {
		return sqlSession.insert("comm.insertComm", comm);
	}

	@Override
	public int updateComm(Comments comm) {
		return sqlSession.update("comm.updateComm", comm);
	}

	@Override
	public int deleteComm(Comments comm) {
		return sqlSession.update("comm.deleteComm", comm);
	}

	@Override
	public List<Comments> getCommList(int postSeq) {
		return sqlSession.selectList("comm.getCommList", postSeq);
	}

}
