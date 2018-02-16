package advprj;

public class ExplosionEvent extends Event
{
    boolean damage;
    boolean guiver;
    public ExplosionEvent(int x, int y,int clock,boolean damage,boolean guiver)
    {
        super(x, y,clock);
        this.damage=damage;
        this.guiver=guiver;
    }


}
