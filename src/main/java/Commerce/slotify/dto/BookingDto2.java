package Commerce.slotify.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDto2 {

    private List<SlotDto> slots;

    private FieldDto field;

    private UserDto2 userDto2;
}
