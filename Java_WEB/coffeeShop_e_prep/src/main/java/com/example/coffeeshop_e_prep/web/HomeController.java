package com.example.coffeeshop_e_prep.web;

import com.example.coffeeshop_e_prep.model.view.OrderViewModel;
import com.example.coffeeshop_e_prep.sec.CurrentUser;
import com.example.coffeeshop_e_prep.service.OrderService;
import com.example.coffeeshop_e_prep.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final OrderService orderService;

    private  final UserService userService;


    public HomeController(CurrentUser currentUser, OrderService orderService, UserService userService) {
        this.currentUser = currentUser;
        this.orderService = orderService;
        this.userService = userService;
    }

    @GetMapping()
    public String index(Model model) {
        if (currentUser.getId() == null){
            return "index";
        }

        List<OrderViewModel> orders = orderService.findAllOrderByPriceDesc();

        model.addAttribute("orders", orders);

        model.addAttribute("totalTime", orders
                .stream()
                .map(orderViewModel -> orderViewModel.getCategory().getNeededTime())
                .reduce(Integer::sum)
                .orElse(0)
        );

        model.addAttribute("users", userService.findAllUserAndCountOfOrdersOrderByCountDesc());


        return "home";

    }


}
