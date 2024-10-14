package lk.ijse.posbackendv2.util;

import lk.ijse.posbackendv2.dto.impl.CustomerDTO;
import lk.ijse.posbackendv2.dto.impl.OrderDTO;
import lk.ijse.posbackendv2.dto.impl.ProductDTO;
import lk.ijse.posbackendv2.entity.impl.Customer;
import lk.ijse.posbackendv2.entity.impl.Order;
import lk.ijse.posbackendv2.entity.impl.Product;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {

    @Autowired
    private ModelMapper modelMapper;

    // Customer mapping
    public Customer toCustomerEntity(CustomerDTO customerDTO) {
        return modelMapper.map(customerDTO, Customer.class);
    }
    public CustomerDTO toCustomerDTO(Customer customer) {
        return modelMapper.map(customer, CustomerDTO.class);
    }
    public List<CustomerDTO> asCustomerDTOList(List<Customer> customerEntities) {
        return modelMapper.map(customerEntities, new TypeToken<List<CustomerDTO>>() {}.getType());
    }

    // Product mapping
    public ProductDTO toProductDTO(Product product) {
        return modelMapper.map(product, ProductDTO.class);
    }
    public Product toProductEntity(ProductDTO productDTO) {
        return modelMapper.map(productDTO, Product.class);
    }
    public List<ProductDTO> asProductDTOList(List<Product> productEntities) {
        return modelMapper.map(productEntities, new TypeToken<List<ProductDTO>>() {}.getType());
    }

    // Order mapping
    public OrderDTO toOrderDTO(Order order) {
        return modelMapper.map(order, OrderDTO.class);
    }
    public Order toOrderEntity(OrderDTO orderDTO) {
        return modelMapper.map(orderDTO, Order.class);
    }
    public List<OrderDTO> asOrderDTOList(List<Order> orderEntities) {
        return modelMapper.map(orderEntities, new TypeToken<List<OrderDTO>>() {}.getType());
    }
}
