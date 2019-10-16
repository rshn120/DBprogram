package impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.DAO;
import model.BoardDB;


public class BoardDAO {
	
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String name = null;
		
		public void insertBoard(BoardDB board) {//회원 등록
			conn = DAO.getConnect();
			String sql = "insert into cboards values((select max(board_no)+1 from boards) ,?,?,?,sysdate,null)";  //cboard_seq.nextval
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, board.getName());
				pstmt.setString(2, board.getJob_id());
				pstmt.setString(3, board.getSalary());
				pstmt.setString(3, board.getCreationDate());
				
				int r = pstmt.executeUpdate();
				System.out.println(r + "건이 입력되었습니다.");
			} catch (SQLException e) {
				e.printStackTrace();

			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}


		
		public List<BoardDB> getBoardList(){ //전체 조회 퇴사자 포함
			List<BoardDB> list = new ArrayList<>();
			conn = DAO.getConnect(); 
			String sql="select * from cboards order by 1 desc";
			BoardDB bd = null;
			try {
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					bd = new BoardDB();
					bd.setBoardNo(rs.getInt("board_no"));//사원아이디로 씀
					bd.setName(rs.getString("name"));
					bd.setJob_id(rs.getString("job_id"));
					bd.setSalary(rs.getString("salary"));
					bd.setCreationDate(rs.getString("creation_date"));
//					bd.setOrigNo(rs.getInt("orig_no")); // 1 일경우 퇴사로 처리 할 예정
					list.add(bd);
									
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			}
			return list;
			
		}
		public BoardDB getBoard(int boardNo) { //전체 사원 조회
			BoardDB board = null;
			conn = DAO.getConnect();
			String sql = "select * from boards where board_no = ? and orig_no is null";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, boardNo);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					board = new BoardDB();
					board.setBoardNo(rs.getInt("board_no"));//사원아이디로 씀
					board.setName(rs.getString("name"));
					board.setJob_id(rs.getString("job_id"));
					board.setSalary(rs.getInt("salary"));
					board.setCreationDate(rs.getString("creation_date"));
					                          
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return board;
			
		}
		public void updateBoard(BoardDB board) {
			
			conn = DAO.getConnect();
			System.out.println("사원명 : "+ board.getName());
			String sql = "update cboards set orig_no = orig_no, title= ?, content= ?"
						 +" where board_no = ? and orig_no is null";
			int n = 0;	
			try {
				pstmt = conn.prepareStatement(sql);
				if(board.get != null && !board.getTitle().equals("")) {
				pstmt.setString(++n, board.getTitle());
				}
				if(board.getContent() != null && !board.getContent().equals("")) {
				pstmt.setString(++n, board.getContent());
				}
				pstmt.setInt(++n, board.getBoardNo());
				pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					conn.prepareStatement(sql);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
						
		public void deleteBoard(BoardDB board) {//퇴사 처리 
		    conn = DAO.getConnect();
		    String sql = "update from cboards where board_no = ?";
		    try {
		       pstmt = conn.prepareStatement(sql);
		       pstmt.setInt(1, board.getBoardNo());
		       pstmt.executeUpdate();
		    } catch (SQLException e) {
		       e.printStackTrace();
		    } finally {
		       try {
		          conn.close();
		       } catch (SQLException e) {
		          e.printStackTrace();
		       }
		    }
		}
		
		
	}
