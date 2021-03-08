package top.szz.boot.basic.controller.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 囧态汗
 * @date 2021/3/4
 * @description AjaxResponse
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("统一响应结果")
public class AjaxResponse {
    /**
     * 请求响应状态码（200、400、500）
     */
    @ApiModelProperty("请求响应状态码")
    private Integer code;
    /**
     * 请求结果描述信息
     */
    @ApiModelProperty("请求结果描述信息")
    private String message;
    /**
     * 请求返回数据
     */
    @ApiModelProperty("请求返回数据")
    private Object data;

    public static AjaxResponse success(){
        AjaxResponse ajaxResponse =new AjaxResponse();
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage("请求响应成功");
        return ajaxResponse;
    }
    public static AjaxResponse success(Object obj){
        AjaxResponse ajaxResponse =new AjaxResponse();
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage("请求响应成功");
        ajaxResponse.setData(obj);
        return ajaxResponse;
    }
    public static AjaxResponse success(Object obj, String
            message) {
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage(message);
        ajaxResponse.setData(obj);
        return ajaxResponse;
    }
}
