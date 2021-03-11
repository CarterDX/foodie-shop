package net.seehope.foodie.controller.advice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.seehope.foodie.common.JsonResult;

/**
 * 全局异常处理
 * 
 * @ControllerAdvice 和 @ExceptionHandler 配合使用
 * @author cx
 *
 */
@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public JsonResult defaultExceptionHandler(HttpServletRequest req, HttpServletResponse resp, Exception e) {

		e.printStackTrace();

		return JsonResult.errorMsg(e.getLocalizedMessage());
	}

	/*
	 * 捕获 MethodArgumentNotValidException 异常（valid 验证的异常）
	 */
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	@ResponseBody
	public JsonResult handleMethodArgumentNotValidException(HttpServletRequest req, HttpServletResponse resp,
			MethodArgumentNotValidException e) throws JsonProcessingException {

		Map<String, String> errorMsg = new HashMap<String, String>();

		List<FieldError> fieldsList = e.getBindingResult().getFieldErrors();
		for (FieldError fieldError : fieldsList) {
			errorMsg.put(fieldError.getField(), fieldError.getDefaultMessage());
		}

		/*
		 * e.getBindingResult().getFieldErrors().forEach(fieldError -> {
		 * System.out.println(fieldError.getField() + ":" +
		 * fieldError.getDefaultMessage()); });
		 */

		/*
		 * writeValueAsString() 将传入的对象序列化为json，返回给调用者
		 */
		return JsonResult.errorMsg(new ObjectMapper().writeValueAsString(errorMsg));
	}
}
