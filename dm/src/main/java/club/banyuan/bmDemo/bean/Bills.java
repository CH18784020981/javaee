package club.banyuan.bmDemo.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 陈浩
 * @date Created on 2019/12/15
 */
public class Bills implements Serializable {
    private Integer billId;

    private String name;

    private String amount;
    private String money;
    private String supplier;

    private String description;

    private Date creatDate;

    private String payOrNot;

    public Bills() {
    }

    public Bills(Integer billId, String name, String amount, String money, String supplier, String description, Date creatDate, String payOrNot) {
        this.billId = billId;
        this.name = name;
        this.amount = amount;
        this.money = money;
        this.supplier = supplier;
        this.description = description;
        this.creatDate = creatDate;
        this.payOrNot = payOrNot;
    }

    public Integer getBillId() {
        return billId;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(Date creatDate) {
        this.creatDate = creatDate;
    }

    public String getPayOrNot() {
        return payOrNot;
    }

    public void setPayOrNot(String payOrNot) {
        this.payOrNot = payOrNot;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Bills{" +
                "billId=" + billId +
                ", name='" + name + '\'' +
                ", amount='" + amount + '\'' +
                ", money='" + money + '\'' +
                ", supplier='" + supplier + '\'' +
                ", description='" + description + '\'' +
                ", creatDate=" + creatDate +
                ", payOrNot=" + payOrNot +
                '}';
    }
}
