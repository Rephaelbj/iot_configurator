package org.picmg.test.integrationTest;

import javafx.application.Platform;

public class RobotThread {
    private Runnable runnable;
    private int delay;
    private RobotThread next = null;
    private RobotThread prev = null;
    private volatile boolean wasStarted = false;

    public RobotThread() {
        // head with no runner
        runnable = null;
        delay = 0;
    }

    /**
     * Creates one or many runnables with equivalent, non-FX delay time between sequential deployments to FX thread queue.
     * @param delay The wait time between each thread in milliseconds (e.g. delay of 1000 is 1 second)
     * @param runnables A list of runnable objects to execute on the FX thread after some delay
     */
    public RobotThread(int delay, Runnable... runnables) {
        RobotThread cursor = null;
        // create chain
        for (int i = 1; i < runnables.length; i++) {
            RobotThread next = new RobotThread(delay, runnables[i], cursor);
            cursor = next;
        }
    }

    private RobotThread(int delay, Runnable runnable) {
        this.runnable = runnable;
        this.delay = delay;
    }

    private RobotThread(int delay, Runnable runnable, RobotThread prev) {
        this(delay, runnable);
        this.prev = prev;
    }

    /**
     * Run the given function with FX threading after delaying on a generic Java thread. This threading hot potato
     * gives the FX threads processing time so UI components can catch up before the function is added to the FX thread
     * queue.
     * Calling this on any instance in a chain will only execute the first of the chain.
     */
    public void run() {
        // if this is not first in chain and previous has not run, start it
        if (prev != null && !prev.wasStarted) {
            prev.run();
            return;
        }

        // lock to execute new thread only once
        if (wasStarted) {
            return;
        }
        wasStarted = true;

        // skip if head empty
        if (runnable == null && delay == 0) {
            if (next != null) {
                next.run();
            }
            return;
        }
        new Thread(() -> {
            try {
                Thread.sleep(delay);
                Platform.runLater(() -> {
                    if (runnable != null) runnable.run();
                    if (next != null) {
                        next.run();
                    }
                });
            } catch (InterruptedException e) {
                System.out.println("Exception in wait queue. "); e.printStackTrace();
            }
        }).start();
    }

    public RobotThread then(Runnable runnable) {
        return then(0, runnable);
    }

    public RobotThread then(int delay, Runnable runnable) {
        // pass down chain until end
        if (next != null) {
            return next.then(delay, runnable);
        }
        // append to end of chain
        next = new RobotThread(delay, runnable, this);
        return next;
    }

    public RobotThread wait(int delay) {
        next = new RobotThread(delay, null, this);
        return next;
    }

}
