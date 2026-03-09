package Commerce.slotify.mapper;

import Commerce.slotify.dto.SlotDto;
import Commerce.slotify.entity.SlotEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface SlotMapper {

    SlotEntity dtoToEntity(SlotDto slotDto);

    SlotDto entityToDto(SlotEntity slot);

}
