package advprj;

import java.util.Random;

/**
 *
 * @author aliTN
 */
public class Soldier extends EventListener{


    boolean inCar;
    int move=0;
    int runaway=0;
    int beignShoot=0;
    public Soldier(int x, int y,String user,boolean inCar)
    {
        super(x,y,user);
        this.inCar=inCar;
    }
         public String toString(){
            return "soldier "+super.getX()+" "+super.getY()+" "+super.getUser()+" "+inCar+" "+move+" "+runaway+" "+beignShoot;
                 }
    @Override
    public void clock(int clock) {
        if(beignShoot!=0){
            beignShoot--;
        }
        else{
        if(runaway!=0 || move !=0){

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
            switch(runaway){
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
//            if(super.getX()==1 && ||super.getX()==Game.getCol()||super.getY()==1 || super.getY()==Game.getRow()){
//                runaway=0;
//            }
        }
        }
    }
    void beingShot( int clock){
        System.out.println(" beignHSot"+super.getUser()+"health");
        beignShoot=clock+3;
    }
    @Override
    public void handle(ExplosionEvent event) {
        if(event.getX()==super.getX()  &&  event.getY()==super.getY()){
            super.setExist();
        }
        if(Math.abs(event.getX()-super.getX())==1  ||  Math.abs(event.getY()-super.getY())==1){
            damage();
        }
    }
    void damage(){
            System.out.println("soldier damage"+super.getUser()+"health");
            Random rn = new Random();
            runaway = rn.nextInt(3)+1;
            System.out.println("sd"+runaway);
    }
    @Override
    public int handle(ShootEvent event) {
        if(beignShoot==0&&event.getX()==super.getX()&&event.getY()==super.getY()&&event.user.equals(super.getUser())){
            return 1;
        }
        return 0;
    }

    @Override
    public boolean distroy() {
        return !super.getExist();
    }
    void setOutCar(){
        inCar =false;
    }

    @Override
    void handle(MoveEvent event) {
     if(event.getX()==super.getX()&& event.getY()==super.getY() && event.user.equals(super.getUser())){
         if(runaway==0)   
            move=event.direct;
     }
    }
       @Override
    void handle(StopEvent event) {
        if(event.getX()==super.getX() && event.getY()==super.getY() && event.user.equals(super.getUser())){
            move=0;
        }
    }
}
