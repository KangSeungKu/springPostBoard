package kr.or.ddit.attafile.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.attafile.model.AttaFile;
import kr.or.ddit.attafile.repository.IAttaFileDao;

@Service
public class AttaFileService implements IAttaFileService {
	
	@Resource(name = "attaFileDao")
	private IAttaFileDao attaFileDao;
	
	@Override
	public int insertAttaFile(AttaFile attaFile) {
		return attaFileDao.insertAttaFile(attaFile);
	}

	@Override
	public int deleteAttaFile(int attaseq) {
		return attaFileDao.deleteAttaFile(attaseq);
	}

	@Override
	public List<AttaFile> getAttaFileList(int postseq) {
		return attaFileDao.getAttaFileList(postseq);
	}

	@Override
	public int deletePostAttaFile(int postseq) {
		return attaFileDao.deletePostAttaFile(postseq);
	}

	@Override
	public AttaFile getAttaFile(int attaseq) {
		return attaFileDao.getAttaFile(attaseq);
	}

}
