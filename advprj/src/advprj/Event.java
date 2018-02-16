package advprj;

public class Event
{
    private int x;

    private int y;
    
    private int clock;
    public Event(int x, int y,int clock)
    {
        this.x = x;
        this.y = y;
        this.clock=clock;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }
    public int getClock()
    {
        return clock;
    }

}
