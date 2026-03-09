package Commerce.slotify.service;

import Commerce.slotify.dto.BookingDto;
import Commerce.slotify.dto.ResponseDto;
import Commerce.slotify.dto.UserDto;
import Commerce.slotify.dto.UserDto2;
import org.springframework.http.ResponseEntity;

public interface ApplicationService {

    ResponseEntity<UserDto> findUserByBookingId (Long id);

    ResponseEntity<ResponseDto> createUser(UserDto userDto);

    ResponseEntity<UserDto> findUserByUserId(Long id);

    ResponseEntity<ResponseDto> updateUser(Long id, UserDto userDto);

    ResponseEntity<ResponseDto> deleteUser(Long id);

    ResponseEntity<BookingDto> findBooking(Long id);

    ResponseEntity<ResponseDto> createBooking(BookingDto bookingDto);

}
