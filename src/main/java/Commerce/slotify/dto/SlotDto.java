package Commerce.slotify.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SlotDto {

    private int startTime;
    private int endTime;
    private Long idBooking;

}
