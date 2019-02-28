package com.zx.mapper;


import com.zx.model.User;

import java.util.List;

public interface UserMapper {

	List<User> getAll();

	User getOne(Long id);

	void insert(User user);

	int update(User user);

	int delete(Long id);
}