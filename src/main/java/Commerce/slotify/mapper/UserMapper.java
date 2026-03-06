package Commerce.slotify.mapper;

import Commerce.slotify.dto.UserDto;
import Commerce.slotify.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto entityToDto(UserEntity user);

    UserEntity dtoToEntity(UserDto userDto);



}
