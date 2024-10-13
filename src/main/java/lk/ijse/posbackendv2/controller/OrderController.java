package lk.ijse.posbackendv2.controller;

import lk.ijse.posbackendv2.services.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("api/v1/orders")
public class OrderController {
    Logger logger = LoggerFactory.getLogger(ProductController.class);

    OrderService orderService;


}
