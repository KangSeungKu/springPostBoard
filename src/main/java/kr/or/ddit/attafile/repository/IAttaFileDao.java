package kr.or.ddit.attafile.repository;

import java.util.List;

import kr.or.ddit.attafile.model.AttaFile;

public interface IAttaFileDao {
	int insertAttaFile(AttaFile attaFile);
	
	int deleteAttaFile(int attaseq);
	
	int deletePostAttaFile(int postseq);
	
	List<AttaFile> getAttaFileList(int postseq);
	
	AttaFile getAttaFile(int attaseq);
}
