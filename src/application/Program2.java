package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== TEST 1: department findById ====");
        Department department = departmentDao.findById(3);
        System.out.println(department);
        System.out.println("-------------------------------");

        System.out.println("=== TEST 2: department findAll ====");
        List<Department> list = departmentDao.findAll();
        for (Department d : list) {
            System.out.println(d);
        }
        System.out.println("-------------------------------");

        System.out.println("=== TEST 3: department insert ====");
        Department newDepartment = new Department(null, "Furniture");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! New id = " + newDepartment.getId());
        System.out.println("-------------------------------");

        System.out.println("=== TEST 4: department update ====");
        Department departmentToUpdate = departmentDao.findById(6);
        departmentToUpdate.setName("Drugs");            
        departmentDao.update(departmentToUpdate);
        System.out.println("Update completed");
        System.out.println("-------------------------------");

        System.out.println("=== TEST 5: department delete ====");   
        System.out.print("Enter id for delete test: ");  
        int id = sc.nextInt();    
        departmentDao.deleteById(id);
        System.out.println("Deleted!");

        sc.close();
    }
}
