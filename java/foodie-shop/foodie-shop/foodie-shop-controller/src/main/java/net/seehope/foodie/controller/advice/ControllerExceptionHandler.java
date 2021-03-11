package net.seehope.foodie.controller.advice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import net.seehope.foodie.common.JsonResult;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JsonResult defaultExceptionHandler(HttpServletRequest req, HttpServletResponse resp, Exception e) {

        e.printStackTrace();

        return JsonResult.errorMsg(e.getLocalizedMessage());
    }
}
