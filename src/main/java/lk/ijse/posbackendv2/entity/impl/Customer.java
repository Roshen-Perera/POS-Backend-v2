/*
 * Copyright © 2024. Roshen Perera
 */

package lk.ijse.posbackendv2.entity.impl;

import jakarta.persistence.*;
import lk.ijse.posbackendv2.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
public class Customer implements SuperEntity {
    @Id
    private String customerId;
    private String name;
    private String address;
    private String phone;
    @OneToMany(mappedBy = "customer")
    private List<Order> orders;
}