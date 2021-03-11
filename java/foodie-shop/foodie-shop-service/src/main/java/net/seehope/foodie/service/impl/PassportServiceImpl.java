package net.seehope.foodie.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.seehope.foodie.exception.PassportException;
import net.seehope.foodie.mapper.UsersMapper;
import net.seehope.foodie.pojo.Users;
import net.seehope.foodie.pojo.bo.UsersBo;
import net.seehope.foodie.properties.ProjectProperties;
import net.seehope.foodie.service.PassportService;

@Service
public class PassportServiceImpl implements PassportService {

	@Autowired
	private UsersMapper usersMapper;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private Sid sid;

	@Autowired
	private ProjectProperties properties;

	@Override
	public void usernameIsExist(String username) {
		Users user = new Users();
		user.setUsername(username);
		List<Users> users = usersMapper.select(user);

		if (users.size() != 0) {
			throw new PassportException("用户名:" + username + "已经存在，请重新输入");
		}

	}

	@Transactional
	@Override
	public void regist(UsersBo bo) {

		usernameIsExist(bo.getUsername());

		if (!StringUtils.equals(bo.getPassword(), bo.getConfirmPassword())) {
			throw new PassportException("用户两次输入密码不一致，请重新输入");
		}

		Users users = new Users();
		users.setNickname("匿名");
		users.setId(sid.nextShort());
		users.setUsername(bo.getUsername());
		users.setPassword(passwordEncoder.encode(bo.getPassword()));
		users.setFace(properties.getUserDefaultFace());
		users.setSex(0);
		users.setCreatedTime(new Date());
		users.setUpdatedTime(new Date());

		usersMapper.insert(users);

	}

	@Override
	public Users login(UsersBo bo) {
		Users users = new Users();
		users.setUsername(bo.getUsername());
		Users loginUsers = users = usersMapper.selectOne(users);

		if (loginUsers == null) {
			throw new PassportException("用户或者密码错误");
		}

		if (!passwordEncoder.matches(bo.getPassword(), loginUsers.getPassword())) {
			throw new PassportException("用户或者密码错误");
		}

		return loginUsers;
	}

}
