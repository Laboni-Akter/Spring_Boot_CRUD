package com.product.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="productname")
    private String productname;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private String price;
    @Column(name = "quantity")
    private String quantity;

    public products()
    {
        super();
    }

    public long getId() {
        return id;
    }

    public String getProductname() {
        return productname;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public String getQuantity() {
        return quantity;
    }

    public products(String productname, String description, String price, String quantity) {
        this.productname = productname;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "products{" +
                "id=" + id +
                ", productname='" + productname + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                ", quantity='" + quantity + '\'' +
                '}';
    }
}