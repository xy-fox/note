package com.xf.Dao;

import java.util.List;

import com.xf.javaben.Vote;
import com.xf.util.Page;

public interface VoteDao { 
	public void addVote(Vote vote);
	public void deletVote(int voteID);
	public int fintCountByChannel(int channelID);
	public List<Vote> findVotesByChannelID(Page page,int channelID);
	public Vote findById(int voteID);
	public Vote findByName(String voteName);
	public List<Vote> findAllVotes(Page page);
	public int findAllCount();
}
