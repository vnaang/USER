package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl extends Util implements UserDao {

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try (Connection connection = getConnection()){
            String SQL = "CREATE TABLE users(name VARCHAR(50), lastName VARCHAR(50), age INT)";
            Statement statement = connection.createStatement();
            statement.execute(SQL);
        }catch (SQLException e){
            //
        }
    }

    public void dropUsersTable() {
        try(Connection connection = getConnection()){
            String SQL = "DROP TABLE IF EXISTS users";
            Statement statement = connection.createStatement();
            statement.execute(SQL);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        PreparedStatement preparedStatement;
        String SQL = "INSERT INTO users(name, lastName, age) VALUES(?,?,?)";
        try(Connection connection = getConnection()){
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1 ,name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3,age);

            preparedStatement.executeUpdate();
            System.out.println("User с именем – name добавлен в базу данных");
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        try (Connection connection = getConnection()){
            String SQL = "DELETE FROM name = ? WHERE id ='"+ id +"' ";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List <User> userList = new ArrayList<>();

        String SQL = "SELECT  NAME, LASTNAME, AGE from users";
        try(Connection connection = getConnection()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL);
            while(resultSet.next()){
                User user = new User();
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));

                userList.add(user);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return userList;
    }

    public void cleanUsersTable() {
        try(Connection connection = getConnection()){
            String SQL = "TRUNCATE TABLE  users";
            Statement statement = connection.createStatement();
            statement.execute(SQL);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
