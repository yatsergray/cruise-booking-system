package com.cruiseline.cruiseline.service.impl;

import com.cruiseline.cruiseline.dao.RoleDAO;
import com.cruiseline.cruiseline.entity.Role;
import com.cruiseline.cruiseline.exception.NoSuchRoleExistsException;
import com.cruiseline.cruiseline.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDAO roleDAO;

    @Override
    public void addRole(Role role) {
        roleDAO.save(role);
    }

    @Override
    public void updateRoleById(Long id, String name) {
        roleDAO.updateRoleById(id, name);
    }

    @Override
    public void removeRole(Role role) {
        roleDAO.delete(role);
    }

    @Override
    public void removeRoleById(Long id) {
        roleDAO.deleteById(id);
    }

    @Override
    public Role getRoleById(Long id) throws NoSuchRoleExistsException {
        return Optional.of(roleDAO.getById(id)).orElseThrow(() -> new NoSuchRoleExistsException("Role with id " + id + " doesn't exist."));
    }

    @Override
    public List<Role> getAllRoles() {
        return roleDAO.findAll();
    }
}
