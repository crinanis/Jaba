package by.belstu.budanowa;

public class Cars extends Thread{
    private final int id;
    private final char course; //п - право, л - лево
    RoadLane Road;
    public Cars(int id, char course, RoadLane Road) {
        this.id = id;
        this.course = course;
        this.Road = Road;
    }

    public int getIdent() {
        return this.id;
    }

    public char getCourse() {
        return course;
    }

    @Override
    public void run() {
        try {
            switch(Road.getCurCourse()) {
                case 'п': if(this.course != 'п') {
                    sleep(1000);
                } while (Road.getCurCourse() != 'п');
                    break;
                case 'л': if(this.course != 'л') {
                    sleep(1000);
                } while (Road.getCurCourse() != 'л');
                    break;
                default:
                    break;
            }
            Road.setCarsLeft(Road.getCarsLeft() + 1);
            if(Road.getCarsLeft() >= 3) {
                if (Road.getCurCourse() == 'л')
                    Road.setCurCourse('п');
                else
                    Road.setCurCourse('л');
                Road.setCarsLeft(0);
            }
            Road.acquire(this);
            Road.release(); //освобождаем разрешение
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
