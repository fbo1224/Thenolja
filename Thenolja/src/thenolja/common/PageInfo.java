package thenolja.common;

public class PageInfo {
	
	private int listCount;
	private int currentPage;
	private int pagetLimit;
	private int boardLimit;
	
	private int maxPage;
	private int startPage;
	private int endPage;
	
	public PageInfo() {
		super();
	}

	public PageInfo(int listCount, int currentPage, int pagetLimit, int boardLimit, int maxPage, int startPage,
			int endPage) {
		super();
		this.listCount = listCount;
		this.currentPage = currentPage;
		this.pagetLimit = pagetLimit;
		this.boardLimit = boardLimit;
		this.maxPage = maxPage;
		this.startPage = startPage;
		this.endPage = endPage;
	}

	public int getListCount() {
		return listCount;
	}

	public void setListCount(int listCount) {
		this.listCount = listCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPagetLimit() {
		return pagetLimit;
	}

	public void setPagetLimit(int pagetLimit) {
		this.pagetLimit = pagetLimit;
	}

	public int getBoardLimit() {
		return boardLimit;
	}

	public void setBoardLimit(int boardLimit) {
		this.boardLimit = boardLimit;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + boardLimit;
		result = prime * result + currentPage;
		result = prime * result + endPage;
		result = prime * result + listCount;
		result = prime * result + maxPage;
		result = prime * result + pagetLimit;
		result = prime * result + startPage;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PageInfo other = (PageInfo) obj;
		if (boardLimit != other.boardLimit)
			return false;
		if (currentPage != other.currentPage)
			return false;
		if (endPage != other.endPage)
			return false;
		if (listCount != other.listCount)
			return false;
		if (maxPage != other.maxPage)
			return false;
		if (pagetLimit != other.pagetLimit)
			return false;
		if (startPage != other.startPage)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PageInfo [listCount=" + listCount + ", currentPage=" + currentPage + ", pagetLimit=" + pagetLimit
				+ ", boardLimit=" + boardLimit + ", maxPage=" + maxPage + ", startPage=" + startPage + ", endPage="
				+ endPage + "]";
	}
	
	

}
