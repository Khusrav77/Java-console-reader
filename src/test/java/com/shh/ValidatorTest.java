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
        String input = "DELETE 5";

        assertDoesNotThrow(() -> validator.validate(input));

    }

    @Test
    public void deleteFails1Test() {
        // given
        String input = "DELETE 5 ssdsd";

        Exception ex = assertThrows(
                IllegalArgumentException.class,
                () -> validator.validate(input)
        );

        assertEquals("abc", ex.getMessage());

    }

    @Test
    public void deleteFails2Test() {

        String input = "DELETE asd";

        Exception ex = assertThrows(
                IllegalArgumentException.class,
                () -> validator.validate(input)
        );

        assertEquals("wrong id", ex.getMessage());

    }



}
