package lk.ijse.posbackendv2.controller;

import lk.ijse.posbackendv2.dto.impl.ProductDTO;
import lk.ijse.posbackendv2.exception.DataPersistException;
import lk.ijse.posbackendv2.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            productDTO.setId(id);
            productDTO.setName(name);
            productDTO.setType(type);
            productDTO.setQty(qty);
            productDTO.setPrice(price);
            productService.saveProduct(productDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
