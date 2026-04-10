package com.shh.util;

import java.util.concurrent.atomic.AtomicInteger;

public class IdGeneratorImpl implements IdGenerator{

    private final AtomicInteger counter;

    public IdGeneratorImpl(int initialValue) {
        this.counter = new AtomicInteger(initialValue);
    }

    @Override
    public Integer nextId() {
        return counter.incrementAndGet();
    }
}
