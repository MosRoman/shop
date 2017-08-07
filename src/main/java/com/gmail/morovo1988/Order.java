package com.gmail.morovo1988;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Дом on 31.07.2017.
 */
@Entity
@Table(name="Orders")
@NoArgsConstructor
@Getter
@Setter

public class Order {
    @Id
    @GeneratedValue
    private long id;

    private Date date;

    @ManyToOne
    @JoinColumn(name="user_id")
    private CustomUser customUser;

    @OneToMany(mappedBy="order", cascade=CascadeType.ALL)
    private List<BasketOrders> basketsOrders = new ArrayList<BasketOrders>();

    public void addBasketOrders(BasketOrders a){
        a.setOrder(this);
        basketsOrders.add(a);
    }


    public Order(Date date) {
        this.date = date;

    }

    public Order(Date date, CustomUser customUser) {
        this.date = date;
        this.customUser = customUser;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public CustomUser getCustomUser() {
        return customUser;
    }

    public void setCustomUser(CustomUser customUser) {
        this.customUser = customUser;
    }

    public List<BasketOrders> getBasketsOrders() {
        return basketsOrders;
    }

    public void setBasketsOrders(List<BasketOrders> basketsOrders) {
        this.basketsOrders = basketsOrders;
    }
}