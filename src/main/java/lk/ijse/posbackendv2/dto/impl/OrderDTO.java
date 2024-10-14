package lk.ijse.posbackendv2.dto.impl;


import lk.ijse.posbackendv2.dto.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDTO implements OrderStatus {
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
