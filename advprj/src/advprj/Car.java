package advprj;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author aliTN
 */
public class Car extends EventListener{
    private  List<EventListener> carMember = new ArrayList<>();
    int  move=0;
    private boolean exist=true;
    private int health=5;
    public Car(int x, int y,String user) {
        super(x, y,user);
        Random rn = new Random();
        for(int i=0 ; i<4; i++){
        if(rn.nextInt(2)==0){
        carMember.add(new Soldier(x,y,user,true));
        }
        else{
        carMember.add(new Officer(x,y,user,true));
        }
        }
    }
     public String toString(){
         return "car "+super.getX()+" "+super.getY()+" "+super.getUser()+" "+carMember.toString()+" "+move +" "+health;
    }
    @Override
    public void clock(int clock) {

        if(move !=0){
            switch(move){
            case 1:
                super.setY(super.getY()-2);
                break;
            case 2:
                super.setX(super.getX()-2);
                break;
            case 3:
                super.setY(super.getY()+2);
                break;
            case 4:
                super.setX(super.getX()+2);
                break;
        }

    }
 
    }
    void beingShot(int clock){
        System.out.println("car beignshot"+super.getUser()+"health"+health);
        health--;
        if(health<0){
            super.setExist();
           Launcher.informExplotion(super.getX(), super.getY(), true, true);
        }
    }
    @Override
    public void handle(ExplosionEvent event) {
      //  System.out.println(super.getX()+"   "+super.getY());
        //System.out.println(event.getX()+"   "+event.getY());
        if(event.getX() == super.getX() && event.getY() == super.getY()){
            //System.out.println(3+"   "+2);
            super.setExist();
            List<EventListener> tmp=Game.getEventListeners();
            for(int i=0 ;i<carMember.size();i++){
                carMember.get(i).setOutCar();
                carMember.get(i).setX(super.getX());
                carMember.get(i).setY(super.getY());
                carMember.get(i).damage();
                tmp.add(carMember.get(i));
            }
        }
    }

    @Override
    public int handle(ShootEvent event) {
        System.out.println("car whoot event"+super.getUser()+"health"+health);
        if(event.getX()==super.getX()&&event.getY()==super.getY()&&event.user.equals(super.getUser())){
        for(int i=0;i<carMember.size();i++){
        if(carMember.get(i) instanceof Officer){
            return 3;
        }
        }
        }
        return 0;
    }

    @Override
    public boolean distroy() {
        return !super.getExist();
    }

    @Override
    void handle(MoveEvent event) {
        System.out.println(super.getUser()+" event.user : "+event.user);
        if(event.getX()==super.getX()&& event.getY()==super.getY() && event.user.equals(super.getUser())){
            move=event.direct;
        }
    }

    @Override
    void handle(StopEvent event) {
        System.out.println(super.getUser()+" event.user : "+event.user);
        if(event.getX()==super.getX() && event.getY()==super.getY() && event.user.equals(super.getUser())){
            move=0;
        }
    }
    
}
