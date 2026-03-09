package Commerce.slotify.service;

import Commerce.slotify.dto.*;
import Commerce.slotify.exception.*;
import Commerce.slotify.entity.BookingEntity;
import Commerce.slotify.entity.UserEntity;
import Commerce.slotify.mapper.BookingMapper;
import Commerce.slotify.mapper.UserMapper;
import Commerce.slotify.repository.BookingRepository;
import Commerce.slotify.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private BookingMapper bookingMapper;


    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationServiceImpl.class);

    @Override
    public ResponseEntity<UserDto> findUserByBookingId(Long id) {
        LOGGER.info("inzializiating process");

        BookingEntity booking = bookingRepository.findById(id)
                .orElseThrow(EntityNotPresentException::new);

        UserEntity user = booking.getUser();

        if (user == null) {
            throw new NoUserForBookingException();
        }
        try {
            return ResponseEntity.ok(userMapper.entityToDto(user));

        } catch (MappingException e) {
            LOGGER.error("Error parsing user", e);
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

    @Override
    public ResponseEntity<UserDto> findUserByUserId(Long id) {

        if (id == null) {
            throw new MissingParamException();
        }
        if (!userRepository.existsById(id)) {
            throw new EntityNotPresentException();
        }
        UserDto userDto = new UserDto();
        UserEntity user = userRepository.findById(id).orElseThrow(() ->
                new QueryException("no user found for this id: " + id));
        if (user != null) {
            userDto = userMapper.entityToDto(user);
        }
        return ResponseEntity.ok(userDto);
    }

    @Transactional
    @Override
    public ResponseEntity<ResponseDto> updateUser(Long id, UserDto userDto) {

        if (userDto == null) {
            throw new InvalidBodyException();
        }

        if (!userRepository.existsById(id)) {
            throw new EntityNotPresentException();
        }

        UserEntity user = userRepository.findById(id).orElseThrow(()->
                new QueryException("no user found for this id: " + id));
        userMapper.updateEntityFromDto(userDto, user);
        userRepository.save(user);
        return ResponseEntity.ok(new ResponseDto("User updated"));
    }

    @Override
    public ResponseEntity<ResponseDto> deleteUser(Long id) {
        if (id == null){
            throw new MissingParamException();
        }
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotPresentException();
        } catch (DataAccessException e) {
            LOGGER.error("Error deleting user with id: {}", id, e);
            throw new QueryException();
        }
        return ResponseEntity.ok(new ResponseDto("user eliminated with success"));
    }

    @Override
    public ResponseEntity<BookingDto> findBooking(Long id) {
        if (id == null){
            throw new MissingParamException();
        }
            BookingEntity bookingEntity = bookingRepository.findById(id).orElseThrow(() ->
                    new QueryException("no user found for this id: " + id));

        BookingDto bookingDto = bookingMapper.entityToDto(bookingEntity);
        return ResponseEntity.ok(bookingDto);
    }

    @Override
    public ResponseEntity<ResponseDto> createBooking(BookingDto bookingDto) {
        if (bookingDto == null){
            throw new InvalidBodyException();
        }

        BookingEntity bookingEntity = bookingMapper.dtoToEntity(bookingDto);
        if (bookingEntity == null){
            throw new MappingException();
        }
        try {
            bookingRepository.save(bookingEntity);

        }catch (QueryException e){
            LOGGER.error("error during save" + e);
        }
        return ResponseEntity.ok(new ResponseDto("booking created with succes"));
    }

    @Override
    public ResponseEntity<ResponseDto> updateBooking(BookingDto2 bookingDto2) {
        if (bookingDto2 == null){
            throw new InvalidBodyException();
        }

        return null;
    }


}
