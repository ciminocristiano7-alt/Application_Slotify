package Commerce.slotify.controller;

import Commerce.slotify.dto.ResponseDto;
import Commerce.slotify.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/application")
public interface ApplicationController {


    @GetMapping("/get/user/by/prenotation")
    ResponseEntity<UserDto> findUserByPrenotation(@RequestParam Long bookingId);

    @PostMapping("create/user")
    ResponseEntity<ResponseDto> createUser(@RequestBody UserDto userDto);

}
