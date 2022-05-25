package cn.lake.psychotherapy.service;

import cn.lake.psychotherapy.entity.Student;
import cn.lake.psychotherapy.mapper.StudentMapper;
import cn.lake.psychotherapy.utils.MD5Util;
import cn.lake.psychotherapy.utils.TokenUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * @Author: lake
 * @Date: 2022/5/22 9:33
 * @Description: 学生业务类
 */
@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;

    /**
     * 构建查询条件
     * @return
     */
    QueryWrapper<Student> queryWrapper(){
       return new QueryWrapper();
    }

    /**
     * 学员注册
     * @param student
     */
    public String register(Student student) throws NoSuchAlgorithmException {
        if (!existUserName(student.getUsername())||existUsedId(student.getId(),student.getName())){
            student.setPassword(MD5Util.getMD5Str(student.getPassword()));
            studentMapper.insert(student);
            return "激活成功";
        }else {
            return "已被注册";
        }
    }

    /**
     * 用户名是否已被使用
     * @param username
     * @return
     */
    public Boolean existUserName(String username){
        return studentMapper.exists(queryWrapper().eq("username",username));
    }

    /**
     * id是否启用
     * @param id
     * @return
     */
    public Boolean existUsedId(String id,String name){
        return studentMapper.exists(queryWrapper().eq("id",id).eq("name",name).eq("is_used",0));
    }

    /**
     * 学员登录
     * @param username
     * @param password
     * @return
     * @throws NoSuchAlgorithmException
     */
    public String login(String username,String password) throws NoSuchAlgorithmException {
        boolean flag = MD5Util.getMD5Str(password).equals(studentMapper.selectOne(queryWrapper().eq("username", username)).getPassword());
        if (flag){
            return TokenUtil.token(username,password);
        }
        return "failure";
    }

    /**
     * 根据用户名查询学员
     * @param token
     * @param username
     * @return
     */
    public Student findStudentByUserName(String token,String username){
        if (TokenUtil.verify(token)){
            return studentMapper.selectOne(queryWrapper().eq("username",username));
        }
        return null;
    }

    /**
     * 修改密码
     * @param token
     * @param username
     * @param oldPassword
     * @param newPassword
     * @return
     * @throws NoSuchAlgorithmException
     */
    public Boolean updatePassword(String token,String username,String oldPassword,String newPassword) throws NoSuchAlgorithmException {
        Student student = studentMapper.selectOne(queryWrapper().eq("username", username));
        if (TokenUtil.verify(token)){
            if (student.getPassword().equals(MD5Util.getMD5Str(oldPassword))){
                student.setPassword(MD5Util.getMD5Str(newPassword));
                return true;
            }
        }
        return false;
    }

    /**
     * 查询所有学员
     * @return
     */
    public List<Student> findAllStudent(){
        return studentMapper.selectList(null);
    }

}
