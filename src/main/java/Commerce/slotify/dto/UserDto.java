package Commerce.slotify.dto;

import Commerce.slotify.entity.BookingEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    @NotNull(message = "username is a required parameter")
    @JsonProperty("username")
    private String username;

    private List<BookingEntity> bookingList;


}
