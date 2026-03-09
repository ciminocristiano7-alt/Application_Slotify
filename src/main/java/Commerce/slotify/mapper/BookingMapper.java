package Commerce.slotify.mapper;

import Commerce.slotify.dto.BookingDto;
import Commerce.slotify.dto.BookingDto2;
import Commerce.slotify.entity.BookingEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;


@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface BookingMapper {


    BookingEntity dtoToEntity(BookingDto bookingDto);


    BookingDto entityToDto(BookingEntity booking);


    BookingEntity Dto2ToEntity(BookingDto2 bookingDto2);
}
