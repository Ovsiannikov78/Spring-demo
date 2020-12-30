package de.ovsiannikov.springboot.demo.service;

import de.ovsiannikov.springboot.demo.entity.User;
import de.ovsiannikov.springboot.demo.user.CrmUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

	User findByUserName(String userName);

	void save(CrmUser crmUser);
}
