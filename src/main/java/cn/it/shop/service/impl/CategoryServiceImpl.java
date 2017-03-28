package cn.it.shop.service.impl;

import cn.it.shop.model.Category;
import cn.it.shop.service.CategoryService;
import org.springframework.stereotype.Service;

/**
 * Created by liuxiwen on 2017/3/28.
 */
@Service("categoryService")
public class CategoryServiceImpl extends BaseServiceImpl<Category> implements CategoryService {

    /* 只要实现CategoryService接口中新增的方法即可，公共方法已经在BaseServiceImpl中实现了 */
}
