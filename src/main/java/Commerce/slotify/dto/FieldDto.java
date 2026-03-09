package Commerce.slotify.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FieldDto {

    private String filedType;
    private int startTime;
    private int endTime;
}
