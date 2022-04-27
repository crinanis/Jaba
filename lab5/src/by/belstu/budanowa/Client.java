package by.belstu.budanowa;
import java.util.Random;

public class Client extends Thread {

    public String clientName;
    final CallCenter callcenter;
    Random random = new Random();

    public Client(int clientName, CallCenter callcenter) {
        this.clientName = String.valueOf(clientName);
        this.callcenter = callcenter;
        System.out.println("Клиент №" + this.clientName + "  прибыл.");
    }

    @Override
    public void run() {
        synchronized (callcenter) {
            if (callcenter.getFreePlace() == -1) {
                int waitingTime = random.nextInt(1000);
                System.out.println("Клиент №" + this.getClientName() + " ожидает...");
                try{
                    callcenter.wait(waitingTime);
                }
                catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        if(callcenter.getFreePlace() != -1){
            callcenter.setClient(this);
            callcenter.showCallCenter();
            try{
                Thread.sleep(random.nextInt(3000));
            }
            catch(Exception e) {
                e.printStackTrace();
            }

            callcenter.leaveClient(this);
            synchronized (callcenter){
                callcenter.notify();
            }
        }
        else{
            System.out.println("Клиент №" + this.getClientName() + " покинул колл-центр.");
        }
    }

    public String getClientName(){
        return this.clientName;
    }
}

