package com.cruiseline.cruiseline.dao;

import com.cruiseline.cruiseline.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoleDAO extends JpaRepository<Role, Long> {

    @Modifying
    @Query(value = "UPDATE roles role SET role.name = :name WHERE role.id = :id;", nativeQuery = true)
    void updateRoleById(@Param("id") Long id, @Param("name") String name);
}
