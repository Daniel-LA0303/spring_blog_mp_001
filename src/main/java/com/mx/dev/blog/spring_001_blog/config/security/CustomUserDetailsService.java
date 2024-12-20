package com.mx.dev.blog.spring_001_blog.config.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mx.dev.blog.spring_001_blog.entities.user.RoleEntity;
import com.mx.dev.blog.spring_001_blog.entities.user.UserEntity;
import com.mx.dev.blog.spring_001_blog.services.UserService;
import com.mx.dev.blog.spring_001_blog.utils.exceptions.ServiceException;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	private final UserService userService;

	public CustomUserDetailsService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity;
		try {
			userEntity = userService.getOneUserByUsernameOrThrow(username);
		} catch (ServiceException e) {
			throw new UsernameNotFoundException("User not found with username: " + username, e);
		}

		if (userEntity == null || userEntity.getRoles() == null) {
			throw new UsernameNotFoundException("User or roles not found for username: " + username);
		}

		return new User(userEntity.getUsername(), userEntity.getPassword(), getAuthorities(userEntity.getRoles()));
	}

	private Collection<? extends GrantedAuthority> getAuthorities(Set<RoleEntity> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
	}

}
