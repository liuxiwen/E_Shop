package cn.it.shop.service;

import java.util.List;

/**
 * Created by liuxiwen on 2017/3/28.
 * 基础接口BaseService，使用泛型
 */
public interface BaseService<T> {

    void save(T t);

    void update(T t);

    void delete(int id);

    T get(int id);

    List<T> query();
}
