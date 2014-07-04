package dao;

import domain.User;
import org.hibernate.Query;
import org.hibernate.Session;
import utils.HibernateUtils;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Ashish Bardhan
 * Date: 6/27/13
 * Time: 12:36 PM
 * To change this template use File | Settings | File Templates.
 */

public class UserDAO implements IUserDAO {

    Session session= HibernateUtils.getSessionFactory().openSession();

    public List<User> getUserList(String usrn, String pswd)
    {
        Query query=session.createQuery("select user from User user where username = :usrn and password = :pswd");
        query.setParameter("usrn",usrn);
        query.setParameter("pswd",pswd);
        List<User> userList=(List<User>) query.list();
        return userList;
    }
}
