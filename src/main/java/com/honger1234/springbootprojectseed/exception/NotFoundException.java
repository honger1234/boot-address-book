package com.honger1234.springbootprojectseed.exception;

import com.honger1234.springbootprojectseed.util.ResultGenerator;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 继承ErrorController接口重写getErrorPath方法，处理404异常
 * @author: zt
 */
@RestController
public class NotFoundException implements ErrorController {
    private static final String ERROR_PATH = "/error";

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

    @RequestMapping(ERROR_PATH)
    public Object error() {
        return ResultGenerator.gen404NotFoundResult();
    }

}
