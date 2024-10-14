package lk.ijse.posbackendv2.controller;

import lk.ijse.posbackendv2.dto.ProductStatus;
import lk.ijse.posbackendv2.dto.impl.ProductDTO;
import lk.ijse.posbackendv2.exception.DataPersistException;
import lk.ijse.posbackendv2.exception.ProductNotFoundException;
import lk.ijse.posbackendv2.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("api/v1/products")
public class ProductController {
    Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    ProductService productService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> save(
            @RequestPart("id") String id,
            @RequestPart("name") String name,
            @RequestPart("type") String type,
            @RequestPart("qty") String qty,
            @RequestPart("price") String price
    ){
        try {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setProductId(id);
            productDTO.setProductName(name);
            productDTO.setProductType(type);
            productDTO.setProductQty(Integer.parseInt(qty));
            productDTO.setProductPrice(Double.parseDouble(price));
            logger.info("Product Saved Successfully");
            productService.saveProduct(productDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductDTO> getAllProducts(){
        logger.info("Product List fetched Successfully");
        return productService.getAllProducts();
    }

    @GetMapping(value = "/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductStatus getSelectedProducts(@PathVariable("productId") String id){
        logger.info("Product fetched Successfully");
        return productService.getProduct(id);
    }

    @DeleteMapping(value = "/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable ("productId") String productId){
        try {
            logger.info("Product Deleted Successfully");
            productService.deleteProduct(productId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (ProductNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PatchMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> update(
            @RequestPart("id") String id,
            @RequestPart("name") String name,
            @RequestPart("type") String type,
            @RequestPart("qty") String qty,
            @RequestPart("price") String price
    ){
        try {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setProductId(id);
            productDTO.setProductName(name);
            productDTO.setProductType(type);
            productDTO.setProductQty(Integer.parseInt(qty));
            productDTO.setProductPrice(Double.parseDouble(price));
            productService.saveProduct(productDTO);
            logger.info("Product Updated Successfully");
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
