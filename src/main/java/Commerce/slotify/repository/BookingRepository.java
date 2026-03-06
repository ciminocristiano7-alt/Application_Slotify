package Commerce.slotify.repository;

import Commerce.slotify.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository <BookingEntity,Long> {

    Optional<BookingEntity> findById(Long id);
}
