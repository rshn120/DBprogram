package model;

import java.util.List;
import model.BoardDB;

public interface BoardService {
	
	//게시글 작성
	public void insertBoard(BoardDB board);
	//게시글 리스트
	public List<BoardDB>getBoardList();
	//한건 조회
	public BoardDB getBoard(int boardNo);
	//수정 글 작성자만 수정
	public void updateBoard(BoardDB board);
	//삭제 글 작성자만 삭제
	public void deleteBoard(BoardDB board);


	
	
}


