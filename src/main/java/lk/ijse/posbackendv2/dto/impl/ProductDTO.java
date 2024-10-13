package lk.ijse.posbackendv2.dto.impl;

import lk.ijse.posbackendv2.dto.ProductStatus;
import lk.ijse.posbackendv2.entity.impl.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO implements ProductStatus {
    String id;
    String name;
    String type;
    int qty;
    double price;
}
