package kr.or.ddit.common.model;

public class Page {
	private int page;
	private int pagesize;
	private int boardseq;

	public Page() {   }

	public Page(int page, int pagesize) {
		this.page = page;
		this.pagesize = pagesize;
	}
	
	public Page(int page, int pagesize, int boardseq) {
		this.page = page;
		this.pagesize = pagesize;
		this.boardseq = boardseq;
	}

	public int getPage() {
		return page == 0 ? 1 : page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPagesize() {
		return pagesize == 0 ? 10 : pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getBoardseq() {
		return boardseq;
	}
	public void setBoardseq(int boardseq) {
		this.boardseq = boardseq;
	}

	@Override
	public String toString() {
		return "Page [page=" + page + ", pagesize=" + pagesize + ", boardseq=" + boardseq + "]";
	}
}
