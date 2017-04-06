package cn.it.shop.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * Created by liuxiwen on 2017/3/28.
 */
@Entity
public class Product implements Serializable {

    private Integer id;
    private String name;
    private BigDecimal price;
    private String pic;
    private String remark;
    private String xremark;
    private Date date;
    private Boolean commend;
    private Boolean open;
    private Category category;

    public Product() {

    }

    public Product(String name, BigDecimal price, String pic, String remark, String xremark, Date date, Boolean commend, Boolean open) {
        this.name = name;
        this.price = price;
        this.pic = pic;
        this.remark = remark;
        this.xremark = xremark;
        this.date = date;
        this.commend = commend;
        this.open = open;
    }

    public Product(String name, BigDecimal price, String pic, String remark, String xremark, Date date, Boolean commend, Boolean open, Category category) {
        this.name = name;
        this.price = price;
        this.pic = pic;
        this.remark = remark;
        this.xremark = xremark;
        this.date = date;
        this.commend = commend;
        this.open = open;
        this.category = category;
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

    @Column(name = "name", length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "price", precision = 8)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Column(name = "pic", length = 200)
    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    @Column(name = "remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Column(name = "xremark")
    public String getXremark() {
        return xremark;
    }

    public void setXremark(String xremark) {
        this.xremark = xremark;
    }

    @Column(name = "date", nullable = true, length = 19)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name = "commend")
    public Boolean getCommend() {
        return commend;
    }

    public void setCommend(Boolean commend) {
        this.commend = commend;
    }

    @Column(name = "open")
    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cid")
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", pic='" + pic + '\'' +
                ", remark='" + remark + '\'' +
                ", xremark='" + xremark + '\'' +
                ", date=" + date +
                ", commend=" + commend +
                ", open=" + open +
                ", category=" + category +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
