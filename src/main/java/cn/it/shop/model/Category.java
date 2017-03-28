package cn.it.shop.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by liuxiwen on 2017/3/28.
 */
@Entity
public class Category implements Serializable {

    private Integer id;
    private String type;
    private Boolean hot;
    private Account account;

    public Category() {

    }

    public Category(String type, Boolean hot) {
        this.type = type;
        this.hot = hot;
    }

    public Category(String type, Boolean hot, Account account) {
        this.type = type;
        this.hot = hot;
        this.account = account;
    }

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "type", length = 20)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "hot")
    public Boolean getHot() {
        return hot;
    }

    public void setHot(Boolean hot) {
        this.hot = hot;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aid")
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", hot=" + hot +
                ", account=" + account +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
