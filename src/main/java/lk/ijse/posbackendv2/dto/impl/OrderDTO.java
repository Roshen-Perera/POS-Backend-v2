package lk.ijse.posbackendv2.dto.impl;

import jakarta.persistence.*;
import lk.ijse.posbackendv2.dto.OrderStatus;
import lk.ijse.posbackendv2.entity.impl.Customer;
import lk.ijse.posbackendv2.entity.impl.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "orders")
public class OrderDTO implements OrderStatus {
    @Id
    private String orderId;
    private String customerId;
    private String customerName;
    private String productId;
    private String productName;
    private String productType;
    private int productQTYNeeded;
    private double productPrice;
    private double productTotal;
}
