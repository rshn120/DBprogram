package com.board.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO {
   Connection conn = null;
   ResultSet rs = null;
   PreparedStatement pstmt = null;

   public void insertEmp(Emp emp) {
      conn = common.DAO.getConnect();
      String sql = "insert into employee values(emp_seq.nextval, ?, ?, ?, ?)";

      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, emp.getName());
         pstmt.setString(2, emp.getDepartments());
         pstmt.setInt(3, emp.getSalary());
         pstmt.setString(4, emp.getHireDate());
         int r = pstmt.executeUpdate();
         System.out.println(r + "건이 입력되었습니다.");
      } catch (SQLException e) {
         // TODO 자동 생성된 catch 블록
         e.printStackTrace();
      } finally {
         try {
            conn.close();
         } catch (SQLException e) {
            // TODO 자동 생성된 catch 블록
            e.printStackTrace();
         }
      }

   }

   public Emp getEmp(String emp) {
      conn = common.DAO.getConnect();
      String sql = "select * from employee where EMPLOYEE_NAME = ?";
      Emp employee = null;
      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, emp);
         rs = pstmt.executeQuery();
         
         if(rs.next()) {
            employee = new Emp();
            employee.setEmpNumber(rs.getInt("employee_number"));
            employee.setName(rs.getString("employee_name"));
            employee.setDepartments(rs.getString("departments"));
            employee.setSalary(rs.getInt("salary"));
            employee.setHireDate(rs.getString("hire_date"));
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
      return employee;
   }
   
   public List<Emp> getDepList(String departId) {
      conn = common.DAO.getConnect();
      String sql = "select * from employee where departments = ?";
      List<Emp> list = new ArrayList<>();
      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, departId);
         rs = pstmt.executeQuery();
         
         while (rs.next()) {
            Emp employee = new Emp();
            employee.setEmpNumber(rs.getInt("employee_number"));
            employee.setName(rs.getString("employee_name"));
            employee.setDepartments(rs.getString("departments"));
            employee.setSalary(rs.getInt("salary"));
            employee.setHireDate(rs.getString("hire_date"));
            list.add(employee);
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
   
   public List<Emp> getEmpallList() {
      List<Emp> list = new ArrayList<>();
      conn = common.DAO.getConnect();
      String sql = "select * from employee";
      Emp emp = null;
      try {
         pstmt = conn.prepareStatement(sql);
         rs = pstmt.executeQuery();
         
         while (rs.next()) {
            emp = new Emp();
            emp.setEmpNumber(rs.getInt("employee_number"));
            emp.setName(rs.getString("employee_name"));
            emp.setDepartments(rs.getString("departments"));
            emp.setSalary(rs.getInt("salary"));
            emp.setHireDate(rs.getString("hire_date"));
            list.add(emp);
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
   
   public void updateEmp(Emp emp) {
      conn = common.DAO.getConnect();
      String sql = "update employee set departments = ? where employee_name = ?";
      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, emp.getDepartments());
         pstmt.setString(2, emp.getName());
         int rs = pstmt.executeUpdate();
         System.out.println(rs + "건이 수정 되었습니다.");
      } catch (SQLException e) {
         e.printStackTrace();
      }finally {
         try {
            conn.close();
         } catch (SQLException e) {
            e.printStackTrace();
         }
         
      }
      
   }
   
   public void deleteEmp(Emp emp) {
      conn = common.DAO.getConnect();
      String sql = "delete from employee where employee_number = ?";
      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setInt(1, emp.getEmpNumber());
         int rs = pstmt.executeUpdate();
         System.out.println(rs + "건이 삭제 되었습니다.");
      } catch (SQLException e) {
      
         e.printStackTrace();
      }finally {
         try {
            conn.close();
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }
   }
}