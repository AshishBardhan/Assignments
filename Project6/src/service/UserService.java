package service;

import dao.IItemDAO;
import dao.IUserDAO;
import dao.ItemDAO;
import dao.UserDAO;
import domain.Item;
import domain.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Ashish Bardhan
 * Date: 6/27/13
 * Time: 1:46 PM
 * To change this template use File | Settings | File Templates.
 */

public class UserService implements IUserService {
    private IUserDAO userDAO = new UserDAO();

    public List<User> getUserList(String username,String password){
        return userDAO.getUserList(username, password);
    }
}