package lk.ijse.posbackendv2.dto.impl;

import lk.ijse.posbackendv2.dto.ProductStatus;
import lk.ijse.posbackendv2.entity.impl.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO implements ProductStatus {
    private String productId;
    private String productName;
    private String productType;
    private int productQty;
    private double productPrice;
}
