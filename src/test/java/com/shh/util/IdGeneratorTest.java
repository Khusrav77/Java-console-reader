package com.shh.util;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class IdGeneratorTest {

    @Test
    void nextIdTest() {
        // given
        IdGenerator idGenerator = new IdGeneratorImpl();

        // when
        int first = idGenerator.nextId();
        int second = idGenerator.nextId();

        // then
        assertEquals(1, first);
        assertEquals(2, second);

    }

}
