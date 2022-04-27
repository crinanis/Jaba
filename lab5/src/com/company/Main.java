package com.company;

import by.belstu.budanowa.*;

import java.util.concurrent.locks.ReentrantLock;


public class Main {

    public static final int CLIENTSCOUNT = 20;
    public static final int OPERATORSAMOUNT = 5;

    public static void main(String[] args) {

        CallCenter call = new CallCenter(OPERATORSAMOUNT);

      /*  for (int i = 0; i < CLIENTSCOUNT; i++) {
            (new Client(i, call)).start();
            try{
                Thread.sleep(500);
            }
            catch(InterruptedException e) {
                e.printStackTrace();
            }
        }*/

        ReentrantLock locker = new ReentrantLock();
        RoadLane Road = new RoadLane(3,locker, 'л');
        Cars car1 = new Cars(1,'л',Road);
        Cars car2 = new Cars(2,'л',Road);
        Cars car3 = new Cars(3,'л',Road);
        Cars car4 = new Cars(4,'л',Road);
        Cars car5 = new Cars(5,'л',Road);
        Cars car6 = new Cars(6,'п',Road);
        Cars car7 = new Cars(7,'п',Road);
        Cars car8 = new Cars(8,'п',Road);
        Cars car9 = new Cars(9,'п',Road);
        Cars car10 = new Cars(10,'п',Road);
        car1.start();
        car6.start();
        car2.start();
        car3.start();
        car7.start();
        car8.start();
        car9.start();
        car4.start();
        car5.start();
        car10.start();

    }
}