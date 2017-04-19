package com.xf.imple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xf.Dao.VoteOptionDao;
import com.xf.javaben.Vote;
import com.xf.javaben.VoteOption;
import com.xf.util.JdbcUtil;

public class VoteOptionImple implements VoteOptionDao {

	@Override
	public void addVoteOption(VoteOption vOption) {
		Connection connection = JdbcUtil.getconnetion();
		String sql = "insert into voteoption(voteoptionName,voteID,tickNum) values(?,?,?)";
		PreparedStatement pStatement = null;
		
		try {
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, vOption.getVoteoptionName());
			pStatement.setInt(2, vOption.getVoteID());
			pStatement.setInt(3, vOption.getTickNum());
			pStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(connection, pStatement);
		}

	}

	@Override
	public void deletVoteOption(int voteOptionID) {
		Connection connection = JdbcUtil.getconnetion();
		String sql = "delete from voteoption where voteoptionID = ?";
		PreparedStatement pStatement = null;
		
		try {
			pStatement = connection.prepareStatement(sql);
			pStatement.setInt(1,voteOptionID);
			pStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(connection, pStatement);
		}

	}

	@Override
	public void updateVoteOption(int voteOptionID) {
		// TODO Auto-generated method stub

	}


	@Override
	public List<VoteOption> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VoteOption> findByvoteID(int voteID) {

		Connection connection = JdbcUtil.getconnetion();
		String sql = "select * from voteoption where voteID = ?";
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		List<VoteOption> vOptions = new ArrayList<VoteOption>();
		
		try {
			pStatement = connection.prepareStatement(sql);
			pStatement.setInt(1, voteID);
			resultSet = pStatement.executeQuery();
			
			while (resultSet.next()) {
					VoteOption vOption = new VoteOption();
					vOption.setVoteoptionID(resultSet.getInt(1));
					vOption.setVoteoptionName(resultSet.getString(2));
					vOption.setVoteID(resultSet.getInt(3));
					vOption.setTickNum(resultSet.getInt(4));
					vOptions.add(vOption);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(connection, pStatement);
			JdbcUtil.closeRs(resultSet);
		}
		return vOptions;
	}

}
