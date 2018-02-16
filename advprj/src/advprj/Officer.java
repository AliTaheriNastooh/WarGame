package advprj;

import java.util.Random;

public class Officer extends EventListener
{
    private int health = 10;
    private int move=0;
    boolean inCar;
    public Officer(int x, int y,String user,boolean inCar)
    {
        super(x,y,user);
        this.inCar=inCar;
    }
         public String toString(){
            return "officer "+super.getX()+" "+super.getY()+" "+super.getUser()+" "+health+" "+move+" "+inCar;
                 }
    public int getHealth()
    {
        return health;
    }

    @Override
    public void clock(int clock)
    {
        //System.out.println("clock#" + clock);
    }

    @Override
    public void handle(ExplosionEvent event)
    {
        if (event.getX() == super.getX() && event.getY() == super.getY()) {
            health=health-2;
        }
        if(Math.abs(event.getX()-super.getX())==1  ||  Math.abs(event.getY()-super.getY())==1){
            damage();
        }
    }

    @Override
    public int handle(ShootEvent event)
    {
        if(event.getX()==super.getX()&&event.getY()==super.getY()&&event.user.equals(super.getUser())){
            return 2;
        }
        return 0;
    }



    @Override
    public boolean distroy() {
    if(health<=0)
        return true;
    return false;
    }
    void setOutCar(){
        inCar =false;
    }
    void damage(){
        System.out.println("officer damage"+super.getUser()+"health"+health);
            Random rn = new Random();
            health--;
            int tmp=rn.nextInt(3)+1;
        //    System.out.println("clock#" + tmp);
            switch(tmp){
        case 1:
            if(super.getY()>1)
                super.setY(super.getY()-1);
            break;
        case 2:
            if(super.getX()>1)
                super.setX(super.getX()-1);
            break;
        case 3:
            if(super.getY()<Game.getRow())
                super.setY(super.getY()+1);
            break;
        case 4:
            if(super.getX()<Game.getCol())
                super.setX(super.getX()+1);
    }
    }
    void beingShot(int clock){
        System.out.println("officer beignsh event"+super.getUser()+"health"+health);
        health--;
        if(health<0){
            super.setExist();
        }
    }
    @Override
    void handle(MoveEvent event) {
        if(event.getX()==super.getX()&& event.getY()==super.getY() && event.user.equals(super.getUser())){
            move=event.direct;
            switch(move){
            case 1:
                super.setY(super.getY()-1);
                break;
            case 2:
                super.setX(super.getX()-1);
                break;
            case 3:
                super.setY(super.getY()+1);
                break;
            case 4:
                super.setX(super.getX()+1);
                break;
        }

        }
    
}
       @Override
    void handle(StopEvent event) {
        if(event.getX()==super.getX() && event.getY()==super.getY() && event.user.equals(super.getUser())){
            move=0;
        }
    }
}
