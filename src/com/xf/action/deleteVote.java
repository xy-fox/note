package com.xf.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.xf.Dao.VoteDao;
import com.xf.Dao.VoteOptionDao;
import com.xf.Factory.VoteImpleFactory;
import com.xf.Factory.VoteOptionFactory;
import com.xf.javaben.VoteOption;

public class deleteVote extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int voteID;
	
		public int getVoteID() {
		return voteID;
	}

	public void setVoteID(int voteID) {
		this.voteID = voteID;
	}

		public String deletevote(){
			VoteOptionDao vDao = VoteOptionFactory.getVoteOptionImple();
			VoteDao voteDao = VoteImpleFactory.getVoteImple();
			
			List<VoteOption> voteOptions = vDao.findByvoteID(voteID);
			for(VoteOption voteOption :voteOptions){
				vDao.deletVoteOption(voteOption.getVoteoptionID());
			}
			
			voteDao.deletVote(voteID);
			
			return "SUCCESS";
			
		}
}
