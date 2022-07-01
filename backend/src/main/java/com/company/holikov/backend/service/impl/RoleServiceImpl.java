package com.company.holikov.backend.service.impl;

import com.company.holikov.backend.model.Role;
import com.company.holikov.backend.repository.RoleRepository;
import com.company.holikov.backend.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public void create(Role role) {
        roleRepository.save(role);
    }

    @Override
    public void update(Role role) {
        Role role1 = new Role(role.getId(), role.getName());
        roleRepository.save(role1);
    }

    @Override
    public void remove(Role role) {
        roleRepository.delete(role);
    }

    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }
}
