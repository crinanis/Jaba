package by.belstu.budanowa;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class RoadLane extends Semaphore {
    ReentrantLock locker;   //создаём заглушку

    private char curCourse;

    public int getCarsLeft() {
        return cars_left;
    }

    public void setCarsLeft(int cars_left) {
        this.cars_left = cars_left;
    }

    private int cars_left = 0;

    public RoadLane(int permits, ReentrantLock locker, char course) {
        super(permits);
        this.locker = locker;
        this.curCourse = course;
    }

    public char getCurCourse() {
        return curCourse;
    }

    public void setCurCourse(char curCourse) {
        this.curCourse = curCourse;
    }

    public void acquire(Cars car) throws InterruptedException {

        super.acquire();    //получить разрешения для семафора
        Random rand = new Random();
        this.locker.lock(); //1 поток имеет доступ к критической секции
        System.out.println("Машина с " + car.getCourse() + " полосы под номером " +  car.getIdent() + " заехала.");
        this.locker.unlock();
        Thread.sleep(500 + rand.nextInt(1000));
        ++this.cars_left;
        this.locker.lock();
        System.out.println("Машина с " + car.getCourse() + " полосы под номером " +  car.getIdent() + " уехала.");
        this.locker.unlock();

    }
}
