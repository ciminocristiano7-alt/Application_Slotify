package Commerce.slotify.mapper;

import Commerce.slotify.dto.UserDto;
import Commerce.slotify.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface UserMapper {

    UserDto entityToDto(UserEntity user);

    UserEntity dtoToEntity(UserDto userDto);

    void updateEntityFromDto(UserDto userDto, @MappingTarget UserEntity user);

}
