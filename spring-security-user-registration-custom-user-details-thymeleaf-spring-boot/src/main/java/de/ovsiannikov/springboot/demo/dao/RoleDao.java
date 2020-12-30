package de.ovsiannikov.springboot.demo.dao;


import de.ovsiannikov.springboot.demo.entity.Role;

public interface RoleDao {

	Role findRoleByName(String theRoleName);

}
