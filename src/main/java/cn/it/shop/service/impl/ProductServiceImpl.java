package cn.it.shop.service.impl;

import cn.it.shop.model.Product;
import cn.it.shop.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liuxiwen on 2017/4/6.
 */
@Service("productService")
public class ProductServiceImpl extends BaseServiceImpl<Product> implements ProductService {

    @Override
    public List<Product> queryJoinCategory(String name, int page, int size) {
        String hql = "from Product p left join fetch p.category where p.name like :name";
        return getSession().createQuery(hql)
                .setString("name", "%" + name + "%")
                .setFirstResult((page -1) * size)// 从第几个开始显示
                .setMaxResults(size)// 显示几个
                .list();
    }

    @Override
    public Long getCount(String name) {
        String hql = "select count(p) from Product p where p.name like :name";
        return (Long) getSession().createQuery(hql)
                .setString("name", "%" + name + "%")
                .uniqueResult();// 返回一条记录：总记录数
    }
}
