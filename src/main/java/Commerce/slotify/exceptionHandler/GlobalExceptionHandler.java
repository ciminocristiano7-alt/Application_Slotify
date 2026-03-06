package Commerce.slotify.exceptionHandler;

import Commerce.slotify.dto.exception.ErrorResponseDto;
import Commerce.slotify.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotPresentException.class)
    public ResponseEntity<ErrorResponseDto> idNotPresentBadRequest(EntityNotPresentException e){
        ErrorResponseDto errorBody = new ErrorResponseDto(
                "Bad Request",
                400,
                e.getMessage(),
                LocalDateTime.now()
        );
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorBody);
    }

    @ExceptionHandler(NoUserForBookingException.class)
    public ResponseEntity<ErrorResponseDto> noUserForPrenotation(NoUserForBookingException e){
        ErrorResponseDto errorBody = new ErrorResponseDto(
                "Bad Request",
                400,
                e.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorBody);
    }

    @ExceptionHandler(MappingException.class)
    public ResponseEntity<ErrorResponseDto> errorDuringElaboration(MappingException e) {
        ErrorResponseDto errorBody = new ErrorResponseDto(
                "Internal Server Error",
                500,
                e.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorBody);
    }

        @ExceptionHandler(InvalidBodyException.class)
        public ResponseEntity<ErrorResponseDto> invalidBodyException(InvalidBodyException e){
            ErrorResponseDto errorBody = new ErrorResponseDto(
                    "Bad Request",
                    400,
                    e.getMessage(),
                    LocalDateTime.now()
            );
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorBody);
        }

    @ExceptionHandler(QueryException.class)
    public ResponseEntity<ErrorResponseDto> invalidBodyException(QueryException e){
        ErrorResponseDto errorBody = new ErrorResponseDto(
                "Intenal Server Errror",
                500,
                e.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorBody);
    }
    }


