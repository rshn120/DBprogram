package control;

import java.util.List;
import java.util.Scanner;

import impl.BoardServiceImpl;
import model.BoardDB;
import model.BoardService;



public class BoardProc {
	private static final int boardNo = 0;
	private static final int orgNo = 0;
	Scanner sc = new Scanner(System.in);
	BoardService service = new BoardServiceImpl();

	public void execute() {

		while (true) {
			int menu = 0;
			System.out.println("1.사원등록 | 2.전체 조회 | 3. 사원 조회  | 4.퇴사처리 | 9.종료");
			menu = sc.nextInt();
			if (menu == 1) {
				writeBoard(); 	// 사원등록
			} else if (menu == 2) {
				getBoardList();	// 전체 조회
			} else if (menu == 3) {
				getBoard();// 사원 조회
			} else if (menu == 4) {
				updateBoard();// 수정 
			} else if (menu == 5) {
				deleteBoard();// 퇴사처리 
			} else if (menu == 9) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}

		}
	}

	public void updateBoard() {
		while (true) {
			BoardDB board = new BoardDB();
			System.out.println("수정할 사원 번호 : ");
			int boardNo = sc.nextInt();
			sc.nextLine();
			BoardDB bd = service.getBoard(boardNo);

			if (bd == null) {
				System.out.println("없는 사원번호 입니다.");
				return;
			} else {
				service.updateBoard(board);
				System.out.println("수정되었습니다.");
				
			} return;
				
			
			System.out.println("사원명 변경");
			String name = sc.nextLine();
			System.out.println("부서 변경");
			String job_id = sc.nextLine();

			board.setName(name);
			board.setJob_id(job_id);
	
		}
	}

	public void getBoard() {
		System.out.println("조회할 글번호:");
		int boardNo = sc.nextInt();
		sc.nextLine();
		// 원본글
		BoardDB board = service.getBoard(boardNo);
		if (board != null) {
			System.out.println("---------[사원]------------");
			System.out.println("사원번호 : " + board.getBoardNo());
			System.out.println("이름 : " + board.getName());
			System.out.println("부서: " + board.getJob_id());
			System.out.println("급여: " + board.getSalary());
			System.out.println("입사일: " + board.getCreationDate());
			
		
	}

	public void writeBoard() {// 사원 등록

		System.out.println("사원 번호를 입력하세요.");
		int board_no = sc.nextInt();
		System.out.println("사원명을 입력하세요.");
		String name = sc.nextLine();
		System.out.println("부서명을 입력하세요.");
		String job_id = sc.nextLine();
		System.out.println("급여를 입력하세요.");
		int salary = sc.nextInt();
		System.out.println("입사일을 입력하세요");
		String creation_date = sc.nextLine();

		// 입력받은 값을 board 인스턴스에 담는다.
		BoardDB board = new BoardDB();
		board.setName(name);
		board.setJob_id(job_id);
		board.setSalary(salary);
		service.insertBoard(board);
	}

	public void getBoardList() {// 전체 조회
		System.out.println("전체글 조회");
		List<BoardDB> boards = service.getBoardList();
		for (BoardDB board : boards) {
			System.out.println(board);
		}
	}

	public void deleteBoard() {// 1건씩 삭제
		System.out.println("삭제할 글번호: ");
		int dbNo = sc.nextInt();
		sc.nextLine();

		BoardDB board = service.getBoard(dbNo);

		if (board == null) {
			System.out.println("없는 게시판");
		} else if (loginId.equals(board.getWriter())) {
			service.deleteBoard(board);
			System.out.println("게시글이 삭제되었습니다.");
		} else {
			System.out.println("권한이 없습니다.");
		}

	}

	public void delBoard() {// 원본글이나 댓글까지 일괄 삭제 ex) 원본글에 댓글이 있을 경우 댓글까지 삭제
		BoardDB board = new BoardDB();
		System.out.println("삭제할 글번호: ");
		int dbNo = sc.nextInt();
		sc.nextLine();
		board.setBoardNo(dbNo);
//		board.setOrigNo(board.getBoardNo());
		board.setOrigNo(dbNo);

		BoardDB bd = service.getBoard(dbNo);

		if (bd == null) {
			System.out.println("없는 게시글입니다.");
		} else if (loginId.equals(bd.getWriter())) {
			service.delBoard(board);
			System.out.println("게시글이 삭제되었습니다.");
		} else {
			System.out.println("권한이 없습니다.");
		}
	}


}
