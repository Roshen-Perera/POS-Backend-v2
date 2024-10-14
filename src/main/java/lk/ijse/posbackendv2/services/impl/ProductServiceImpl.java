package lk.ijse.posbackendv2.services.impl;

import jakarta.transaction.Transactional;
import lk.ijse.posbackendv2.customStatusCode.SelectedProductErrorStatus;
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
import java.util.Optional;

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
        List<Product> productList = productDAO.findAll();
        return mapping.asProductDTOList(productList);
    }

    @Override
    public ProductStatus getProduct(String productId) {
        if (productDAO.existsById(productId)) {
            Product selectedProduct = productDAO.getReferenceById(productId);
            return mapping.toProductDTO(selectedProduct);
        }else {
            return new SelectedProductErrorStatus(2, "Product with productId " + productId + " not found");
        }
    }


    @Override
    public void deleteProduct(String productId) {
        Optional<Product> existedProduct = productDAO.findById(productId);
        if (!existedProduct.isPresent()) {
            throw new ProductNotFoundException("Product with productId " + productId + " not found");
        }else {
            productDAO.deleteById(productId);
        }
    }

    @Override
    public void updateProduct(String productId, ProductDTO productDTO) {
        Optional<Product> product = productDAO.findById(productId);
        if(product.isPresent()) {
            product.get().setProductId(productDTO.getProductId());
            product.get().setProductName(productDTO.getProductName());
            product.get().setProductType(productDTO.getProductType());
            product.get().setProductQty(productDTO.getProductQty());
            product.get().setProductPrice(productDTO.getProductPrice());
        }
    }
}
