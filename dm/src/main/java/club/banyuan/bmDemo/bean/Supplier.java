package club.banyuan.bmDemo.bean;

import java.io.Serializable;

/**
 * @author 陈浩
 * @date Created on 2019/12/15
 */
public class Supplier implements Serializable {
    private Integer supplierId;

    private String name;

    private String description;

    private String contact;

    private String photo;

    private String fax;

    private String address;

    public Supplier(Integer supplierId, String name, String description, String contact, String photo, String fax, String address) {
        this.supplierId = supplierId;
        this.name = name;
        this.description = description;
        this.contact = contact;
        this.photo = photo;
        this.fax = fax;
        this.address = address;
    }

    public Supplier() {
    }


    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "supplierId=" + supplierId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", contact='" + contact + '\'' +
                ", photo='" + photo + '\'' +
                ", fax='" + fax + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}





