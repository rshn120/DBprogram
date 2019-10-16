package com.board.test;

import java.util.List;

public interface EmpService {

   public void insertEmp(Emp emp);

   public Emp getEmp(String employeeName); // 직원 이름 조회

   public List<Emp> getDepList(String departId); // 부서별 조회

   public List<Emp> getEmpallList(); // 직원 전체 조회

   public void updateEmp(Emp emp); // 직원 부서 변경

   public void deleteEmp(Emp emp); // 직원 삭제
}