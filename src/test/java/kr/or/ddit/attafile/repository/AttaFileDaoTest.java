package kr.or.ddit.attafile.repository;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.attafile.model.AttaFile;
import kr.or.ddit.config.test.RootTestConfig;

public class AttaFileDaoTest extends RootTestConfig{
	@Resource(name = "attaFileDao")
	private IAttaFileDao attaFileDao;
	
	@Test
	public void insertAttaFileTest() {
		/***Given***/
		AttaFile attaFile = new AttaFile();
		attaFile.setAttafilename("test.png");
		attaFile.setAttarealfilename("d:\\upload\\2019\\09\\test58c8-365b-4bee-a8c0-e8475d48b21d.png");
		attaFile.setPostseq(1);

		/***When***/
		int insertCnt = attaFileDao.insertAttaFile(attaFile);

		/***Then***/
		assertEquals(1, insertCnt);
	}

	@Test
	public void getAttaFileListTest() {
		/***Given***/
		int postseq = 35;

		/***When***/
		List<AttaFile> list = attaFileDao.getAttaFileList(postseq);

		/***Then***/
		assertEquals(2, list.size());
	}
	
	@Test
	public void getAttaFileTest() {
		/***Given***/
		int attaseq = 11;

		/***When***/
		AttaFile attaFile = attaFileDao.getAttaFile(attaseq);

		/***Then***/
		assertEquals("cony.png", attaFile.getAttafilename());
	}

}
