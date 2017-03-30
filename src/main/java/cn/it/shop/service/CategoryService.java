package cn.it.shop.service;

import cn.it.shop.model.Account;
import cn.it.shop.model.Category;

import java.util.List;

/**
 * Created by liuxiwen on 2017/3/28.
 * @Description CategoryService接口继承BaseService接口
 */
public interface CategoryService extends BaseService<Category> {

    /* 只要添加CategoryService本身需要的新的方法即可，公共方法已经在BaseService中 */

    // 查询类别信息，级联管理员
    List<Category> queryJoinAccount(String type, int page, int size);// 使用类别的名称查询

    // 根据关键字查询总记录数
    Long getCount(String type);
}
