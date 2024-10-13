package lk.ijse.posbackendv2.services;

import lk.ijse.posbackendv2.dto.OrderStatus;
import lk.ijse.posbackendv2.dto.impl.OrderDTO;

import java.util.List;

public interface OrderService {
    void saveOrder(OrderDTO orderDTO);
    List<OrderDTO> getAllOrders();
    void deleteOrder(String orderId);
}
