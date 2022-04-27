package by.belstu.it.budanowa;

public class Refactor {
    public String getValue()
    {
        return getString();
    }

    public int test;

    public void setTest(int test) {
        this.test = test;
    }

    public int getTest() {
        return test;
    }

    private String getString() {
        return "Hello from First project";
    }
}
