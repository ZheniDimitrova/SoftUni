package com.example.coffeeshop_e_prep.service;

import com.example.coffeeshop_e_prep.model.service.OrderServiceModel;
import com.example.coffeeshop_e_prep.model.view.OrderViewModel;

import java.util.List;

public interface OrderService {
    void addOrder(OrderServiceModel orderServiceModel);

    List<OrderViewModel> findAllOrderByPriceDesc();

    void readyOrder(Long id);
}
