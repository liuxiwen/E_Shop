package cn.it.shop.action;

import cn.it.shop.model.Category;
import cn.it.shop.service.CategoryService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;

/**
 * Created by liuxiwen on 2017/3/28.
 */
@Controller("categoryAction")
@Scope("prototype")
public class CategoryAction extends BaseAction<Category> {

    public String queryJoinAccount() {
        // 用来存储分页的数据
        pageMap = new HashMap<>();
        // 根据关键字和分页的参数查询相应的数据。
        List<Category> categories = categoryService.queryJoinAccount(model.getType(), page, rows);
        pageMap.put("rows", categories);// 存储为json格式
        // 根据关键字查询总记录数
        Long total = categoryService.getCount(model.getType());
        pageMap.put("total", total);// 存储为json格式
        return "jsonMap";
    }
}
