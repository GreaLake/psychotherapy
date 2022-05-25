package cn.lake.psychotherapy.service;

import cn.lake.psychotherapy.entity.Teacher;
import cn.lake.psychotherapy.mapper.TeacherMapper;
import cn.lake.psychotherapy.utils.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Author: lake
 * @Date: 2022/5/22 18:29
 * @Description: 咨询师业务类
 */
@Service
public class TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    /**
     * 登记老师
     * @param teacher
     * @return
     */
//    @ApiOperation("登记讲师")
//    @PostMapping("/addTeacher")
    public Boolean addTeacher(Teacher teacher){
        return teacherMapper.insert(teacher)==1;
    }

//    @ApiOperation("")
//    @PostMapping("")
//    public Boolean login(Long id,String password){
//        teacherMapper.selectById(id);
//    }
}
