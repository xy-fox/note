package com.xf.Dao;

import java.util.List;

import com.xf.javaben.VoteOption;

public interface VoteOptionDao {
		public void addVoteOption(VoteOption vOption);
		public void deletVoteOption(int voteOptionID);
		public void updateVoteOption(int voteOptionID);
		public List<VoteOption> findByvoteID(int voteID);
		public List<VoteOption> findAll();
}
