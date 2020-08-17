package com.honger1234.springbootprojectseed.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 联系人表
 * </p>
 *
 * @author zt
 * @since 2020-08-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_contact")
@ApiModel(value="Contact对象", description="联系人表")
public class Contact implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "Id")
      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "移动手机号码")
    private String phoneNumber;

    @ApiModelProperty(value = "家庭号码")
    private String teleNumber;

    @ApiModelProperty(value = "工作地址")
    private String workAddress;

    @ApiModelProperty(value = "家庭地址")
    private String homeAddress;

    @ApiModelProperty(value = "头像")
    private String image;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "姓名首字母")
    private String initial;

    @ApiModelProperty(value = "创建时间")
      @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "创建人")
      @TableField(fill = FieldFill.INSERT)
    private String createOperator;

    @ApiModelProperty(value = "更新时间")
      @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "更新人")
      @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateOperator;

    @ApiModelProperty(value = "逻辑删除 0未删，1删除")
      @TableField(fill = FieldFill.INSERT)
    @TableLogic
    private Integer deleted;


}
