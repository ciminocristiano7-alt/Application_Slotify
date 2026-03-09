package Commerce.slotify.controller;

import Commerce.slotify.dto.*;
import Commerce.slotify.service.ApplicationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationControllerImpl implements ApplicationController {

    @Autowired
    private ApplicationService service;

    @Override
    public ResponseEntity<UserDto> findUserByBooking(Long bookingId) {
        return service.findUserByBookingId(bookingId);
    }

    @Override
    public ResponseEntity<ResponseDto> createUser(UserDto userDto) {
        return service.createUser(userDto);
    }

    @Override
    public ResponseEntity<UserDto> findUserByUserId(Long id) {
        return service.findUserByUserId(id);
    }

    @Override
    public ResponseEntity<ResponseDto> updateUser(Long id, UserDto userDto) {
        return service.updateUser(id, userDto);
    }

    @Override
    public ResponseEntity<ResponseDto> deleteUser(Long id) {
        return service.deleteUser(id);
    }

    @Override
    public ResponseEntity<BookingDto> findBooking(Long id) {
        return service.findBooking(id);
    }

    @Override
    public ResponseEntity<ResponseDto> createBooking(BookingDto bookingDto) {
        return service.createBooking(bookingDto);
    }

    @Override
    public ResponseEntity<ResponseDto> updateBooking(BookingDto2 bookingDto2) {
        return service.updateBooking(bookingDto2);
    }

    @Override
    public ResponseEntity<ResponseDto> deleteBooking(Long id) {
        return service.deleteBooking(id);
    }

}