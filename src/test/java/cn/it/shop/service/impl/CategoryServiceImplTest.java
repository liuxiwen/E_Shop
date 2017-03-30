package cn.it.shop.service.impl;

import cn.it.shop.model.Category;
import cn.it.shop.service.CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by liuxiwen on 2017/3/30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
public class CategoryServiceImplTest {

    @Resource
    private CategoryService categoryService;

    @Test
    public void testQueryJoinAccount() {
        for (Category category : categoryService.queryJoinAccount("", 1, 2)) {// 显示第一页，每页2条数据
            System.out.println(category);
            System.out.println(category.getAccount());
        }
    }
}
