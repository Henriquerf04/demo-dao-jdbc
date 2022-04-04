package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== TEST 1: seller findById ====");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);
        System.out.println("-------------------------------");

        System.out.println("=== TEST 2: seller findByDepartment ====");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj : list) {
            System.out.println(obj);
        }
        System.out.println("-------------------------------");

        System.out.println("=== TEST 3: seller findAll ====");
        list = sellerDao.findAll();
        for (Seller obj : list) {
            System.out.println(obj);
        }
        System.out.println("-------------------------------");

        System.out.println("=== TEST 4: seller insert ====");
        Seller newSeller = new Seller(null, "Coronel Mostarda", "mustard@gmail.com", new Date(), 25000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id = " + newSeller.getId());
        System.out.println("-------------------------------");

        System.out.println("=== TEST 5: seller update ====");
        Seller sellerToUpdate = sellerDao.findById(8);
        sellerToUpdate.setName("Johnny Deep");
        sellerToUpdate.setEmail("johnny@gmail.com");
        sellerToUpdate.setBirthDate(new Date());
        sellerToUpdate.setBaseSalary(125000.75);
        sellerToUpdate.setDepartment(department);      
        sellerDao.update(sellerToUpdate);
        System.out.println("Update completed");
        System.out.println("-------------------------------");

        System.out.println("=== TEST 6: seller delete ====");   
        System.out.print("Enter id for delete test: ");  
        int id = sc.nextInt();    
        sellerDao.deleteById(id);
        System.out.println("Deleted!");

        sc.close();
    }
}
