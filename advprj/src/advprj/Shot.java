/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advprj;

import java.util.List;

/**
 *
 * @author aliTN
 */
public class Shot extends EventListener {
private  List<EventListener> member;
    int direct;
    int movePerSecond;
    public Shot(int x, int y, String user,int direct,int movePerSecond) {
        super(x, y, user);
        member=Game.getEventListeners();
        this.direct=direct;
        this.movePerSecond= movePerSecond;
    }
         public String toString(){
            return "shot "+super.getX()+" "+super.getY()+" "+super.getUser()+" "+direct+" "+movePerSecond;
                 }

    @Override
    void clock(int clock) {
        for(int i=0 ; i< movePerSecond && super.getExist();i++){
        switch(direct){
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
        
        if(choose(clock) ||(super.getX()==1&&direct==2) ||(super.getX()==Game.getCol()&&direct==4)||(super.getY()==1&&direct==1) || (super.getY()==Game.getRow()&&direct==3)  ){
            super.setExist();
        }
        }
    }
    boolean choose(int clock){
        int index=0;
        for(int i=0;i<member.size();i++){
            if(member.get(i).getX()==super.getX()&&member.get(i).getY()==super.getY()&& !member.get(i).getUser().equals(super.getUser())){
                if(member.get(i) instanceof Soldier){
                    member.get(i).beingShot(clock);
                    super.setExist();
                    return true;
                }
                if(member.get(i) instanceof Officer){
                    index=i;
                }
                if(member.get(i) instanceof Car){
                    if(index==0){
                        index=i;
                    }
                }              
            }
        }
        if(index!=0){
            member.get(index).beingShot(clock);
            return true;
        }
        else{
        for(int i=0;i<member.size();i++){
            if(member.get(i).getX()==super.getX()&&member.get(i).getY()==super.getY()&&member.get(i).getUser().equals(super.getUser())){
                if(member.get(i) instanceof Soldier){
                    member.get(i).beingShot(clock);
                    super.setExist();
                    return true;
                }
                if(member.get(i) instanceof Officer){
                    index=2;
                }
                if(member.get(i) instanceof Car){
                    if(index==0)
                        index=3;
                }              
            }
        }
        if(index!=0){
            member.get(index).beingShot(clock);
            return true;
        }
    }
        return false;
    }
    @Override
    void handle(ExplosionEvent event) {
    }

    @Override
    int handle(ShootEvent event) {
    return 0;
    }

    @Override
    boolean distroy() {
        return !super.getExist();
    }

    @Override
    void handle(MoveEvent event) {
}
      @Override
    void handle(StopEvent event) {
        
    } 
}
