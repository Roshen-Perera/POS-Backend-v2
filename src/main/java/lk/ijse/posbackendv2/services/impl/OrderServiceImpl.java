package lk.ijse.posbackendv2.services.impl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lk.ijse.posbackendv2.dao.OrderDAO;
import lk.ijse.posbackendv2.dao.ProductDAO;
import lk.ijse.posbackendv2.dto.ProductStatus;
import lk.ijse.posbackendv2.dto.impl.OrderDTO;
import lk.ijse.posbackendv2.dto.impl.ProductDTO;
import lk.ijse.posbackendv2.entity.impl.Order;
import lk.ijse.posbackendv2.exception.DataPersistException;
import lk.ijse.posbackendv2.exception.OrderNotFoundException;
import lk.ijse.posbackendv2.services.OrderService;
import lk.ijse.posbackendv2.services.ProductService;
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
    private ProductService productService;

    @Autowired
    private Mapping mapping;

    @Override
    public void saveOrder(OrderDTO orderDTO) {
        Order saveOrder = orderDAO.save(mapping.toOrderEntity(orderDTO));
        if (saveOrder == null) {
            throw new DataPersistException("Order not found");
        } else{
            var productDTO = (ProductDTO) productService.getProduct(orderDTO.getProductId());
            int newQty = productDTO.getProductQty() - orderDTO.getProductQTYNeeded();
            if (newQty < 0) {
                throw new IllegalArgumentException("Insufficient Qty");
            }
            productDTO.setProductQty(newQty);
            productService.updateProduct(orderDTO.getProductId(), productDTO);
        }
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        List<Order> allOrders = orderDAO.findAll();
        return mapping.asOrderDTOList(allOrders);
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
