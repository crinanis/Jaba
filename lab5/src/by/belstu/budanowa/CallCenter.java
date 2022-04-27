package by.belstu.budanowa;

public class CallCenter {
    private final Client[] clients;
    private final int callCenterSize;

    public CallCenter(int size) {
        this.callCenterSize = size;
        clients = new Client[size];
    }

    public int getFreePlace() {
        for (int i = 0; i < callCenterSize; i++) {
            if (clients[i] == null)
                return i;
        }
        return -1;
    }

    public void setClient(Client client) {
        System.out.println("Клиент №" + client.getClientName() + " в данный момент обслуживается оператором.");
        clients[getFreePlace()] = client;
    }

    public void leaveClient(Client client){
        for(int i = 0; i < callCenterSize; i++){
            if(clients[i] == client){
                clients[i] = null;
                System.out.println("Клиент №" + client.getClientName() + " покидает колл-центр.");
            }
        }
    }

    public void showCallCenter() {
        System.out.println("\nКолл-центр на данный момент:\n");
        for (int i = 0; i < callCenterSize; i++) {
            if(clients[i] != null){
                System.out.println("оператор №" + i + ": обслуживает клиента №" + clients[i].getClientName());
            }
            else{
                System.out.println("оператор №" + i + " свободен");
            }
        }
        System.out.println("\n");
    }
}
