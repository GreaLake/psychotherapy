package cn.lake.psychotherapy.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: lake
 * @Date: 2022/5/22 2:12
 * @Description: 学员类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("学员类")
public class Student {
    @ApiModelProperty("学员编号")
    private String id;
    @ApiModelProperty("学员姓名")
    private String name;
    @ApiModelProperty("学员用户名")
    private String username;
    @ApiModelProperty("学员密码")
    private String password;
    @TableLogic
    @ApiModelProperty("逻辑删除")
    private Boolean is_delete;
    @ApiModelProperty("vip时长")
    private Double vipTime;
    @ApiModelProperty("是否使用")
    private Boolean isUsed;
}
