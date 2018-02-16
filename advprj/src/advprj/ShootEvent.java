package advprj;

public class ShootEvent extends Event
{
    String user;
    public ShootEvent(int x, int y,int clock,String user)
    {
        super(x, y,clock);
        this.user=user;
    }
}
