package com.gmail.morovo1988;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Дом on 02.08.2017.
 */
public interface BasketRepository extends JpaRepository<BasketOrders, Long> {
    @Query("SELECT c FROM BasketOrders c WHERE c.customUser = :customUser and c.order is NULL" )
    List<BasketOrders> findByOrder(@Param("customUser") CustomUser customUser, Pageable pageable);

    @Query("SELECT c FROM BasketOrders c WHERE c.customUser = :customUser and c.order is NULL" )
    List<BasketOrders> findByOrder(@Param("customUser") CustomUser customUser);

    @Query("SELECT c FROM BasketOrders c WHERE c.order is not NULL" )
    List<BasketOrders> findAllOrder(Pageable pageable);
}
