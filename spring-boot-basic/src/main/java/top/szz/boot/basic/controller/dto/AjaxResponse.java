package top.szz.boot.basic.controller.dto;

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
public class AjaxResponse {
    private Integer code;
    private String message;
    private Object data;

    public static AjaxResponse success(){
        AjaxResponse ajaxResponse =new AjaxResponse();
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage("请求成功");
        return ajaxResponse;
    }
    public static AjaxResponse success(Object obj){
        AjaxResponse ajaxResponse =new AjaxResponse();
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage("请求成功");
        ajaxResponse.setData(obj);
        return ajaxResponse;
    }
}
