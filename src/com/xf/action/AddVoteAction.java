package com.xf.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xf.Dao.VoteDao;
import com.xf.Dao.VoteOptionDao;
import com.xf.Factory.VoteImpleFactory;
import com.xf.Factory.VoteOptionFactory;
import com.xf.javaben.AddVote;
import com.xf.javaben.Vote;
import com.xf.javaben.VoteOption;

public class AddVoteAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
	
	private int channel;
	private String voteName;
	private String[] voteOption;
	 
	 
	 public int getChannel() {
		return channel;
	}


	public void setChannel(int channel) {
		this.channel = channel;
	}


	public String getVoteName() {
		return voteName;
	}


	public void setVoteName(String voteName) {
		this.voteName = voteName;
	}


	public String[] getVoteOption() {
		return voteOption;
	}


	public void setVoteOption(String[] voteOption) {
		this.voteOption = voteOption;
	}


	public String addVoteAction(){
		 
		VoteDao voteDao = VoteImpleFactory.getVoteImple();
		VoteOptionDao vOptionDao = VoteOptionFactory.getVoteOptionImple();
		Vote vote = new Vote();
		vote.setChannelID(channel);
		vote.setVoteName(voteName);
		System.out.println("jhjhhghvgv"+channel);
		System.out.println("jhjhhghvgv"+voteName);
		voteDao.addVote(vote);
		
		int voteID = (voteDao.findByName(voteName)).getVoteID();
		for(String voteOptionName:voteOption){
			VoteOption vOption = new VoteOption();
			vOption.setVoteID(voteID);
			vOption.setVoteoptionName(voteOptionName);
			vOptionDao.addVoteOption(vOption);
		}
		request.setAttribute("MESSAGE", "发布成功!!!");
		return "SUCCESS";
	}
}
