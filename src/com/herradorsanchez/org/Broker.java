package com.herradorsanchez.org;

public class Broker {

    private static final int MIN_ACTIONS = 1;

    public int _avalActions;

    public Broker(int maxActions) {
        if (maxActions <= MIN_ACTIONS) maxActions = MIN_ACTIONS;
        _avalActions = maxActions;
    }

    public synchronized boolean buy(int actions) throws InterruptedException {
        boolean canBuy;
        if (_avalActions >= actions) {
            System.out.printf("Broker: there's " + _avalActions + " available shares%n");
            canBuy = true;
            notifyAll();
            _avalActions -= actions;
            System.out.printf("Now there's " + _avalActions + " available shares%n");
        } else {
            canBuy = false;
            notifyAll();
        }
        return canBuy;


    }

    public synchronized void waitUntilNoSharesAvailable() throws InterruptedException {
        while (_avalActions > 0) {
            wait();
        }

    }
}
