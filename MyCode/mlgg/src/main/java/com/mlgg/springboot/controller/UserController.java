package com.mlgg.springboot.controller;

import com.mlgg.springboot.req.UserRequest;
import com.mlgg.springboot.res.UserResponse;
import com.mlgg.springboot.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * <Description> <br>
 *
 * @author zhang.yifei4<br>
 * @Date 17:00 2019/12/12
 * @see com.mlgg.springboot.controller
 */
@Api(value="用户controller",tags={"用户操作接口"})
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value="获取测试用户信息",notes="注意事项：无")
    @GetMapping("/getTestUser")
    public UserResponse getTestUser() {
        return new UserResponse.Builder("aloha", "123").age(23).builder();
    }

    @ApiOperation(value="获取所有用户信息",notes="注意事项：无")
    @GetMapping("/getAllUser")
    public List<UserResponse> getAllUser() throws Exception{
        return userService.getAllUserFromFile();
    }

    @ApiOperation(value="添加用户信息",notes="注意事项：请求参数不能为空")
    @PostMapping("/addUser")
    public Integer userAdd(@RequestBody UserRequest userRequest) throws Exception {
        return userService.addUser(userRequest);
    }
}
