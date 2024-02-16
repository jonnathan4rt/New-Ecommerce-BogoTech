package com.newpiece.infrastructure.controller;

import com.newpiece.application.service.OrderProductService;
import com.newpiece.application.service.OrderService;
import com.newpiece.application.service.UserService;
import com.newpiece.domain.Order;
import com.newpiece.domain.OrderProduct;
import com.newpiece.domain.User;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user/cart/shopping")
@Slf4j
public class ShoppingListController {
    private final OrderService orderService;
    private final UserService userService;
    private final OrderProductService orderProductService;

    public ShoppingListController(OrderService orderService, UserService userService, OrderProductService orderProductService) {
        this.orderService = orderService;
        this.userService = userService;
        this.orderProductService = orderProductService;
    }

    @GetMapping
    public String showShoppingList(Model model, HttpSession httpSession){
        List<Order> newListOrder = new ArrayList<>();
        User user = userService.findById(Integer.parseInt(httpSession.getAttribute("iduser").toString()));

        Iterable<Order> orders = orderService.getOrdersByUser(user);
        for (Order order: orders) {
           newListOrder.add(getOrdersProducts(order));
        }
        model.addAttribute("id", Integer.parseInt(httpSession.getAttribute("iduser").toString()));
        model.addAttribute("orders", newListOrder);
        return "user/shoppingList";
    }
    private Order getOrdersProducts(Order order){
        Iterable<OrderProduct> orderProducts = orderProductService.getOrderProductsByOrder(order);
        order.addOrdersProduct((List<OrderProduct>) orderProducts);
        return order;
    }

}
