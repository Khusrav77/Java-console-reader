package com.shh.util;

import java.util.concurrent.atomic.AtomicInteger;

public class IdGeneratorImpl implements IdGenerator{

    private final AtomicInteger counter = new  AtomicInteger();

    @Override
    public Integer nextId() {
        return counter.incrementAndGet();
    }
}
