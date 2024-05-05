package com.example.distribuidora;

import com.example.distribuidora.service.ConversionDollarService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TestTRM {
    @InjectMocks
    private ConversionDollarService conversionDollarService;


    @Test
    void testKeyBad(){
        ResponseEntity<?> response = conversionDollarService.obtenerPrecioDollar();
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
