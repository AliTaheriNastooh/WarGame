package advprj;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Game extends TimerTask
{
    private Timer timer;

    private static final List<EventListener> member = new ArrayList<>();

    private static int rows;

    private static int cols;

    private int clock = 0;
    
    private String user1;
    
    private String user2;
    
    private int direct;
    
    private TimerThread1 timer2;
    private final int speed;
    private final VBox table;
    public Game(int rows, int cols,VBox table,String user1,String user2,Text text)
    {
        speed=10;
        this.rows = rows;
        this.cols = cols;
        this.table=table;
        this.user1=user1;
       
        this.user2=user2;
        timer2=new TimerThread1(text,speed);
       // eventListeners.add(new Officer(0, 0,false));
    }

    public void start()
    {
        timer = new Timer();
        timer.schedule(this, 0, speed*1000);
        member.add(new Car(cols/2,1,user1));
        member.add(new Car(cols/2,rows,user2));
        timer2.start();
       
        updateGraphics();
        
    }
    void save() throws IOException{
      File file = new File("data.txt");
      // creates the file
      file.createNewFile();
      FileWriter writer = new FileWriter(file);
        int size=member.size();
        for(int i=0 ; i<size ; i++){
            if(!member.get(i).distroy()){
                writer.write(member.toString());
            }
        }
      writer.flush();
      writer.close(); 
    }
    void load() throws FileNotFoundException{
        Scanner s = new Scanner(new File("data.txt"));
        int x,y;
        String user;
        while (s.hasNext()){
            switch(s.next()){
                case "car":
                     x=Integer.parseInt(s.next());
                     y=Integer.parseInt(s.next());
                     user=s.next();
                     
                    break;
                case "gunnery":
                     x=Integer.parseInt(s.next());
                     y=Integer.parseInt(s.next());
                     user=s.next();
                     int tmp=Integer.parseInt(s.next());
                     member.add(new Gunnery(x,y,user,tmp-3));
                    break;
                    
                case "mine":
                    
                    break;
                    
                case "officer":
                    
                    break;
                    
                case "shot":
                    
                    break;
            
                case "soldier":
                    
                    break;
            }
        }
    
    }
    @Override
    public void run()
    {
        int size=member.size();
        for(int i=0 ; i<size ; i++){
            member.get(i).clock(clock);
        }
//        for (EventListener eventListener : member) {
//            eventListener.clock(clock);
//        }
        clock++;
        System.out.println("clock"+clock);
        removeElement();
        updateGraphics();
        Launcher.setUser();
    }

    @Override
    public String toString()
    {
        String s = "";
        for (EventListener eventListener : member) {
            s = s + eventListener + "\n";
        }
        return s;
    }
    
    public  void informStopEvent(int x, int y,String user){
        StopEvent stop=new StopEvent(x,y,user,clock);
        int size=member.size();
        for(int i=0 ; i<size ; i++){
            member.get(i).handle(stop);
        }        
    }
    
    public  void informMoveEvent(int x, int y,String user){
        MoveEvent move=new MoveEvent(x,y,user,clock,direct);
        int size=member.size();
        for(int i=0 ; i<size ; i++){
            member.get(i).handle(move);
        }    
    }
    
    public  void informShootEvent(int x, int y,String user)
    {
        ShootEvent event = new ShootEvent(x, y,clock,user);
        Shot shot;
        int size=member.size();
        int tmp=0;
        int index=0;
        for(int i=0 ; i<size ; i++){
            tmp=member.get(i).handle(event);
            if(tmp==3 || tmp==2){
                index=i;
                break;
            }
            if(tmp==1){
                index=i;
            }
        }
        if(tmp==2 || tmp==3){
            shot=new Shot(x,y,user,direct,2);
            member.add(shot);
        }
        else{
            if(index!=0){
            shot=new Shot(x,y,user,direct,3);
            member.add(shot) ;           
            }
        }
        
//        for (EventListener eventListener : member) {
//            System.out.println(eventListener.toString());
//            eventListener.handle(event);
//        }
    }
    public void informGunnery(int x,int y,String user){
        Gunnery g=new Gunnery(x,y,user,clock);
        member.add(g);
    }
    public  void informExplosionEvent(int x, int y,boolean damage,boolean guiver)
    {
        ExplosionEvent event = new ExplosionEvent(x, y,clock,damage,guiver);
        int size=member.size();
        for(int i=0 ; i<size ; i++){
            member.get(i).handle(event);
        }
//        for (EventListener eventListener : member) {
//            System.out.println(eventListener.toString());
//            eventListener.handle(event);
//        }
    }
    void removeElement(){
        int size=member.size();
        for(int i=0 ; i<size ; i++){
            if(member.get(i).distroy()){
                member.remove(i);
                i--;
                size--;
            }
        }
//        for (EventListener eventListener : member) {
//            System.out.println(eventListener.toString());
//            if(eventListener.distroy()){
//                member.remove(eventListener);
//            }
//        }
    }
    static int getRow(){
        return rows;
    }
    static int getCol(){
        return cols;
    }
    void setDirect(int i){
        direct=i;
    }
    public static List<EventListener> getEventListeners()
    {
        return member;
    }

    private void updateGraphics() {
        Platform.runLater(new MyRunnableImpl(member,table));
    }

}
