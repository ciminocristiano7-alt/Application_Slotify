package Commerce.slotify.service;

import Commerce.slotify.dto.UserDto;
import Commerce.slotify.entity.UserEntity;
import Commerce.slotify.exception.MappingException;
import Commerce.slotify.mapper.UserMapper;
import Commerce.slotify.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper mapper;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Transactional
    @Override
    public void saveUser(UserDto userDto) {
        UserEntity user = mapper.dtoToEntity(userDto);

        if (user == null) {
            throw new MappingException();
        }
        userRepository.save(user);
        LOGGER.info("Saving user {}", user);

    }
}
