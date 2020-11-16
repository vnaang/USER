package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable () {
        try {
            Session session = Util.getSessionFactory().openSession();
            Query query = session.createSQLQuery("CREATE TABLE IF NOT EXISTS users( ID INT NOT NULL AUTO_INCREMENT,name VARCHAR(50), lastName VARCHAR(50), age INT, PRIMARY KEY(ID))");
            query.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void dropUsersTable() {
        Session session = Util.getSessionFactory().openSession();
        Query query = session.createSQLQuery("DROP TABLE IF EXISTS users");
        query.executeUpdate();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {

        Session session = Util.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        User user = new User(name, lastName, age);
        session.save(user);
        tx1.commit();
        session.close();
    }

    @Override
    public void removeUserById(long id) {
        Session session = Util.getSessionFactory().openSession();
        Query query = session.createSQLQuery("DELETE FROM users WHERE '"+ id +"'");
        query.executeUpdate();
    }

    @Override
    public List<User> getAllUsers() {
        Session session = Util.getSessionFactory().openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        List<User> userList = session.createQuery("FROM User").list();
        transaction.commit();
        session.close();
        return userList;
    }

    @Override
    public void cleanUsersTable() {
        Session session = Util.getSessionFactory().openSession();
        Query query = session.createSQLQuery("TRUNCATE TABLE users");
        query.executeUpdate();
    }
}
