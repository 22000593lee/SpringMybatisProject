package com.example.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.board.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	
	//Connection conn = null;
	//PreparedStatement stmt = null;
	//ResultSet rs = null;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int insertBoard(BoardVO vo) {
		String sql = "insert into BOARD (title, writer, content) values ("
				+"'"+vo.getTitle()+"',"
				+"'"+vo.getWriter()+"',"
				+"'"+vo.getContent()+"')";
		return jdbcTemplate.update(sql);
	}
	public int deleteBoard(int seq) {
		String sql = "delete from BOARD where seq="+seq;
		return jdbcTemplate.update(sql);
	}
	public int updateBoard(BoardVO vo) {
		String sql = "update BOARD set title='"+vo.getTitle()+"',"
				+" writer='"+vo.getWriter()+"',"
				+" content='"+vo.getContent()+"' where seq="+vo.getSeq();
		return jdbcTemplate.update(sql);
	}	
	
	public BoardVO getBoard(int seq) {
		String sql = "select * from BOARD where seq="+seq;
		return jdbcTemplate.queryForObject(sql, new BoardLowMapper());
	}
	
	public List<BoardVO> getBoardList(){
		String sql = "select * from BOARD order by regdate desc";
		return jdbcTemplate.query(sql, new BoardLowMapper());
	}


}
