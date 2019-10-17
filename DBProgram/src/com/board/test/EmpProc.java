package com.board.test;

import java.util.List;
import java.util.Scanner;

import com.board.test.EmpService;
import com.board.test.EmpServiceImpl;

import com.board.test.Emp;

public class EmpProc {
   Scanner sc = new Scanner(System.in);
   EmpService service = new EmpServiceImpl();

   public void execute() {

      while (true) {
         int menu = 0;
         System.out.println("1, 사원등록 | 2, 사원이름조회 | 3, 부서별 조회 | 4. 부서변경 | 5, 퇴사처리 | 9, 종료");
         menu = sc.nextInt();
         sc.nextLine();
         if (menu == 1) {
            writeEmp();
         } else if (menu == 2) {
            getEmp();
         } else if (menu == 3) {
            getDepList();
         } else if (menu == 4) {
            updateEmp();
         } else if (menu == 5) {
            deleteEmp();
         } else if (menu == 9) {
            System.out.println("종료");
            break;
         }
      }
   }

   public void updateEmp() {//부서 수정
      System.out.println("부서를 수정 할 사원의 이름을 입력하세요 : ");
      String EmpName = sc.nextLine();
      System.out.println("수정할 부서의 이름을 적어주세요 : ");
      String departments = sc.nextLine();
      Emp emp = new Emp();
      emp.setName(EmpName);
      emp.setDepartments(departments);
      service.updateEmp(emp);

   }

   public void getDepList() {//부서별 조회
      System.out.println("1, 부서검색 | 2, 전체검색");
      int submenu = 0;
      submenu = sc.nextInt();
      sc.nextLine();
      if (submenu == 1) {
         System.out.println("검색할 부서 이름 : ");
         String depId = sc.nextLine();
         List<Emp> list = service.getDepList(depId);
            for(Emp employees : list) {
               System.out.println(employees);  
            }
      } else if (submenu == 2) {
         List<Emp> employee = service.getEmpallList();
         for (Emp employees : employee) {
            System.out.println(employees);
         }
      }
   }

   public void getEmp() {//사원이름조회
      System.out.println("조회할 사원 이름");
      String empName = sc.nextLine();
      Emp emp = service.getEmp(empName);
      System.out.println(emp);
   }

   public void writeEmp() {//사원 등록

      System.out.println("사원 이름 입력");
      String empName = sc.nextLine();
      System.out.println("부서 이름 입력");
      String empDep = sc.nextLine();
      System.out.println("급여 입력");
      int empsalary = sc.nextInt();
      sc.nextLine();
      System.out.println("입사일 입력");
      String hireDate = sc.nextLine();

      Emp emp = new Emp();
      emp.setName(empName);
      emp.setDepartments(empDep);
      emp.setSalary(empsalary);
      emp.setHireDate(hireDate);
      service.insertEmp(emp);

   }
   
   public void deleteEmp() {//삭제
      System.out.println("어떤 사원을 삭제 할까요?");
      int empNo = sc.nextInt();
      Emp emp = new Emp();
      emp.setEmpNumber(empNo);
      service.deleteEmp(emp);
   }

}