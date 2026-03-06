package Commerce.slotify.dto;

import Commerce.slotify.entity.FieldEntity;
import Commerce.slotify.entity.SlotEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BookingDto {

    private List<SlotDto> slots;
    private Long fieldId;


}
