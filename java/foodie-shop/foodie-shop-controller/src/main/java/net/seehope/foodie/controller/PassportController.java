package net.seehope.foodie.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.Api;
import net.seehope.foodie.common.JsonResult;
import net.seehope.foodie.pojo.bo.UsersBo;
import net.seehope.foodie.service.PassportService;
import net.seehope.foodie.util.CookieUtils;
import springfox.documentation.spring.web.json.Json;

@Api("passport 和通行证（账号） 相关所有请求的控制器")
@RestController
@RequestMapping("/passport")
public class PassportController {

	@Autowired
	private HttpServletRequest request;
	@Autowired
	private HttpServletResponse response;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private PassportService passportService;

	@GetMapping("/usernameIsExist")
	public JsonResult usernameIsExist(String username) {

		passportService.usernameIsExist(username);

		return JsonResult.isOk(null);
	}

	/* 
	 * @Valid:进行验证
	 */
	
	@PostMapping("/regist")
	public JsonResult regist(@Valid @RequestBody UsersBo bo) {

		passportService.regist(bo);

		return JsonResult.isOk(null);
	}

	@PostMapping("/login")
	public JsonResult login(@Valid @RequestBody UsersBo bo) throws JsonProcessingException {
		// TODO 目前在单体架构中，使用COOKIE去保持用户的登录状态在之后服务演进的过程中存储逻辑会修改

		/**
		 * 自动判断request的域名并设置domain 同时设置path为/ 也就是request域名下所有网址该cookie都有效 604800 有效期
		 * true 是否编码，cookie 当成json传到前端的时候需要编码，因为不能有空格，双引号之类的字符串，所以要URLENCODE
		 */
		CookieUtils.setCookie(request, response, "user", objectMapper.writeValueAsString(passportService.login(bo)),
				604800, true);

		return JsonResult.isOk(null);
	}

	@GetMapping("/me")
	public Authentication showToken(Authentication token) {
		return token;
	}
}
