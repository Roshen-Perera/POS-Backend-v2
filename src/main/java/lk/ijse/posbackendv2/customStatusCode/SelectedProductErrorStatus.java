package lk.ijse.posbackendv2.customStatusCode;

import lk.ijse.posbackendv2.dto.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelectedProductErrorStatus implements ProductStatus {
    private int statusCode;
    private String statusMessage;
}
