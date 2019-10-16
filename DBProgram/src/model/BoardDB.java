package model;

public class BoardDB {
	private int boardNo;//사번으로씀
	private String name;//이름
	private String job_id;//부서
	private int salary;//급여
	private String creationDate;//입사일
	private int origNo;// 0 이면 사원 1이면 퇴사자
	
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob_id() {
		return job_id;
	}
	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	@Override
	public String toString() {
		return "BoardDB [boardNo=" + boardNo + ", name=" + name + ", job_id=" + job_id + ", salary=" + salary
				+ ", creationDate=" + creationDate + ", origNo=" + origNo + "]";
	}
	
}
