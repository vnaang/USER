package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
         UserService userService = new UserServiceImpl();

         String testName = "Ivan";
         String testLastName = "Ivanov";
         byte testAge = 5;

         userService.createUsersTable();
         userService.saveUser(testName, testLastName, testAge);
         System.out.println(userService.getAllUsers());
         userService.cleanUsersTable();
         userService.dropUsersTable();
    }
}
