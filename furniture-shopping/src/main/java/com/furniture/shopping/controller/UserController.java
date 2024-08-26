package com.furniture.shopping.controller;

import com.furniture.shopping.common.ApiRestResponse;
import com.furniture.shopping.common.Constant;
import com.furniture.shopping.exception.FurnitureExceptionEnum;
import com.furniture.shopping.model.pojo.User;
import com.furniture.shopping.service.UserService;
import com.furniture.shopping.utils.MD5Utils;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户控制器
 */
@Controller
@RequestMapping("/api/user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/login")
    @ResponseBody
    public ApiRestResponse<?> login(@RequestParam("userNo") String userNo,
                                    @RequestParam("password") String password,
                                    @RequestParam("role") Long role,
                                    HttpSession session){
        if (userNo == null){
            return ApiRestResponse.error(FurnitureExceptionEnum.USER_NO_EMPTY);
        }
        if (password == null){
            return ApiRestResponse.error(FurnitureExceptionEnum.PASS_WORD_EMPTY);
        }
        if (role == null){
            return ApiRestResponse.error(FurnitureExceptionEnum.ROLE_NO_EMPTY);
        }
        User login = userService.login(userNo, password, role);
        if (!login.getUserStatus().equals("1")) {
            return ApiRestResponse.error(FurnitureExceptionEnum.USER_STATUS_ERROR);
        }
        login.setPassword(null);
        session.setAttribute(Constant.FURNITURE_USER,login);
        return ApiRestResponse.success(login);
    }

    @PostMapping("/all/shop")
    @ResponseBody
    public ApiRestResponse<?> allShop(){
        Map<String,Object> map=new LinkedHashMap<>();
        List<User> users = userService.selectByRole(Constant.RoleType.SHOP);
        map.put("list",users);
        return ApiRestResponse.success(map);
    }

    @PostMapping("/all/designer")
    @ResponseBody
    public ApiRestResponse<?> allDesigner(){
        Map<String,Object> map=new LinkedHashMap<>();
        List<User> users = userService.selectByRole(Constant.RoleType.DESIGNER);
        map.put("list",users);
        return ApiRestResponse.success(map);
    }

    @PostMapping("/all/user")
    @ResponseBody
    public ApiRestResponse<?> allUser(){
        Map<String,Object> map=new LinkedHashMap<>();
        List<User> users = userService.selectByRole(Constant.RoleType.USER);
        map.put("list",users);
        return ApiRestResponse.success(map);
    }

    @PostMapping("/insert/shop")
    @ResponseBody
    public ApiRestResponse<?> insertShop(@RequestParam("userName") String userName,@RequestParam("userNo") String userNo,@RequestParam("password") String password,@RequestParam(name = "signature",required = false) String signature) throws NoSuchAlgorithmException {
        User existUser = userService.initUser(userNo);
        if (existUser != null) {
            return ApiRestResponse.error("账号已存在");
        }
        User user=new User();
        user.setUserName(userName);
        user.setUserNo(userNo);
        user.setRoleType(Long.valueOf(Constant.RoleType.SHOP));
        user.setPassword(MD5Utils.getMD5Str(password));
        if (signature!=null){
            user.setSignature(signature);
        }
        User insertUser = userService.insertUser(user);
        return ApiRestResponse.success(insertUser);
    }

    @PostMapping("/insert/designer")
    @ResponseBody
    public ApiRestResponse<?> insertDesigner(@RequestParam("userName") String userName,@RequestParam("userNo") String userNo,@RequestParam("password") String password,@RequestParam(name = "signature",required = false) String signature) throws NoSuchAlgorithmException {
        User existUser = userService.initUser(userNo);
        if (existUser != null) {
            return ApiRestResponse.error("账号已存在");
        }
        User user=new User();
        user.setUserName(userName);
        user.setUserNo(userNo);
        user.setRoleType(Long.valueOf(Constant.RoleType.DESIGNER));
        user.setPassword(MD5Utils.getMD5Str(password));
        if (signature!=null){
            user.setSignature(signature);
        }
        User insertUser = userService.insertUser(user);
        return ApiRestResponse.success(insertUser);
    }

    @PostMapping("/insert/user")
    @ResponseBody
    public ApiRestResponse<?> insertUser(@RequestParam("userName") String userName,@RequestParam("userNo") String userNo,@RequestParam("password") String password,@RequestParam(name = "signature",required = false) String signature) throws NoSuchAlgorithmException {
        User existUser = userService.initUser(userNo);
        if (existUser != null) {
            return ApiRestResponse.error("账号已存在");
        }
        User user=new User();
        user.setUserName(userName);
        user.setUserNo(userNo);
        user.setRoleType(Long.valueOf(Constant.RoleType.USER));
        user.setPassword(MD5Utils.getMD5Str(password));
        if (signature!=null){
            user.setSignature(signature);
        }
        User insertUser = userService.insertUser(user);
        return ApiRestResponse.success(insertUser);
    }

    @PostMapping("/delete/user")
    @ResponseBody
    public ApiRestResponse<?> deleteUser(@RequestParam("userId") String userId){
        userService.deleteUser(Integer.valueOf(userId));
        return ApiRestResponse.success();
    }

    @PostMapping("/update/user")
    @ResponseBody
    public ApiRestResponse<?> updateUser(User user){
        if (user.getUserId()==null){
            return ApiRestResponse.error(FurnitureExceptionEnum.USER_UNIQUE);
        }
        User existUser = userService.initUser(user.getUserNo());
        if (existUser != null) {
            return ApiRestResponse.error("账号已存在");
        }
        if (StringUtils.hasText(user.getUserStatus())) {
            userService.updateUserStatus(user);
        } else {
            userService.updateUser(user);
        }
        return ApiRestResponse.success();
    }

    @PostMapping("/self/msg")
    @ResponseBody
    public ApiRestResponse<?> selfMsg(HttpSession session){
        User user = userService.initUser(((User)session.getAttribute(Constant.FURNITURE_USER)).getUserNo());
        return ApiRestResponse.success(user);
    }

    @PostMapping("/register")
    @ResponseBody
    public ApiRestResponse<?> register(@RequestBody User user) throws Exception{
        if (user.getUserNo() == null || user.getUserNo().equals("")) {
            return ApiRestResponse.error("账号不能为空");
        }
        User existUser = userService.initUser(user.getUserNo());
        if (existUser != null) {
            return ApiRestResponse.error("账号已存在");
        }
        user.setUserStatus("1");
        if (user.getRoleType() == 1) {
            if (!StringUtils.hasText(user.getBusinessLicense())) {
                return ApiRestResponse.error("店铺必须输入营业执照号");
            }
            user.setUserStatus("2");
        }
        user.setPassword(MD5Utils.getMD5Str(user.getPassword()));
        User insertUser = userService.insertUser(user);
        return ApiRestResponse.success(insertUser);
    }

    @PostMapping("/getUser")
    @ResponseBody
    public ApiRestResponse<?> getUser(User user){
        User u = userService.getUser(user);
        return ApiRestResponse.success(u);
    }
}
