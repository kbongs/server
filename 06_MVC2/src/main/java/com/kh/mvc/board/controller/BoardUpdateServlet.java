package com.kh.mvc.board.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mvc.board.model.service.BoardService;
import com.kh.mvc.board.model.vo.Board;
import com.kh.mvc.common.util.FileRename;
import com.oreilly.servlet.MultipartRequest;

@WebServlet("/board/update")
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BoardUpdateServlet() {
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인 체크 & 본인 게시글 수정 여부 확인(직접 적용시켜 보세요.)
		Board board = null;
		int no = Integer.parseInt(request.getParameter("no"));
		
		board = new BoardService().findBoardByNo(no, true);
		
		request.setAttribute("board", board);
		request.getRequestDispatcher("/views/board/update.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int result = 0;
    	Board board = null;
    	String originalFileName = null;
    	String renamedFileName = null;
    	String path = getServletContext().getRealPath("/resources/upload/board");
    	int maxSize = 10485760;
    	String encoding = "UTF-8";
    	MultipartRequest mr = new MultipartRequest(request, path, maxSize, encoding, new FileRename());
    	
    	board = new Board();
    	
    	board.setNo(Integer.parseInt(mr.getParameter("no")));
    	board.setTitle(mr.getParameter("title"));
    	board.setWriterId(mr.getParameter("writer"));
    	board.setContent(mr.getParameter("content"));
    	board.setOriginalFileName(mr.getParameter("originalFileName"));
    	board.setRenamedFileName(mr.getParameter("renamedFileName"));
    	
    	originalFileName = mr.getOriginalFileName("upfile");
    	renamedFileName = mr.getFilesystemName("upfile");
    	
    	if(originalFileName != null && !originalFileName.equals("")) {    		
    		File file = new File(path + "/" + board.getRenamedFileName());
    		
    		if (file.exists()) {
    			file.delete();
    		}
    		
    		board.setOriginalFileName(originalFileName);
        	board.setRenamedFileName(renamedFileName);
    	}
    	
    	result = new BoardService().save(board);
    	
    	if(result > 0) {
    		request.setAttribute("msg", "게시글 수정 성공");
    	} else {
    		request.setAttribute("msg", "게시글 실패 성공");
    	}
    	
    	request.setAttribute("location", "/board/view?no=" + board.getNo());
    	request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
	}

}
