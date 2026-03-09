package Commerce.slotify.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BookingDto {

    @Nullable
    private String bookingNumber;

    @NotNull
    private List<SlotDto> slots;

    @NotNull
    private FieldDto field;

    @NotNull
    private UserDto2 userDto2;

}
