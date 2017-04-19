package com.xf.imple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.xf.Dao.VoteDao;
import com.xf.javaben.Vote;
import com.xf.util.JdbcUtil;
import com.xf.util.Page;

public class VoteDaoImple implements VoteDao {

	@Override
	public void addVote(Vote vote) {
		Connection connection = JdbcUtil.getconnetion();
		String sql = "insert into vote(voteName,channelID) values(?,?)";
		PreparedStatement pStatement = null;
		
		try {
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, vote.getVoteName());
			pStatement.setInt(2, vote.getChannelID());
			pStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(connection, pStatement);
		}

	}

	@Override
	public void deletVote(int voteID) {
		Connection connection = JdbcUtil.getconnetion();
		String sql = "delete from vote where voteID = ?";
		PreparedStatement pStatement = null;
		
		try {
			pStatement = connection.prepareStatement(sql);
			pStatement.setInt(1, voteID);
			pStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(connection, pStatement);
		}

	}

	@Override
	public Vote findById(int voteID) {

		Connection connection = JdbcUtil.getconnetion();
		String sql = "select * from vote where voteID = ?";
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		Vote vote = new Vote();
		
		try {
			pStatement = connection.prepareStatement(sql);
			pStatement.setInt(1, voteID);;
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				vote.setVoteID(resultSet.getInt(1));
				vote.setVoteName(resultSet.getString(2));
				vote.setChannelID(resultSet.getInt(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtil.close(connection, pStatement);
			JdbcUtil.closeRs(resultSet);
		}
		
		return vote;
	}

	@Override
	public List<Vote> findAllVotes(Page page) {
		Connection connection = JdbcUtil.getconnetion();
		String sql = "select * from vote limit ?,?";
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		List<Vote> votes = new ArrayList<Vote>();
		
		try {
			pStatement = connection.prepareStatement(sql);
			pStatement.setInt(1, page.getBegainIndex());
			pStatement.setInt(2, page.getEveryPage());
			resultSet = pStatement.executeQuery();
			
			while (resultSet.next()) {
				Vote vote = new Vote();
				vote.setVoteID(resultSet.getInt(1));
				vote.setVoteName(resultSet.getString(2));
				vote.setChannelID(resultSet.getInt(3));
				votes.add(vote);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(connection, pStatement);
			JdbcUtil.closeRs(resultSet);
		}
		
		return votes;
	}

	@Override
	public Vote findByName(String voteName) {
		Connection connection = JdbcUtil.getconnetion();
		String sql = "select * from vote where voteName = ?";
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		Vote vote = new Vote();
		try {
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, voteName);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				vote.setVoteID(resultSet.getInt(1));
				vote.setVoteName(resultSet.getString(2));
				vote.setChannelID(resultSet.getInt(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtil.close(connection, pStatement);
			JdbcUtil.closeRs(resultSet);
		}
		return vote;
	}

	@Override
	public int findAllCount() {
		int count = 0;
		Connection connection = JdbcUtil.getconnetion();
		String sql = "select count(*) from vote";
		PreparedStatement pStatement = null;
		ResultSet Resuleset = null;
		
		try {
			pStatement = connection.prepareStatement(sql);
			Resuleset = pStatement.executeQuery();
			while(Resuleset.next()){
				count = Resuleset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(connection, pStatement);
			JdbcUtil.closeRs(Resuleset);
			
		}
		return count;
	}

	@Override
	public int fintCountByChannel(int channelID) {
		
		int count = 0;
		Connection connection = JdbcUtil.getconnetion();
		String sql = "select count(*) from vote where channelID =?";
		PreparedStatement pStatement = null;
		ResultSet Resuleset = null;
		
		try {
			pStatement = connection.prepareStatement(sql);
			pStatement.setInt(1, channelID);
			Resuleset = pStatement.executeQuery();
			while(Resuleset.next()){
				count = Resuleset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(connection, pStatement);
			JdbcUtil.closeRs(Resuleset);
			
		}
		return count;
	}

	@Override
	public List<Vote> findVotesByChannelID(Page page, int channelID) {
		
		Connection connection = JdbcUtil.getconnetion();
		String sql = "select * from vote where channelID =? limit ?,?";
		PreparedStatement pStatement = null;
		ResultSet resuleset = null;
		List<Vote> votes = new ArrayList<Vote>();
		
		try {
			pStatement = connection.prepareStatement(sql);
			pStatement.setInt(1, channelID);
			pStatement.setInt(2, page.getBegainIndex());
			pStatement.setInt(3, page.getEveryPage());
			resuleset = pStatement.executeQuery();
			
			while (resuleset.next()) {
				Vote vote = new Vote();
				vote.setVoteID(resuleset.getInt(1));
				vote.setVoteName(resuleset.getString(2));
				vote.setChannelID(resuleset.getInt(3));
				votes.add(vote);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(connection, pStatement);
			JdbcUtil.closeRs(resuleset);
		}
		
		
		return votes;
	}

}
