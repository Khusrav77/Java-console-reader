package com.shh;


import com.shh.model.CommandType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidatorTest {

    private Validator validator = new Validator();

    @Test
    public void createTest() {
        // given
        String [] data = {"Create", "Hello"};

        // when
        CommandType result = validator.validate(data);

        // then
        assertDoesNotThrow(() -> validator.validate(data));
        assertEquals(CommandType.CREATE, result);
    }

    @Test
    public void getTest() {
        // given
        String [] data = {"Get", "5"};

        // when
        CommandType result = validator.validate(data);

        // then
        assertDoesNotThrow(() -> validator.validate(data));
        assertEquals(CommandType.GET, result);
    }

    @Test
    public void getAllTest() {
        // given
        String [] data = {"Get"};

        // when
        CommandType result = validator.validate(data);

        // then
        assertDoesNotThrow(() -> validator.validate(data));
        assertEquals(CommandType.GET, result);
    }

    @Test
    public void updateTest() {
        // given
        String [] data = {"Update", "5", "Hello"};

        // when
        CommandType result = validator.validate(data);

        // then
        assertDoesNotThrow(() -> validator.validate(data));
        assertEquals(CommandType.UPDATE, result);
    }

    @Test
    public void deleteTest() {
        // given
        String [] data = {"DELETE", "5"};

        // when
        CommandType result = validator.validate(data);

        // then
        assertDoesNotThrow(() -> validator.validate(data));
        assertEquals(CommandType.DELETE, result);

    }

    @Test
    public void deleteFails1Test() {
        // given
        String [] data = {"DELETE", "5", "abc"};

        // when
        Exception ex = assertThrows(
                IllegalArgumentException.class,
                () -> validator.validate(data)
        );

        // then
        assertEquals("Invalid number of arguments", ex.getMessage());

    }

    @Test
    public void deleteFails2Test() {
        // given
        String [] data = {"DELETE","asd"};

        // when
        Exception ex = assertThrows(
                IllegalArgumentException.class,
                () -> validator.validate(data)
        );

        // then
        assertEquals("ID must be a number", ex.getMessage());

    }


}
