package net.seehope.foodie.service;

import net.seehope.foodie.pojo.Users;
import net.seehope.foodie.pojo.bo.UsersBo;

public interface PassportService {
	void usernameIsExist(String username);

	void regist(UsersBo bo);

	Users login(UsersBo bo);
}
