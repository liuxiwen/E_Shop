package cn.it.shop.service;

import cn.it.shop.model.Product;

import java.util.List;

/**
 * Created by liuxiwen on 2017/4/6.
 */
public interface ProductService extends BaseService<Product> {

    // 查询商品信息，级联类别
    List<Product> queryJoinCategory(String name, int page, int size);// 使用商品名称查询

    // 根据关键字查询总记录数
    Long getCount(String name);
}
