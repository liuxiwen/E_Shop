package cn.it.shop.action;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.stereotype.Controller;

/**
 * Created by liuxiwen on 2017/3/29.
 * @Description 此Action用来完成WEB-INF中JSP与JSP请求转发功能，此Action不处理任何的逻辑
 */
@Controller("sendAction")
public class SendAction extends ActionSupport {

    @Override
    public String execute() {
        return "send";
    }
}
