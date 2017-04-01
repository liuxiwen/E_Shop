package cn.it.shop.action;

import cn.it.shop.model.Account;
import cn.it.shop.service.AccountService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Created by liuxiwen on 2017/3/30.
 */
@Controller("accountAction")
@Scope("prototype")
public class AccountAction extends BaseAction<Account> {

    public String query() {
        jsonList = accountService.query();
        return "jsonList";
    }
}
