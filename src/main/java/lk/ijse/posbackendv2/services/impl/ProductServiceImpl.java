package lk.ijse.posbackendv2.services.impl;

import jakarta.transaction.Transactional;
import lk.ijse.posbackendv2.dao.ProductDAO;
import lk.ijse.posbackendv2.dto.ProductStatus;
import lk.ijse.posbackendv2.dto.impl.ProductDTO;
import lk.ijse.posbackendv2.entity.impl.Product;
import lk.ijse.posbackendv2.exception.ProductNotFoundException;
import lk.ijse.posbackendv2.services.ProductService;
import lk.ijse.posbackendv2.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private Mapping mapping;

    @Override
    public void saveProduct(ProductDTO productDTO) {
        Product saveProduct = productDAO.save(mapping.toProductEntity(productDTO));
        if (saveProduct == null) {
            throw new ProductNotFoundException("Product not found");
        }
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return List.of();
    }

    @Override
    public ProductStatus getProduct(String productId) {
        return null;
    }

    @Override
    public void deleteProduct(String productId) {

    }

    @Override
    public void updateProduct(String productId, ProductDTO productDTO) {

    }
}
