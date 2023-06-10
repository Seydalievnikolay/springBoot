package ru.skypro.lessons.springboot.EmployeeApplication.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.skypro.lessons.springboot.EmployeeApplication.exception.BadRequestException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
@RequiredArgsConstructor
@Slf4j
public class GlobalExceptionHandler {
    private final ObjectMapper objectMapper;

    @ExceptionHandler(value = BadRequestException.class)
    public void handleException(Exception exception, HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse) throws IOException {
        httpServletResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        httpServletResponse.setContentType("application/json");
        httpServletResponse.getWriter().write(objectMapper.writeValueAsString(new HashMap<>() {
            {
                put("massage", exception.getMessage());
                put("type", exception.getClass());
            }
        }));
        log.error(exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handle(MethodArgumentNotValidException methodArgumentNotValidException) {
        return ResponseEntity.badRequest().body(
                methodArgumentNotValidException.getFieldErrors().stream()
                        .map(fieldError -> Map.of(
                                fieldError.getField(),
                                String.format("%s. актуальное значение: %s",
                                        fieldError.getDefaultMessage(),
                                        fieldError.getRejectedValue())
                        ))
                        .collect(Collectors.toList())
        );
    }
}
