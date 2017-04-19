package com.xf.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xf.Dao.VoteDao;
import com.xf.Dao.VoteOptionDao;
import com.xf.Factory.VoteImpleFactory;
import com.xf.Factory.VoteOptionFactory;
import com.xf.javaben.Vote;
import com.xf.javaben.VoteOption;
import com.xf.javaben.VoteResult;
import com.xf.util.Page;
import com.xf.util.PageUtil;

public class ShowVoteAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
 
	private int currenPage;

	public int getCurrenPage() {
		return currenPage;
	}

	public void setCurrenPage(int currenPage) {
		this.currenPage = currenPage;
	}
	
	public String showVoteAction(){
		
		VoteDao voteDao = VoteImpleFactory.getVoteImple();
		VoteOptionDao vOptionDao = VoteOptionFactory.getVoteOptionImple();
		
		int count = voteDao.findAllCount(); //获取总记录数
		Page page = PageUtil.creatPage(10, currenPage, count); //计算分页数
		
		List<Vote> votes = new ArrayList<Vote>();   //用于存放获取投票列表
		votes = voteDao.findAllVotes(page);
		
		List<VoteResult> voteResults = new ArrayList<VoteResult>();
		for(Vote vote: votes){	
			
			VoteResult voteResult = new VoteResult();
			List<VoteOption> voteOptions = new ArrayList<>(); //用于存放投票列表相对应的投票选项
			voteOptions = vOptionDao.findByvoteID(vote.getVoteID());
			
			voteResult.setVote(vote);
			voteResult.setVoteOptions(voteOptions);
			voteResults.add(voteResult);
		}
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		request.setAttribute("PAGE", page);
		request.setAttribute("VOTERESULTS", voteResults);
		request.setAttribute("MESSAGE", "显示成功！！！");
		return "SUCCESS";
	}
}
