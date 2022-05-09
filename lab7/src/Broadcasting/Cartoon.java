package Broadcasting;

public class Cartoon extends Broadcast {
    public Cartoon(String name, String title, int year, int duration)
    {
        setName(name);
        setTitle(title);
        setYear(year);
        setDuration(duration);
    }

    @Override
    public String getInfo() {
        return "Type of a broadcast : " + getName() + "\nYear of creation: " + getYear() + "\nTitle: " + getTitle() + "\nDuration of a program: " + getDuration();
    }


    enum numbers
    {
        one,
        two
    };


    private numbers num;
}
