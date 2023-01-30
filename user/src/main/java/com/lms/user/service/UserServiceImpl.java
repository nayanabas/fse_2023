package com.lms.user.service;

import com.lms.user.entity.User;
import com.lms.user.excption.InvalidUserCredentialException;
import com.lms.user.excption.UserAlreadyExistsException;
import com.lms.user.excption.UserNotFoundException;
import com.lms.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public User getUserById(String id) throws UserNotFoundException {
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public User registerUser(User user) throws UserAlreadyExistsException {
        Optional<User> useropt =userRepository.findByUserName(user.getUserName());
        if(useropt.isPresent()){
            throw new UserAlreadyExistsException();
        }

        return userRepository.save(user);
    }

    @Override
    public boolean validateUser(String userName, String password) throws InvalidUserCredentialException {
        if(userName!=null && !userName.isEmpty() && password!=null && !password.isEmpty()){
            Optional<User> user = userRepository.findByUserNameAndPassword(userName, password);

            if(user.isPresent()){
                return  true;
            }else{
                  throw new InvalidUserCredentialException();
            }

        }
        return false;

    }
}
