package lk.ijse.posbackendv2.services.impl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lk.ijse.posbackendv2.dao.OrderDAO;
import lk.ijse.posbackendv2.dao.ProductDAO;
import lk.ijse.posbackendv2.dto.impl.OrderDTO;
import lk.ijse.posbackendv2.entity.impl.Order;
import lk.ijse.posbackendv2.exception.OrderNotFoundException;
import lk.ijse.posbackendv2.services.OrderService;
import lk.ijse.posbackendv2.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private Mapping mapping;

    @Override
    public void saveOrder(OrderDTO orderDTO) {
        Order saveOrder = orderDAO.save(mapping.toOrderEntity(orderDTO));
        if (saveOrder == null) {
            throw new OrderNotFoundException("Order not found");
        }
    }

    public void updateQty(OrderDTO orderDTO, int qty, String orderId) {

    }

    @Override
    public List<OrderDTO> getAllOrders() {
        List<Order> allOrders = orderDAO.findAll();
        return mapping.asOrderDTO(allOrders);
    }

    @Override
    public void deleteOrder(String orderId) {
        Optional<Order> existedOrder = orderDAO.findById(orderId);
        if (existedOrder.isPresent()) {
            throw new OrderNotFoundException("Order not found "+orderId+" not found");
        } else {
            orderDAO.deleteById(orderId);
        }
    }
}
