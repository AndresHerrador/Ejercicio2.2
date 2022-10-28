package com.herradorsanchez.org;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Broker broker = new Broker(20);
        Client[] clients = {
                new Client("Jose", broker),
                new Client("Ramón", broker),
                new Client("Jacinta", broker),
                new Client("Rosa", broker)
        };

        for (Client client : clients) {
            client.start();
        }

        broker.waitUntilNoSharesAvailable();

        for (Client client : clients) {
            client.interrupt();
            client.join();
        }


    }
}