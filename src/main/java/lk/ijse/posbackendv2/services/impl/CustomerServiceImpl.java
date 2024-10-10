package lk.ijse.POSBackendV2.services.impl;

import jakarta.transaction.Transactional;
import lk.ijse.POSBackendV2.customStatusCode.SelectedCustomerErrorStatus;
import lk.ijse.POSBackendV2.services.CustomerService;
import lk.ijse.POSBackendV2.dao.CustomerDAO;
import lk.ijse.POSBackendV2.dto.CustomerStatus;
import lk.ijse.POSBackendV2.dto.impl.CustomerDTO;
import lk.ijse.POSBackendV2.entity.impl.Customer;
import lk.ijse.POSBackendV2.exception.CustomerNotFoundException;
import lk.ijse.POSBackendV2.services.CustomerService;
import lk.ijse.POSBackendV2.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return List.of();
    }

    @Override
    public CustomerStatus getCustomer(String customerId) {
        if(customerDAO.existsById(customerId)){
            Customer selectedCustomer = customerDAO.getReferenceById(customerId);
            return mapping.toCustomerDto(selectedCustomer);
        }else {
            return new SelectedCustomerErrorStatus(2, "Customer with id " + customerId + " not found");
        }
    }

    @Override
    public void deleteCustomer(String customerId) {

    }

    @Override
    public void updateCustomer(String customerId, CustomerDTO customerDTO) {

    }
}