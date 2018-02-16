/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advprj;

/**
 *
 * @author aliTN
 */
public class Gunnery extends EventListener {

    private int clockExp;
    Gunnery(int x, int y,String user,int clock){
        super(x,y,user);
        clockExp=clock+3;
    }
         public String toString(){
            return "gunnery "+super.getX()+" "+super.getY()+" "+super.getUser()+" "+clockExp;
                 }
    @Override
    
    public void clock(int clock) {
        System.out.println(clock+"  hel "+clockExp);
        if(clock==clockExp){
            System.out.println("alskdjf");
            Launcher.informExplotion(super.getX(),super.getY(),true,true);
            super.setExist();
        }
    }

    @Override
    public void handle(ExplosionEvent event) {
        
    }

    @Override
    public int  handle(ShootEvent event) {
        return 0;
    }

    @Override
    public boolean distroy() {
        return !super.getExist();
    }

    @Override
    void handle(MoveEvent event) {
}
    
       @Override
    void handle(StopEvent event) {
        
    }
}
