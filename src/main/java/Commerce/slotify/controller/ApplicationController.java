package Commerce.slotify.controller;
import Commerce.slotify.dto.ResponseDto;
import Commerce.slotify.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/slotify")
public interface ApplicationController {


    @GetMapping("/get-user-by-prenotation")
    ResponseEntity<UserDto> findUserByBooking(@RequestParam Long bookingId);

    @PostMapping("/create/user")
    ResponseEntity<ResponseDto> createUser(@RequestBody UserDto userDto);

    @GetMapping("/get-user-by-user-id/{user-id}")
    ResponseEntity<UserDto> findUserByUserId(@PathVariable("user-id") Long id);

    @PutMapping("/update-user/{user-id}")
    ResponseEntity<ResponseDto> updateUser(@PathVariable("user-id") Long id, @RequestBody UserDto userDto);


}
