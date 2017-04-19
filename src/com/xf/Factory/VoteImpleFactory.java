package com.xf.Factory;

import com.xf.Dao.VoteDao;
import com.xf.imple.VoteDaoImple;

public class VoteImpleFactory {
		public static VoteDao getVoteImple(){
			return new VoteDaoImple();
		}
}
