package impl;

import java.util.List;

import impl.BoardDAO;
import model.BoardDB;
import model.BoardService;

public class BoardServiceImpl implements BoardService {
	BoardDAO dao = new BoardDAO();
	


	@Override
	public void insertBoard(BoardDB board) {
		dao.insertBoard(board);
	}

	@Override
	public List<BoardDB> getBoardList() {
		List<BoardDB> list = dao.getBoardList();
		return list;
	}

	@Override
	public BoardDB getBoard(int boardNo) {
		return dao.getBoard(boardNo);
	}

	@Override
	public void updateBoard(BoardDB board) {
		//해당글에 대한 권한 확인.
		
		dao.updateBoard(board);
		System.out.println("변경됨");
			
	}
	
	@Override
	public void deleteBoard(BoardDB board) {
		
		dao.deleteBoard(board);}
		
		
		
	}



