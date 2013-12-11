package com.myjutil.concurrent;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * User: liviu
 * Date: 12/11/13
 * Time: 7:21 PM
 */
public class BusyBatchWorker<T> extends Thread {

    private final ConcurrentLinkedQueue<T> queue;

    private final BatchHandler<T> handler;

    private final int batchSize;

    private final int maxMilliseconds;

    private final boolean commitOnEmptyQueue;

    public BusyBatchWorker(ConcurrentLinkedQueue<T> queue, BatchHandler<T> handler, int batchSize, int maxMilliseconds, boolean commitOnEmptyQueue) {
        this.queue = queue;
        this.handler = handler;
        this.batchSize = batchSize;
        this.maxMilliseconds = maxMilliseconds;
        this.commitOnEmptyQueue = commitOnEmptyQueue;
    }

    public void run() {
        while (true) {//TODO add a way to stop
            doRun();
        }
    }

    public void doRun() {
        final long start = System.currentTimeMillis();
        int added = 0;
        while (System.currentTimeMillis() - start < maxMilliseconds && added < batchSize) {
            T data = queue.poll();
            if (data != null) {
                handler.add(data);
                added++;
            } else {
                if (commitOnEmptyQueue) {
                    break;
                }
            }
        }
        if (added > 0) {
            handler.commit();
        }
    }

    public static interface BatchHandler<T> {

        public void add(T data);

        public void commit();

    }

}