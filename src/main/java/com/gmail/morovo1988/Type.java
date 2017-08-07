package com.gmail.morovo1988;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Дом on 01.08.2017.
 */
@Entity
@Table(name="Types")
@NoArgsConstructor
@Getter
@Setter
public class Type {

        @Id
        @GeneratedValue
        private long id;
        private String name;

        @OneToMany(mappedBy="type", cascade=CascadeType.ALL)
        private List<Product> products = new ArrayList<Product>();

        @OneToMany(mappedBy="type", cascade=CascadeType.ALL)
        private List<BasketOrders> basketOrders = new ArrayList<BasketOrders>();

        public Type(String name) {
            this.name = name;
        }




}
