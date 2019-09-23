package kr.or.ddit.util.model;

import java.io.File;

public class FileInfo {
	private File file;					// 업로드 경로를 포함한 파일 객체
	private String originalFileName;	// 업로드한 실제 파일명
	private String extName;				// 파일 확장자 (.포함)
	private String path;
	
	public FileInfo() {   }
	
	public FileInfo(File file, String extName, String originalFileName, String path) {
		this.file = file;
		this.extName = extName;
		this.originalFileName = originalFileName;
		this.path = path;
	}
	
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getOriginalFileName() {
		return originalFileName;
	}
	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}
	public String getExtName() {
		return extName;
	}
	public void setExtName(String extName) {
		this.extName = extName;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	@Override
	public String toString() {
		return "FileInfo [file=" + file + ", originalFileName=" + originalFileName + ", extName=" + extName + ", path="
				+ path + "]";
	}
	
	
}
