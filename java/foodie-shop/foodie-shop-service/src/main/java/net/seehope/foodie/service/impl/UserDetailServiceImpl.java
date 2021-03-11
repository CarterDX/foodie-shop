package net.seehope.foodie.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;

import net.seehope.foodie.exception.PassportException;
import net.seehope.foodie.mapper.UsersMapper;
import net.seehope.foodie.pojo.Users;
import net.seehope.foodie.properties.ProjectConstant;
import net.seehope.foodie.properties.ProjectProperties;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private UsersMapper usersMapper;

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private ProjectProperties properties;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		String action = request.getRequestURI();
		System.out.println(action);

		if (StringUtils.equals(action, properties.getBrowser().getLoginProcessingUrl())) {
			System.out.println(action);
			Users users = new Users();
			users.setUsername(username);

			Users loginUser = usersMapper.selectOne(users);

			if (loginUser == null) {
				throw new PassportException("用户名或者密码不匹配");
			}

			User user = new User(loginUser.getUsername(), loginUser.getPassword(), true, true, true, true,
					AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER,ROLE_ADMIN"));

			return user;
		} else if (StringUtils.equals(action, ProjectConstant.MOBILE_AUTHENTICATION_URL)) {

			Users users = new Users();
			try {
				users.setMobile(ServletRequestUtils.getStringParameter(request, "mobile"));

				Users loginUser = usersMapper.selectOne(users);

				if (loginUser == null) {
					throw new PassportException("用户名或者密码不匹配");
				}

				User user = new User(loginUser.getUsername(), loginUser.getPassword(), true, true, true, true,
						AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER,ROLE_ADMIN"));

				return user;
			} catch (ServletRequestBindingException e) {
				e.printStackTrace();
			}
		} else {
			return null;
		}
		return null;

	}

}
