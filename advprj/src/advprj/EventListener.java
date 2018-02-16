package advprj;

public abstract class EventListener
{
    private int x;

    private int y;
    private String user;
    private boolean exist=true;
    public EventListener(int x, int y,String user)
    {
        this.x = x;
        this.y = y;
        this.user=user;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }
    public boolean getExist(){
        return exist;
    }
    public String getUser(){
        return user;
    }
    public void setExist(){
        exist=false;
    }
    protected void setX(int x){
        if(x>0 &&x<=Game.getCol())
            this.x=x;
    }
    protected void setY(int y){
        if(y>0 && y<=Game.getRow())
            this.y=y;
    }
    abstract void  clock(int clock);

    abstract void handle(ExplosionEvent event);

    abstract int handle(ShootEvent event);
    
    void beingShot(int clock){
    }
    abstract void handle(MoveEvent event);
    
    abstract void handle(StopEvent event);
    
    abstract boolean distroy();
    
    void setOutCar(){}
    
    void damage(){}
    

}
