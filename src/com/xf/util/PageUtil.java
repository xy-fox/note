package com.xf.util;

public class PageUtil {
	/*
	 * Page是一个对象，封装了everyPage currenPage totalPage begainIndex hasRePage hasNextPage totalCount 这7个属性
	 * 通过新建一个对象获得封装好信息的分页对象
	 */
	public static Page creatPage(int everyPage,int currenPage,int totalCount){
		//everyPage = PageUtil.getEveryPage(everyPage);调用本类中的静态函数getEveryPage(everyPage)。
		everyPage = getEveryPage(everyPage);
		currenPage = getCurrenPage(currenPage);
		int totalPage = getTotalPage(everyPage, totalCount);
		int begainIndex = getBegainIndex(everyPage, currenPage);
		boolean hasRePage = getHasRePage(currenPage);
		boolean hasNextPage = getHasNextPage(currenPage, totalPage);
		return new Page(everyPage, totalCount, totalPage, currenPage, begainIndex, hasRePage, hasNextPage);
	}
     public static int getEveryPage(int everyPage){ //获取每页显示的记录数有多少条
    	 return everyPage == 0?10:everyPage;
     }
     
     public static int getCurrenPage(int currenPage){ //当前页数是第几页
    	 return currenPage == 0?1:currenPage;
     }
     
     public static int getTotalPage(int everyPage,int totalCount){ //获得总的页数
    	 /*
    	  * 分两种情况：若总条数与每页显示的条数是整数倍则总页数为总记录数除以每页显示的条数；若总条数与每页显示的条数不是整数倍，则还需要加1 
    	  */
    	 int totalPage=0;
    	 if (totalCount != 0 && totalCount%everyPage == 0) {
    		 totalPage = totalCount/everyPage;
		}else {
			totalPage = totalCount/everyPage+1;
		}
    	 return totalPage;
     }
     
     public static int getBegainIndex(int everyPage,int currenPage){ //获得起始页
    	 return (currenPage - 1)*everyPage;
     }
     
     public static boolean getHasRePage(int currenPage){  //判断是否还有上一页
    	 return currenPage == 1?false:true;
     }
     
     public static boolean getHasNextPage(int currenPage,int totalPage){ //判断是否还有下一页
    	 return currenPage == totalPage || totalPage == 0?false:true;
     }
}
