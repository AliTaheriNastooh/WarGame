package advprj;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MyRunnableImpl implements Runnable
{
    private  List<EventListener> member = new ArrayList<>();
    private final VBox table;
    public MyRunnableImpl(List<EventListener> member,VBox table )
    {
        this.member=member;
        this.table=table;
    }

    @Override
    public void run()
    {
        remove();
        for(int i=0 ; i<member.size() ; i++){
             HBox tmp=(HBox)table.getChildren().get(member.get(i).getY()-1);
             Piece tmp2=(Piece)tmp.getChildren().get(member.get(i).getX()-1);
             if(member.get(i) instanceof Officer){
             Officer of=(Officer)member.get(i);
                if(of.inCar){
                    if(of.getUser().equals("user1")){
                        tmp2.getChildren().add(load(new File("icons", "officer1in.png")));
                    }
                    else{
                        tmp2.getChildren().add(load(new File("icons", "officer2in.png")));
                    }
                }
                else{
                    if(of.getUser().equals("user1")){
                        tmp2.getChildren().add(load(new File("icons", "officer1out.png")));
                    }
                    else{
                        tmp2.getChildren().add(load(new File("icons", "officer2out.png")));
                    }
                }
             }
             if(member.get(i) instanceof Soldier){
                Soldier of=(Soldier)member.get(i);
                if(of.inCar){
                    if(of.getUser().equals("user1")){
                        tmp2.getChildren().add(load(new File("icons", "soldier1in.jpg")));
                    }
                    else{
                        tmp2.getChildren().add(load(new File("icons", "soldier2in.png")));
                    }
                }
                else{
                    if(of.getUser().equals("user1")){
                        tmp2.getChildren().add(load(new File("icons", "soldier1out.jpg")));
                    }
                    else{
                        tmp2.getChildren().add(load(new File("icons", "soldier2out.jpg")));
                    }
                }
             }
             if(member.get(i) instanceof Shot){
                 Shot of=(Shot)member.get(i);
                 if(of.getUser().equals("user1")){
                     tmp2.getChildren().add(load(new File("icons", "shoot1.jpg")));
                 }else{
                     tmp2.getChildren().add(load(new File("icons", "shoot2.jpg")));
                 }
             }
             if(member.get(i) instanceof Car){
                 Car of=(Car)member.get(i);
                 if(of.getUser().equals("user1")){
                     tmp2.getChildren().add(load(new File("icons", "car1.png")));
                 }else{
                     tmp2.getChildren().add(load(new File("icons", "car2.jpg")));
                 }             
             }
             if(member.get(i) instanceof Mine){
                 Mine of=(Mine)member.get(i);
                 if(of.getUser().equals("user1")){
                     tmp2.getChildren().add(load(new File("icons", "mine1.png")));
                 }else{
                     tmp2.getChildren().add(load(new File("icons", "mine2.png")));
                 }
             }
             
        }
    }
        public static ImageView load(File file)
    {
        Image image = new Image(file.toURI().toString());
        ImageView iv = new ImageView(image);
        iv.setFitHeight(40);
        iv.setFitWidth(20);
        return iv;
    }
        void remove(){
            
             List a=table.getChildren();
             for(int i=0 ; i<a.size();i++){
                HBox tmp=(HBox)a.get(i);
                List b=tmp.getChildren();
                for(int j=0 ; j<b.size(); j++){
                    HBox tmp2=(HBox)b.get(j);
                    tmp2.getChildren().clear();
                }

             }
             }

}
