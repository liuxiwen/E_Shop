package cn.it.shop.action;

import cn.it.shop.service.AccountService;
import cn.it.shop.service.CategoryService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

/**
 * Created by liuxiwen on 2017/3/28.
 */
@Controller("baseAction")
@Scope("prototype")
public class BaseAction<T> extends ActionSupport implements RequestAware, SessionAware, ApplicationAware, ModelDriven<T> {

    // 封装将要打包成json格式返回给前台的数据，要实现get方法
    protected List<T> jsonList = null;

    public List<T> getJsonList() {
        return jsonList;
    }

    // 获取要删除的ids，要有get和set方法
    // 流是用来向前台返回数据的，这个数据是让struts获取的，然后通过流的形式传到前台，所以实现get方法即可
    protected String ids;
    protected InputStream inputStream;

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    // page和rows和分页有关，pageMap存放查询的数据，然后打包成json格式
    // page和rows实现get和set方法，pageMap只需要实现get方法，因为pageMap不是接收前台数据的，是让struts获取的
    protected Integer page;
    protected Integer rows;
    protected Map<String, Object> pageMap = null;// 让不同action自己去实现

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Map<String, Object> getPageMap() {
        return pageMap;
    }

    // service对象
    @Resource
    protected CategoryService categoryService;
    @Resource
    protected AccountService accountService;

    // 域对象
    protected Map<String, Object> request;
    protected Map<String, Object> session;
    protected Map<String, Object> application;

    @Override
    public void setApplication(Map<String, Object> application) {
        this.application = application;
    }

    @Override
    public void setRequest(Map<String, Object> request) {
        this.request = request;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    // ModelDriven
    protected T model;

    @Override
    public T getModel() {// 通过解析传进来的T来new一个对应的instance
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        Class clazz = (Class) type.getActualTypeArguments()[0];
        try {
            model = (T) clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return model;
    }
}
