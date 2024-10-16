package lk.ijse.posbackendv2.services.impl;

import jakarta.transaction.Transactional;
import lk.ijse.posbackendv2.customStatusCode.SelectedCustomerErrorStatus;
import lk.ijse.posbackendv2.dao.CustomerDAO;
import lk.ijse.posbackendv2.dto.CustomerStatus;
import lk.ijse.posbackendv2.dto.impl.CustomerDTO;
import lk.ijse.posbackendv2.entity.impl.Customer;
import lk.ijse.posbackendv2.exception.CustomerNotFoundException;
import lk.ijse.posbackendv2.services.CustomerService;
import lk.ijse.posbackendv2.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;
    @Autowired
    private Mapping mapping;

    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        Customer saveCustomer = customerDAO.save(mapping.toCustomerEntity(customerDTO));
        if (saveCustomer == null) {
            throw new CustomerNotFoundException("Customer not found");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> allCustomers = customerDAO.findAll();
        return mapping.asCustomerDTOList(allCustomers);
    }

    @Override
    public CustomerStatus getCustomer(String customerId) {
        if(customerDAO.existsById(customerId)){
            Customer selectedCustomer = customerDAO.getReferenceById(customerId);
            return mapping.toCustomerDTO(selectedCustomer);
        }else {
            return new SelectedCustomerErrorStatus(2, "Customer with productId " + customerId + " not found");
        }
    }

    @Override
    public void deleteCustomer(String customerId) {
        Optional<Customer> existedCustomer = customerDAO.findById(customerId);
        if(!existedCustomer.isPresent()){
            throw new CustomerNotFoundException("Customer with productId " + customerId + " not found");
        }else {
            customerDAO.deleteById(customerId);
        }
    }

    @Override
    public void updateCustomer(String customerId, CustomerDTO customerDTO) {
        Optional<Customer> customer = customerDAO.findById(customerId);
        if(customer.isPresent()) {
            customer.get().setCustomerId(customerDTO.getCustomerId());
            customer.get().setCustomerName(customerDTO.getCustomerName());
            customer.get().setCustomerAddress(customerDTO.getCustomerAddress());
            customer.get().setCustomerPhone(customerDTO.getCustomerPhone());
        }
    }
}