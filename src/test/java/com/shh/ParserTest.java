package com.shh;

import com.shh.model.Command;
import com.shh.model.CommandType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ParserTest {

    private final Validator validator = new Validator();
    private final Parser parser = new Parser(validator);

    // ========== CREATE TEST ===============
    @Test
    public void createTest() {
       // given
       String input = "Create hello";

       // when
       Command result = parser.parse(input);

       // then
       assertEquals(CommandType.CREATE, result.getType());
       assertNull(result.getId());
       assertEquals("hello", result.getValue());

    }

    // ========== GET TEST ===============
    @Test
    public void getTest(){
        // given
        String input = "Get 5";

        // when
        Command result = parser.parse(input);

        // then
        assertEquals(CommandType.GET, result.getType());
        assertEquals(5, result.getId());
        assertNull(result.getValue());

    }

    // ========== GET ALL TEST ===============
    @Test
    void getAllTest() {
        // given
        String input = "Get";

        // when
        Command result = parser.parse(input);

        // then
        assertEquals(CommandType.GET_ALL, result.getType());
        assertNull(result.getId());
        assertNull(result.getValue());
    }

    // ========== UPDATE TEST ===============
    @Test
    public void updateTest(){
        // given
        String input = "Update 5 Hello";

        // when
        Command result = parser.parse(input);

        // then
        assertEquals(CommandType.UPDATE, result.getType());
        assertEquals("Hello", result.getValue());
        assertEquals(5, result.getId());

    }

    // ========== DELETE TEST ===============
    @Test
    public void deleteTest() {
        // given
        String input = "Delete 5";

        // when
       Command result = parser.parse(input);

        // then
        assertEquals(CommandType.DELETE, result.getType());
        assertEquals(5, result.getId());
        assertNull(result.getValue());

    }
}
