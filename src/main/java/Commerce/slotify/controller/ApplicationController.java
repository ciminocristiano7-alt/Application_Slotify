package Commerce.slotify.controller;

import Commerce.slotify.dto.*;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/slotify")
public interface ApplicationController {


    @GetMapping("/get-user-by-booking")
    ResponseEntity<UserDto> findUserByBooking(@RequestParam Long bookingId);

    @PostMapping("/create/user")
    ResponseEntity<ResponseDto> createUser(@RequestBody UserDto userDto);

    @GetMapping("/get-user-by-user-id/{user-id}")
    ResponseEntity<UserDto> findUserByUserId(@PathVariable("user-id") Long id);

    @PutMapping("/update-user/{user-id}")
    ResponseEntity<ResponseDto> updateUser(@PathVariable("user-id") Long id, @RequestBody UserDto userDto);

    @DeleteMapping("/delete-user/{user-id}")
    ResponseEntity<ResponseDto> deleteUser(@PathVariable("user-id") Long id);

    @GetMapping("/get-booking-by-id/{booking-id}")
    ResponseEntity<BookingDto> findBooking(@PathVariable("booking-id") Long id);

    @PostMapping("/create-booking")
    ResponseEntity<ResponseDto> createBooking(@RequestBody @Valid BookingDto bookingDto);

    @PutMapping("/update-booking")
    ResponseEntity<ResponseDto> updateBooking(@RequestBody BookingDto2 bookingDto2);
}
