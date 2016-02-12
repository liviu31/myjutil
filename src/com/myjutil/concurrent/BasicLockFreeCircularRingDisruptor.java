package com.myjutil.concurrent;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/**
 * User: liviu
 * Date: 7/21/15
 * Time: 8:16 PM
 */
public class BasicLockFreeCircularRingDisruptor<T> {

    private static final int DEFAULT_SIZE = 16;

    //TODO int to long if size > Integer.MAX_VALUE
    private final int size;

    private final AtomicLong addPosition = new AtomicLong(0);

    private final AtomicLong consumePosition = new AtomicLong(0);

    //AtomicReference
    private final AtomicReferenceArray<T> holder;

    public BasicLockFreeCircularRingDisruptor(int size) {
        this.size = size;
        holder = new AtomicReferenceArray<T>(size);
    }

    public BasicLockFreeCircularRingDisruptor() {
        this(DEFAULT_SIZE);
    }

    public boolean pushIfPossible(T data) {
        int ringPosition = (int) (addPosition.get() % size);
        if (holder.compareAndSet(ringPosition, null, data)) {
            addPosition.incrementAndGet();
            return true;
        }
        return false;
    }

    public T consumeIfPossible() {
        long consume = consumePosition.get();
        int ringPosition = (int) (consume % size);
        T data = holder.getAndSet(ringPosition, null);
        if (data != null) {
            consumePosition.incrementAndGet();
        }
        return data;
    }

    //TODO
    //while push
    //while consume

}

