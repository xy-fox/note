package com.xf.util;

public class Page {
      private int everyPage;  //每页显示的记录数
      private int totalCount; //总共有多少条记录数
      private int totalPage;  //总页数
      private int currenPage;  //当前页
      private int begainIndex;  //起始页
      private boolean hasRePage;  //是否有前一页
      private boolean hasNextPage;  //是否有下一页
	public Page(int everyPage, int totalCount, int totalPage, int currenPage, int begainIndex, boolean hasRePage,
			boolean hasNextPage) {
		super();
		this.everyPage = everyPage;
		this.totalCount = totalCount;
		this.totalPage = totalPage;
		this.currenPage = currenPage;
		this.begainIndex = begainIndex;
		this.hasRePage = hasRePage;
		this.hasNextPage = hasNextPage;
	}
	public int getEveryPage() {
		return everyPage;
	}
	public void setEveryPage(int everyPage) {
		this.everyPage = everyPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCurrenPage() {
		return currenPage;
	}
	public void setCurrenPage(int currenPage) {
		this.currenPage = currenPage;
	}
	public int getBegainIndex() {
		return begainIndex;
	}
	public void setBegainIndex(int begainIndex) {
		this.begainIndex = begainIndex;
	}
	public boolean isHasRePage() {
		return hasRePage;
	}
	public void setHasRePage(boolean hasRePage) {
		this.hasRePage = hasRePage;
	}
	public boolean isHasNextPage() {
		return hasNextPage;
	}
	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}
      
      
}
