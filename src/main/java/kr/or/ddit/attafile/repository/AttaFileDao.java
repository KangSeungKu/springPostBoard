package kr.or.ddit.attafile.repository;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.attafile.model.AttaFile;

@Repository
public class AttaFileDao implements IAttaFileDao {
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;

	@Override
	public int insertAttaFile(AttaFile attaFile) {
		return sqlSession.insert("attaFile.insertAttaFile", attaFile);
	}

	@Override
	public int deleteAttaFile(int attaseq) {
		return sqlSession.delete("attaFile.deleteAttaFile", attaseq);
	}

	@Override
	public List<AttaFile> getAttaFileList(int postseq) {
		return sqlSession.selectList("attaFile.getAttaFileList", postseq);
	}

	@Override
	public int deletePostAttaFile(int postseq) {
		return sqlSession.delete("attaFile.deletePostAttaFile", postseq);
	}

	@Override
	public AttaFile getAttaFile(int attaseq) {
		return sqlSession.selectOne("attaFile.getAttaFile", attaseq);
	}

}
