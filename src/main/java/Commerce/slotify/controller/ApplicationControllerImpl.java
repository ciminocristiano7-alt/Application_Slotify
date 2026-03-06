package Commerce.slotify.controller;

import Commerce.slotify.dto.ResponseDto;
import Commerce.slotify.dto.UserDto;
import Commerce.slotify.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationControllerImpl implements ApplicationController {

    @Autowired
    private ApplicationService service;

    @Override
    public ResponseEntity<UserDto> findUserByPrenotation(Long bookingId) {
        return service.findUserByBookingId(bookingId);
    }

    @Override
    public ResponseEntity<ResponseDto> createUser(UserDto userDto) {
        return service.createUser(userDto);
    }


}