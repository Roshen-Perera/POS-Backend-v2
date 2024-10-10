package lk.ijse.POSBackendV2.services;

import lk.ijse.POSBackendV2.dto.CustomerStatus;
import lk.ijse.POSBackendV2.dto.impl.CustomerDTO;

import java.util.List;

public interface CustomerService {
    void saveCustomer(CustomerDTO customerDTO);
    List<CustomerDTO> getAllCustomers();
    CustomerStatus getCustomer(String customerId);
    void deleteCustomer(String customerId);
    void updateCustomer(String customerId, CustomerDTO customerDTO);
}