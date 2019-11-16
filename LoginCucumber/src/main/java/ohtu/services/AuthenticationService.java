package ohtu.services;

import ohtu.domain.User;
import java.util.ArrayList;
import java.util.List;
import ohtu.data_access.UserDao;
import java.lang.Character;

public class AuthenticationService {

    private final UserDao userDao;

    public AuthenticationService(final UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean logIn(final String username, final String password) {
        for (final User user : userDao.listAll()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public boolean createUser(final String username, final String password) {
        if (userDao.findByName(username) != null) {
            return false;
        }

        if (invalid(username, password)) {
            return false;
        }

        userDao.add(new User(username, password));

        return true;
    }

    private boolean invalid(final String username, final String password) {
        if (username.length()<3){
            return true;
        }
        if (password.length()<8){
            return true;
        }
        boolean invalid = true;
        for (char ch:password.toLowerCase().toCharArray()){
            int charType = Character.getType(ch);
            if (charType != Character.LOWERCASE_LETTER && charType != Character.UPPERCASE_LETTER){
                invalid = false;
                continue;
            }
        };

        return invalid;
    }
}
