package Commerce.slotify.mapper;

import Commerce.slotify.dto.BookingDto;
import Commerce.slotify.dto.BookingDto2;
import Commerce.slotify.entity.BookingEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.awt.print.Book;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface BookingMapper {

    @Mapping(source = "userDto2", target = "user")
    @Mapping(source = "field", target = "field")
    BookingEntity dtoToEntity(BookingDto bookingDto);

    @Mapping(source = "user", target = "userDto2")
    BookingDto entityToDto(BookingEntity booking);

    @Mapping(source = "user", target = "userDto2")
    BookingDto2 entityToDto2(BookingEntity booking);

    @Mapping(source = "userDto2", target = "user")
    BookingEntity Dto2ToEntity(BookingDto2 bookingDto2);
}
