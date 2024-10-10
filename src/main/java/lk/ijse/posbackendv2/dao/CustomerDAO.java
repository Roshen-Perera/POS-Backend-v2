package lk.ijse.posbackendv2.dao;

import lk.ijse.posbackendv2.entity.impl.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDAO extends JpaRepository <Customer, String> {
    
}
