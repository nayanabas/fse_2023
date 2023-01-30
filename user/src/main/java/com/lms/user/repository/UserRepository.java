package com.lms.user.repository;

import com.lms.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
public interface UserRepository extends JpaRepository<User, String> {

    public Optional<User> findByUserNameAndPassword(String username, String password);

    Optional<User> findByUserName(String userName);
}
