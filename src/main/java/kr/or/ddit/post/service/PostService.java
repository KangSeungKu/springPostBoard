package kr.or.ddit.post.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.attafile.model.AttaFile;
import kr.or.ddit.attafile.repository.IAttaFileDao;
import kr.or.ddit.common.model.Page;
import kr.or.ddit.post.model.Post;
import kr.or.ddit.post.repository.IPostDao;

@Service
public class PostService implements IPostService {
	
	@Resource(name = "postDao")
	private IPostDao postDao;
	
	@Resource(name = "attaFileDao")
	private IAttaFileDao attaFileDao;
	
	@Override
	public int insertPost(Post bpost, List<AttaFile> attaList) {
		int insertCnt = postDao.insertPost(bpost);
		
		if(attaList.size() > 0) {			
			for(AttaFile file : attaList) {
				file.setPostseq(bpost.getPostseq());
				attaFileDao.insertAttaFile(file);
			}
		}
		
		return insertCnt;
	}

	@Override
	public int updatePost(Post bpost) {
		return postDao.updatePost(bpost);
	}

	@Override
	public int deletePost(int postseq) {
		return postDao.deletePost(postseq);
	}

	@Override
	public Map<String, Object> getPostList(Page page) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<Post> list = postDao.getPostList(page);
		int totalCnt = postDao.getPostTotalCnt(page.getBoardseq());
		
		map.put("postList", list);
		map.put("paginationSize", (int)Math.ceil((double)totalCnt / page.getPagesize()));
		
		return map;
	}

	@Override
	public Post getPost(int postseq) {
		return postDao.getPost(postseq);
	}

	@Override
	public int insertReplyPost(Post bpost, List<AttaFile> attaList) {
		int insertCnt = postDao.insertReplyPost(bpost);
		
		if(attaList.size() > 0) {			
			for(AttaFile file : attaList) {
				file.setPostseq(bpost.getPostseq());
				attaFileDao.insertAttaFile(file);
			}
		}
		
		return insertCnt;
	}

	@Override
	public int getMaxPostNum() {
		return postDao.getMaxPostNum();
	}

}
