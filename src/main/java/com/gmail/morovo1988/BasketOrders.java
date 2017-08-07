package com.gmail.morovo1988;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Дом on 02.08.2017.
 */
@Entity
@Table(name="Basket")
@NoArgsConstructor
@Getter
@Setter
public class BasketOrders {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private CustomUser customUser;
    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;
    @ManyToOne
    @JoinColumn(name="type_id")
    private Type type;


    @Column(name = "Brands", nullable = false)
    private String brand;
    @Column
    private double diametr;

    @Column
    private  double price;

    public BasketOrders(CustomUser customUser, Type type, String brand, double diametr, double price) {
        this.customUser = customUser;
        this.type = type;
        this.brand = brand;
        this.diametr = diametr;
        this.price = price;
    }

    public BasketOrders(CustomUser customUser, Order order, Type type, String brand, double diametr, double price) {
        this.customUser = customUser;
        this.order = order;
        this.type = type;
        this.brand = brand;
        this.diametr = diametr;

        this.price = price;
    }

    public BasketOrders(Order order, String brand, double diametr, int amount, double price) {
        this.order = order;
        this.brand = brand;
        this.diametr = diametr;

        this.price = price;
    }

    public BasketOrders(Type type, String brand, double diametr, double price) {
        this.type = type;
        this.brand = brand;
        this.diametr = diametr;
        this.price = price;
    }

    public CustomUser getCustomUser() {
        return customUser;
    }

    public void setCustomUser(CustomUser customUser) {
        this.customUser = customUser;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getDiametr() {
        return diametr;
    }

    public void setDiametr(double diametr) {
        this.diametr = diametr;
    }



    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
