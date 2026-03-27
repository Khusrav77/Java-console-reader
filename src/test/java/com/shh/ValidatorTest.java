package com.shh;

import com.shh.model.Command;
import com.shh.model.CommandType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidatorTest {

    private Validator validator = new Validator();

    @Test
    public void deleteIsOkTest() {
        // given
        String [] data = {"DELETE 5"};

        assertDoesNotThrow(() -> validator.validate(data));

    }

    @Test
    public void deleteFails1Test() {
        // given
        String [] data = {"DELETE 5 abc"};

        Exception ex = assertThrows(
                IllegalArgumentException.class,
                () -> validator.validate(data)
        );

        assertEquals("abc", ex.getMessage());

    }

    @Test
    public void deleteFails2Test() {

        String [] data = {"DELETE","asd"};

        Exception ex = assertThrows(
                IllegalArgumentException.class,
                () -> validator.validate(data)
        );

        assertEquals("wrong id", ex.getMessage());

    }



}
