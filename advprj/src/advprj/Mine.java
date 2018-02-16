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
public class Mine extends EventListener{
    private boolean setBomb=false;
    private int counter=0;
    Mine(int x,int y,String user){
        super(x,y,user);
    }
             public String toString(){
            return "mine "+super.getX()+" "+super.getY()+" "+super.getUser()+" "+setBomb+" "+counter;
                 }
    @Override
    void clock(int clock) {
        if(setBomb){
            
            if(counter==1){
                Launcher.informExplotion(super.getX(), super.getY(),false, true);
 
            }
            if(counter==2){
               Launcher.informExplotion(super.getX(), super.getY(),true, false);
                super.setExist();
            }
            counter++;
        }
    }

    @Override
    void handle(ExplosionEvent event) {
        if(super.getExist()==true&&event.getX()==super.getX()&&event.getY()==super.getY()&&event.damage==true&&event.guiver==true && setBomb==false){
            counter=0;
            setBomb=true;
        }
        else{
        if(super.getExist()==true&&Math.abs(event.getX()-super.getX())<=1&&Math.abs(event.getY()-super.getY())<=1&&setBomb==false){
            counter=1;
            setBomb=true;
        }
        }
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
       @Override
    void handle(StopEvent event) {

    }
}
