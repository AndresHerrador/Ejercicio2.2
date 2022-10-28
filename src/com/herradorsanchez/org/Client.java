package com.herradorsanchez.org;

public class Client extends Thread {

    private final String _name;
    private final Broker _broker;


    public Client(String name, Broker broker) {
        _name = name;
        _broker = broker;
    }


    @Override
    public void run() {
        while (true) {
            try {

                Thread.sleep((long) (Math.random() * 1000));
                int actions;

                if (_broker._avalActions <= 5) {
                    actions = (int) (Math.random() * _broker._avalActions + 1);
                } else {
                    actions = (int) (Math.random() * 5 + 1);
                }
                System.out.printf("Client %s about to buy " + actions + " shares%n", _name);
                if (_broker.buy(actions)) {
                    System.out.printf("Client %s bought " + actions + " shares%n", _name);
                } else {
                    System.out.printf("Client %s couldn't buy " + actions + " shares%n", _name);

                }


            } catch (InterruptedException e) {
                break;
            }

        }
    }
}


