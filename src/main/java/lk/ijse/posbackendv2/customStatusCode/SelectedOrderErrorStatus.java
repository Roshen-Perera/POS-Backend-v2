package lk.ijse.posbackendv2.customStatusCode;

import lk.ijse.posbackendv2.dto.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SelectedOrderErrorStatus implements OrderStatus {
    private int statusCode;
    private String statusMessage;
}
