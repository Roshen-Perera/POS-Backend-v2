package lk.ijse.posbackendv2.controller;

import lk.ijse.posbackendv2.dto.impl.OrderDTO;
import lk.ijse.posbackendv2.dto.impl.OrderDTO;
import lk.ijse.posbackendv2.exception.DataPersistException;
import lk.ijse.posbackendv2.exception.OrderNotFoundException;
import lk.ijse.posbackendv2.services.OrderService;
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
@RequestMapping("api/v1/orders")
public class OrderController {
    Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    OrderService orderService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveOrder(@RequestBody OrderDTO orderDTO) {
        try {
            orderService.saveOrder(orderDTO);
            logger.info("Order saved");
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderDTO> getAllOrders(){
        return orderService.getAllOrders();
    }

    @DeleteMapping(value = "/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable ("orderId") String orderId){
        try {
            orderService.deleteOrder(orderId);
            logger.info("Order Deleted Successfully");

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (OrderNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
