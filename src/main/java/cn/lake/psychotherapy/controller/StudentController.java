package cn.lake.psychotherapy.controller;

import cn.lake.psychotherapy.entity.Student;
import cn.lake.psychotherapy.service.StudentService;
import cn.lake.psychotherapy.utils.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;


/**
 * @Author: lake
 * @Date: 2022/5/22 9:33
 * @Description: 学员控制类
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/psychotherapy/student/")
public class StudentController {
    @Autowired
    private StudentService studentService;

    /**
     * 学员注册
     * @param student
     * @return
     * @throws NoSuchAlgorithmException
     */
    @PostMapping("/register")
    @ApiOperation("学员注册")
    public Result register(@RequestBody Student student) throws NoSuchAlgorithmException {
        studentService.register(student);
        return new Result(200,"success","/student/register");
    }

    /**
     * 学员登录
     * @param map
     * @return
     * @throws NoSuchAlgorithmException
     */
    @ApiOperation("学员登录")
    @PostMapping("/login")
    public Result login(@RequestBody Map<String,String> map) throws NoSuchAlgorithmException {
        return new Result(200, studentService.login(
                map.get("username"),map.get("password")),"/student/login");
    }

    /**
     * 查询用户个人信息
     * @param username
     * @param token
     * @return
     */
    @GetMapping("/findStudentByUseName")
    @ApiOperation("查询用户个人信息")
    public Result findStudentByUseName(@RequestParam String username,@RequestHeader String token){
        return new Result(200,studentService.findStudentByUserName(username, token),"/student/findStudentByUseName");
    }

    /**
     * 修改密码
     * @param map
     * @param token
     * @return
     * @throws NoSuchAlgorithmException
     */
    @PostMapping("/updatePassword")
    @ApiOperation("修改密码")
    public Result updatePassword(@RequestBody Map<String,String> map,@RequestHeader String token) throws NoSuchAlgorithmException {
        return new Result(200,studentService.updatePassword(token,
                map.get("username"),map.get("oldPassword"),map.get("newPassword")),"/student/updatePassword");
    }

    /**
     * 查询所有学员
     * @return
     */
    @GetMapping("/findAllStudent")
    @ApiOperation("查询所有学员")
    public List<Student> findAllStudent(){
        return studentService.findAllStudent();
    }
}
