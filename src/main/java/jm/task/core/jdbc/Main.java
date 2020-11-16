package jm.task.core.jdbc;


import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();

        String testName = "Ivan";
        String testLastName = "Ivanov";
        byte testAge = 5;

        String nameNick = "Nick";
        String lastNameNick = "Natch";
        byte ageNick = 30;

        String nameJulian = "Julian";
        String lastNameJulian = "Basiski";
        byte ageJulian = 15;

        String nameElsa = "Elsa";
        String lastNameElsa = "Grgoryan";
        byte ageElsa = 45;



        userService.createUsersTable();
        userService.saveUser(testName, testLastName, testAge);
        userService.saveUser(nameNick, lastNameNick, ageNick);
        userService.saveUser(nameJulian, lastNameJulian, ageJulian);
        userService.saveUser(nameElsa, lastNameElsa, ageElsa);
        System.out.println(userService.getAllUsers());
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
