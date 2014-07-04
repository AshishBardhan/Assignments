package dao;

import domain.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Ashish Bardhan
 * Date: 6/27/13
 * Time: 12:37 PM
 * To change this template use File | Settings | File Templates.
 */
public interface IUserDAO {
    public List<User> getUserList(String username,String password);
}
