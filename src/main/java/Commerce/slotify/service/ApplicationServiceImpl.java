package Commerce.slotify.service;

import Commerce.slotify.dto.ResponseDto;
import Commerce.slotify.exception.*;
import Commerce.slotify.dto.UserDto;
import Commerce.slotify.entity.BookingEntity;
import Commerce.slotify.entity.UserEntity;
import Commerce.slotify.mapper.UserMapper;
import Commerce.slotify.repository.BookingRepository;
import Commerce.slotify.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper mapper;

    @Autowired
    private UserService userService;

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationServiceImpl.class);

    @Override
    public ResponseEntity<UserDto> findUserByBookingId(Long id) {

        BookingEntity booking = bookingRepository.findById(id)
                .orElseThrow(EntityNotPresentException::new);

        UserEntity user = booking.getUser();

        if (user == null) {
            throw new NoUserForBookingException();
        }

        try {
            return ResponseEntity.ok(mapper.entityToDto(user));

        } catch (MappingException e) {
            LOGGER.error("Error creating UserDto", e);
            throw e;
        }
    }

    @Override
    public ResponseEntity<ResponseDto> createUser(UserDto userDto) {

        LOGGER.info("Initializing user creation process");

        if (userDto == null) {
            throw new InvalidBodyException();
        }
        userService.saveUser(userDto);
        ResponseDto responseDto = new ResponseDto("Entity successfully created");

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(responseDto);
    }
}
