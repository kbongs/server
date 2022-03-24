package com.kh.mvc.board.model.service;

import java.sql.Connection;
import java.util.List;

import com.kh.mvc.board.model.dao.BoardDao;
import com.kh.mvc.board.model.vo.Board;
import com.kh.mvc.board.model.vo.Reply;
import com.kh.mvc.common.util.PageInfo;

import static com.kh.mvc.common.jdbc.JDBCTemplate.*;

public class BoardService {
	
	private BoardDao dao = new BoardDao();

	public int getBoardCount() {
		int count = 0;
		Connection connection = getConnection();
		
		count = dao.getBoardCount(connection);
		
		close(connection);
		
		return count;
	}
	
	public Board findBoardByNo(int no, boolean hasRead) {
		Board board = null;
		Connection connection = getConnection();
		
		board = dao.findBoardByNo(connection, no);
		
		// 게시글 조회수를 증가시키는 로직
		if(board != null && !hasRead) {
			int result = dao.updateReadCount(connection, board);
			
			if(result > 0) {
				commit(connection);
			} else {
				rollback(connection);
			}
		}
		
		close(connection);		
		
		return board;
	}

	public List<Board> getBoardList(PageInfo pageInfo) {
		List<Board> list = null;
		Connection connection = getConnection();
		
		list = dao.findAll(connection, pageInfo);
		
		close(connection);
		
		return list;
	}

	public int save(Board board) {
		int result = 0;
		Connection connection = getConnection();
		
		if (board.getNo() != 0 ) {
			result = dao.updateBoard(connection, board);
		} else {
			result = dao.insertBoard(connection, board);
		}
		
		if(result > 0) {
			commit(connection);
		} else {
			rollback(connection);
		}
		
		close(connection);		
		
		return result;
	}

	public int delete(int no) {
		int result = 0;
		Connection connection = getConnection();
		
		result = dao.updateStatus(connection, no, "N");
		
		if(result > 0) {
			commit(connection);
		} else {
			rollback(connection);
		}
		
		close(connection);		
		
		return result;
	}
	
	public int saveReply(Reply reply) {
		int result = 0;
		Connection connection = getConnection();
		
		result = dao.insertReply(connection, reply);
		
		if(result > 0) {
			commit(connection);
		} else {
			rollback(connection);
		}
		
		close(connection);
		
		return result;
	}
}
