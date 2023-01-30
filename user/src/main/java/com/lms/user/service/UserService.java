package com.lms.user.service;

import com.lms.user.entity.User;
import com.lms.user.excption.InvalidUserCredentialException;
import com.lms.user.excption.UserAlreadyExistsException;
import com.lms.user.excption.UserNotFoundException;

public interface UserService {

    public User getUserById(String id) throws UserNotFoundException;

    public User registerUser(User user) throws UserAlreadyExistsException;

    public boolean validateUser(String userName, String password) throws InvalidUserCredentialException;
}
