package user.service;

import common.DbConnection;
import user.model.User;
import user.model.dao.UserDao;

public class UserService {
    private UserDao userDao;

    public UserService() {
        this.userDao = new UserDao(DbConnection.getConnection());
    }

    public void signup(User user) {

        String originPassword = user.getPassword();

        user.setPassword("암호화됨" + originPassword);

        userDao.insertUser(user);
    }

    public int login(User user) {
        String originPassword = user.getPassword();

        user.setPassword("암호화됨" + originPassword);

        int userIdx = userDao.login(user);

        return userIdx;
    }

    public User getProfile(String userName) {
        User user = userDao.selectUser(userName);
        return user;
    }
}












