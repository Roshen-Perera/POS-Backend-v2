package lk.ijse.posbackendv2.controller;

import lk.ijse.posbackendv2.dto.CustomerStatus;
import lk.ijse.posbackendv2.dto.impl.CustomerDTO;
import lk.ijse.posbackendv2.exception.CustomerNotFoundException;
import lk.ijse.posbackendv2.exception.DataPersistException;
import lk.ijse.posbackendv2.services.CustomerService;
import org.modelmapper.ModelMapper;
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
@RequestMapping("api/v1/customers")
public class CustomerController {
    static Logger logger =  LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    CustomerService customerService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> save(
        @RequestPart("customerId") String customerId,
        @RequestPart("name") String name,
        @RequestPart("address") String address,
        @RequestPart("phone") String phone
    )
    {
        try {
            var buildCustomerDTO = new CustomerDTO();
            buildCustomerDTO.setId(customerId);
            buildCustomerDTO.setName(name);
            buildCustomerDTO.setAddress(address);
            buildCustomerDTO.setPhone(phone);
            customerService.saveCustomer(buildCustomerDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CustomerDTO> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping(value = "/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerStatus getSelectedCustomer(@PathVariable ("customerId") String customerId){
        return customerService.getCustomer(customerId);
    }

    @DeleteMapping(value = "/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("customerId") String customerId){
        try {
            customerService.deleteCustomer(customerId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (CustomerNotFoundException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> update(
            @RequestPart("customerId") String customerId,
            @RequestPart("name") String name,
            @RequestPart("address") String address,
            @RequestPart("phone") String phone
    )
    {
        try {
            var buildCustomerDTO = new CustomerDTO();
            buildCustomerDTO.setId(customerId);
            buildCustomerDTO.setName(name);
            buildCustomerDTO.setAddress(address);
            buildCustomerDTO.setPhone(phone);
            customerService.saveCustomer(buildCustomerDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
