package com.example.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.example.bean.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {

	@Autowired
	private JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	private final String BOARD_INSERT = "insert into BOARD1 (category, title, writer, content) values (?,?,?,?)";
	private final String BOARD_UPDATE = "update BOARD1 set category=?, title=?, writer=?, content=? where seq=?";
	private final String BOARD_DELETE = "delete from BOARD1  where seq=?";
	private final String BOARD_GET = "select * from BOARD1 where seq=?";
	private final String BOARD_LIST = "select * from BOARD1 order by seq desc";

	public int insertBoard(BoardVO vo) {
		return template.update(BOARD_INSERT, new Object[]{vo.getCategory(), vo.getTitle(), vo.getWriter(), vo.getContent()});
	}

	public int deleteBoard(int seq) {
		return template.update(BOARD_DELETE, new Object[]{seq});
	}

	public int updateBoard(BoardVO vo) {
		return template.update(BOARD_UPDATE, new Object[]{vo.getCategory(), vo.getTitle(), vo.getWriter(), vo.getContent(), vo.getSeq()});
	}

	public BoardVO getBoard(int seq) {
		return template.queryForObject(BOARD_GET, new Object[] {seq}, new BeanPropertyRowMapper<BoardVO>(BoardVO.class));
	}

	public List<BoardVO> getBoardList(){
		return template.query(BOARD_LIST, new RowMapper<BoardVO>(){
			@Override
			public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				BoardVO data = new BoardVO();
				data.setSeq(rs.getInt("seq"));
				data.setCategory(rs.getString("category"));
				data.setTitle(rs.getString("title"));
				data.setRegdate(rs.getDate("regdate"));
				data.setWriter(rs.getString("writer"));
				data.setContent(rs.getString("content"));
				return data;
			}
		});
	}
}