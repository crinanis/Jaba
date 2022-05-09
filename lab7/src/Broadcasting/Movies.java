package Broadcasting;

public class Movies extends Broadcast {
    public Movies(String name, String mark, int year, int duration)
    {
        setName(name);
        setTitle(mark);
        setYear(year);
        setDuration(duration);
    }

    @Override
    public String getInfo() {
        return "Type of a broadcast : " + getName() + "\nYear of creation: " + getYear() + "\nTitle: " + getTitle() + "\nDuration of a program: " + getDuration();
    }
}
