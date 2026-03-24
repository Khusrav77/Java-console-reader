package com.shh;

import com.shh.model.Command;
import com.shh.model.CommandType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ParserTest {


    private Parser parser = new Parser();

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
