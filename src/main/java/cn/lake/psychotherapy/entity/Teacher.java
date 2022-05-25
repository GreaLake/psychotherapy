package cn.lake.psychotherapy.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author: lake
 * @Date: 2022/5/22 13:38
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("咨询师类")
public class Teacher {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @ApiModelProperty("咨询师编号")
    private Long id;
    @ApiModelProperty("咨询师姓名")
    private String name;
    @ApiModelProperty("咨询师用户名")
    private String username;
    @ApiModelProperty("咨询师密码")
    private String password;
    @TableLogic
    @ApiModelProperty("逻辑删除")
    private Boolean is_delete;
    @ApiModelProperty("工作时长")
    private String workTime;
}
