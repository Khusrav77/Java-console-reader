package com.shh.util;


import com.shh.service.IdGenerator;
import com.shh.service.IdGeneratorImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class IdGeneratorTest {

    @Test
    void nextIdTest() {
        // given
        IdGenerator idGenerator = new IdGeneratorImpl(0);

        // when
        int first = idGenerator.nextId();
        int second = idGenerator.nextId();

        // then
        assertEquals(1, first);
        assertEquals(2, second);

    }

}
