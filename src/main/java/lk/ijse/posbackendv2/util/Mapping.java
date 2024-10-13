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

    public Customer toCustomerEntity(CustomerDTO customerDto){
        return modelMapper.map(customerDto, Customer.class);
    }
    public CustomerDTO toCustomerDto(Customer customerEntity){
        return modelMapper.map(customerEntity, CustomerDTO.class);
    }
    public List<CustomerDTO> asCustomerDTO(List<Customer> customerEntityList){
        return modelMapper.map(customerEntityList, new TypeToken<List<CustomerDTO>>(){}.getType());
    }

    public Product toProductEntity(ProductDTO productDto){
        return modelMapper.map(productDto, Product.class);
    }

    public ProductDTO toProductDto(Product productEntity){
        return modelMapper.map(productEntity, ProductDTO.class);
    }

    public List<ProductDTO> asProductDTO(List<Product> productEntityList){
        return modelMapper.map(productEntityList, new TypeToken<List<ProductDTO>>(){}.getType());
    }

    public Order toOrderEntity(OrderDTO orderDto){
        return modelMapper.map(orderDto, Order.class);
    }

    public OrderDTO toOrderDto(Order orderEntity){
        return modelMapper.map(orderEntity, OrderDTO.class);
    }

    public List<OrderDTO> asOrderDTO(List<Order> orderEntityList){
        return modelMapper.map(orderEntityList, new TypeToken<List<OrderDTO>>(){}.getType());
    }

}