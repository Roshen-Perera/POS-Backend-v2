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
@Table(name = "product")
public class Product implements SuperEntity {
    @Id
    private String productId;
    private String name;
    private String type;
    private int qty;
    private double price;
    @OneToMany(mappedBy = "product")
    private List<Order> orders;
}
