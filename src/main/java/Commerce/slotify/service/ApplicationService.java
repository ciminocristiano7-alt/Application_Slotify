package Commerce.slotify.service;

import Commerce.slotify.dto.ResponseDto;
import Commerce.slotify.dto.UserDto;
import org.springframework.http.ResponseEntity;

public interface ApplicationService {

    ResponseEntity<UserDto> findUserByBookingId (Long id);

    ResponseEntity<ResponseDto> createUser(UserDto userDto);

    ResponseEntity<UserDto> findUserByUserId(Long id);

    ResponseEntity<ResponseDto> updateUser(Long id, UserDto userDto);

    ResponseEntity<ResponseDto> deleteUser(Long id);
}
