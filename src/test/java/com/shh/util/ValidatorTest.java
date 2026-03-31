package com.shh.util;


import com.shh.model.CommandType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidatorTest {

    private final Validator validator = new Validator();

    // ========== CREATE TEST ===============
    @Test
    public void createTest() {
        // given
        String  input = "Create Hello";

        // when
        CommandType result = validator.validate(input);

        // then
        assertEquals(CommandType.CREATE, result);
    }

    @Test
    public void createIsNotValueTest() {
        // given
        String input = "Create";

        // when
        Exception ex = assertThrows(
                IllegalArgumentException.class,
                () -> validator.validate(input));

        //then
        assertEquals("Invalid number of arguments for CREATE command", ex.getMessage());
    }

    // ========== GET TEST ===============
    @Test
    public void getTest() {
        // given
        String  input = "Get 5";

        // when
        CommandType result = validator.validate(input);

        // then
        assertDoesNotThrow(() -> validator.validate(input));
        assertEquals(CommandType.GET, result);
    }

    @Test
    public void getInvalidIdTest(){
         // given
        String input = "Get abc";

        // when
        Exception ex = assertThrows(
                IllegalArgumentException.class,
                () -> validator.validate(input));

        // then
        assertEquals("ID must be a number", ex.getMessage());
    }

    // ========== GET ALL TEST ===============
    @Test
    public void getAllTest() {
        // given
        String  input = "Get";

        // when
        CommandType result = validator.validate(input);

        // then
        assertDoesNotThrow(() -> validator.validate(input));
        assertEquals(CommandType.GET, result);
    }

    // ========== UPDATE TEST ===============
    @Test
    public void updateTest() {
        // given
        String data = "Update 5 Hello";

        // when
        CommandType result = validator.validate(data);

        // then
        assertDoesNotThrow(() -> validator.validate(data));
        assertEquals(CommandType.UPDATE, result);
    }

    @Test
    public void invalidUpdateTest() {
        // given
        String input  = "Update";

        // when
        Exception ex = assertThrows(
                IllegalArgumentException.class,
                () -> validator.validate(input));

        // then
        assertEquals("Invalid number of arguments for UPDATE command", ex.getMessage());

    }

    @Test
    public void invalidUpdateIdTest() {
        // given
        String input = "Update abc Hello";

        // when
        Exception ex = assertThrows(
                IllegalArgumentException.class,
                () -> validator.validate(input));

        // then
        assertEquals("ID must be a number", ex.getMessage());
    }

    // ========== DELETE TEST ===============
    @Test
    public void deleteTest() {
        // given
        String  data = "DELETE 5";

        // when
        CommandType result = validator.validate(data);

        // then
        assertDoesNotThrow(() -> validator.validate(data));
        assertEquals(CommandType.DELETE, result);

    }

    @Test
    public void deleteShouldFailWhenTooManyArguments() {
        // given
        String data = "DELETE 5 abc";

        // when
        Exception ex = assertThrows(
                IllegalArgumentException.class,
                () -> validator.validate(data)
        );

        // then
        assertEquals("Invalid number of arguments for DELETE command", ex.getMessage());

    }

    @Test
    public void deleteShouldFailWhenIdIsNotNumber() {
        // given
        String data = "DELETE asd";

        // when
        Exception ex = assertThrows(
                IllegalArgumentException.class,
                () -> validator.validate(data)
        );

        // then
        assertEquals("ID must be a number", ex.getMessage());

    }


}
