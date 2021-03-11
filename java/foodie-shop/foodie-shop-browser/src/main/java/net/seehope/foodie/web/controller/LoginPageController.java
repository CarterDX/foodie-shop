package net.seehope.foodie.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import net.seehope.foodie.common.JsonResult;
import net.seehope.foodie.properties.ProjectConstant;
import net.seehope.foodie.properties.ProjectProperties;

/**
 * 用来分辨用户在没有权限访问的时候第一个访问的路径是静态资源还是动态资源 如果是动态资源，那么返回json 如果是静态资源，那么页面转发
 * 
 * @author Monty
 *
 */
@Controller
public class LoginPageController {

	private static final Logger log = LoggerFactory.getLogger(LoginPageController.class);

	@Autowired
	private ProjectProperties properties;

	private RequestCache requestCache = new HttpSessionRequestCache();

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@ResponseBody
	@RequestMapping(value = ProjectConstant.LOGIN_PAGE)
	@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
	public JsonResult requireAuthentication(HttpServletRequest request, HttpServletResponse resp) throws IOException {

		SavedRequest savedRequest = requestCache.getRequest(request, resp);

		if (savedRequest != null) {
			String target = savedRequest.getRedirectUrl();
			log.info("用户在没有权限的情况下访问了{}地址", target);
			if (StringUtils.endsWithIgnoreCase(target, ".html")) {
				redirectStrategy.sendRedirect(request, resp, properties.getBrowser().getLoginPage());
			}
		}

		return JsonResult.errorAuthorized("用户没有权限访问当前接口");
	}
}
