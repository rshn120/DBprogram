package com.board.test;

public class Emp {
   private int empNumber; //사원 번호
   private String name; //사원 이름
   private String departments; //부서 이름
   private int salary; // 연봉
   private String hireDate; //입사일 

   public int getEmpNumber() {
      return empNumber;
   }

   public void setEmpNumber(int empNumber) {
      this.empNumber = empNumber;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getDepartments() {
      return departments;
   }

   public void setDepartments(String departments) {
      this.departments = departments;
   }

   public int getSalary() {
      return salary;
   }

   public void setSalary(int salary) {
      this.salary = salary;
   }

   public String getHireDate() {
      return hireDate;
   }

   public void setHireDate(String hireDate) {
      this.hireDate = hireDate;
   }

   @Override
   public String toString() {
      return "Emp [empNumber=" + empNumber + ", name=" + name + ", departments=" + departments + ", salary=" + salary
            + ", hireDate=" + hireDate + "]";
   }
   
}