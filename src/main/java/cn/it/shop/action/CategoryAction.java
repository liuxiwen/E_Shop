package cn.it.shop.action;

import cn.it.shop.model.Category;
import cn.it.shop.service.CategoryService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Created by liuxiwen on 2017/3/28.
 */
@Controller("categoryAction")
@Scope("prototype")
public class CategoryAction extends BaseAction<Category> {

    public String update() {
        System.out.println("----update----");
        categoryService.update(model);
        return "index";
    }

    public String save() {
        System.out.println("----save----");
        System.out.println(model);
        return "index";
    }

    public String query() {
        request.put("categoryList", categoryService.query());
        session.put("categoryList", categoryService.query());
        application.put("categoryList", categoryService.query());
        return "index";
    }
}
