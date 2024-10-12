package lk.ijse.posbackendv2.dto.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    String id;
    String name;
    String type;
    String qty;
    String price;
}
