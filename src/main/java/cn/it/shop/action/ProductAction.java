package cn.it.shop.action;

import cn.it.shop.model.Product;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;

/**
 * Created by liuxiwen on 2017/4/6.
 */
@Controller("productAction")
@Scope("prototype")
public class ProductAction extends BaseAction<Product> {

    public String queryJoinCategory() {
        // 用来存储分页的数据
        pageMap = new HashMap<>();
        // 根据关键字和分页的参数查询相应的数据
        List<Product> productList = productService.queryJoinCategory(model.getName(), page, rows);
        pageMap.put("rows", productList);// 存储为json格式
        // 根据关键字查询总记录数
        Long total = productService.getCount(model.getName());
        pageMap.put("total", total);
        return "jsonMap";
    }
}
