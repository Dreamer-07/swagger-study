package pers.dreamer07.swagger.pojo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: swagger
 * @description:
 * @author: EMTKnight
 * @create: 2021-03-15
 **/
@ApiModel(description = "用戶实体类") // 对于 ApiModel 建议使用 description 属性，而不是直接修改 value
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    private String password;

}
