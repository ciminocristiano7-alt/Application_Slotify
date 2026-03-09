package Commerce.slotify.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotEmpty;
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
    @NotEmpty
    private List<SlotDto> slots;

    @NotNull
    @NotEmpty
    private FieldDto field;

    @NotNull
    @NotEmpty
    private UserDto2 userDto2;

}
