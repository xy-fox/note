package com.xf.Factory;

import com.xf.Dao.VoteOptionDao;
import com.xf.imple.VoteOptionImple;

public class VoteOptionFactory {
		public static VoteOptionDao getVoteOptionImple(){
			return new VoteOptionImple();
		}
}
