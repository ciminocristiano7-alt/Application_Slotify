package Commerce.slotify.service;

import Commerce.slotify.dto.UserDto;
import Commerce.slotify.entity.UserEntity;
import Commerce.slotify.mapper.UserMapper;
import Commerce.slotify.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        LOGGER.info("Saving user {}", user);
        userRepository.save(user);
    }
}
