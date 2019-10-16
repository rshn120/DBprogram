package com.board.test;

import java.util.List;

import com.board.test.Emp;
import com.board.test.EmpService;

public class EmpServiceImpl implements EmpService {
   EmpDAO dao = new EmpDAO();

   @Override
   public void insertEmp(Emp emp) {
      dao.insertEmp(emp);
   }

   @Override
   public Emp getEmp(String empName) {
      Emp emp = dao.getEmp(empName);
      return emp;
   }

   @Override
   public List<Emp> getDepList(String departId) {
      return dao.getDepList(departId);
   }

   @Override
   public void deleteEmp(Emp emp) {
      dao.deleteEmp(emp);
   }

   @Override
   public void updateEmp(Emp emp) {
      dao.updateEmp(emp);
   }

   @Override
   public List<Emp> getEmpallList() {
      List<Emp> list = dao.getEmpallList();
      return list;
   }

}