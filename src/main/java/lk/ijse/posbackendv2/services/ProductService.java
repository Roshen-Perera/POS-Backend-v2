package lk.ijse.posbackendv2.services;

import lk.ijse.posbackendv2.dto.ProductStatus;
import lk.ijse.posbackendv2.dto.impl.ProductDTO;

import java.util.List;

public interface ProductService {
    void saveProduct(ProductDTO productDTO);
    List<ProductDTO> getAllProducts();
    ProductStatus getProduct(String productId);
    void deleteProduct(String productId);
    void updateProduct(String productId, ProductDTO productDTO);
}
