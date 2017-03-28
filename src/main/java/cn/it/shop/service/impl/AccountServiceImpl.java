package cn.it.shop.service.impl;

import cn.it.shop.model.Account;
import cn.it.shop.service.AccountService;
import org.springframework.stereotype.Service;

/**
 * Created by liuxiwen on 2017/3/28.
 */
@Service("accountService")
public class AccountServiceImpl extends BaseServiceImpl<Account> implements AccountService {

    /* 只要实现AccountService接口中新增的方法即可，公共方法已经在BaseServiceImpl中实现了 */
}
