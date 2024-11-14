package com.cruiseline.cruiseline.service;

import com.cruiseline.cruiseline.entity.Role;
import com.cruiseline.cruiseline.exception.NoSuchRoleExistsException;

import java.util.List;

public interface RoleService {
    void addRole(Role role);

    void updateRoleById(Long id, String name);

    void removeRoleById(Long id);

    void removeRole(Role role);

    Role getRoleById(Long id) throws NoSuchRoleExistsException;

    List<Role> getAllRoles();
}
