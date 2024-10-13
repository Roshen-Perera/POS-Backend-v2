/*
 * Copyright © 2024. Roshen Perera
 */

package lk.ijse.posbackendv2.dto.impl;
import lk.ijse.posbackendv2.dto.CustomerStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO implements CustomerStatus {
    private String id;
    private String name;
    private String address;
    private String phone;
    private List<OrderDTO> orders;
}
