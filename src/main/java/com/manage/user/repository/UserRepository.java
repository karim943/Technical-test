package com.manage.user.repository;


import com.manage.user.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * @param username
     * @return boolean, checks if user username already exists
     */
    boolean existsByUsername(String username);
}
