package com.cruiseline.cruiseline.dao;

import com.cruiseline.cruiseline.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserDAO extends JpaRepository<User, Long> {

    @Modifying
    @Query(value = "UPDATE users user SET user.role_id = :role_id, user.name = :name, user.surname = :surname, user.email = :email, user.password = :password WHERE user.id = :id;", nativeQuery = true)
    void updateUserById(@Param("id") Long id, @Param("role_id") Long roleId, @Param("name") String name, @Param("surname") String surname, @Param("email") String email, @Param("password") String password);
}
