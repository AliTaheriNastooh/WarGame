package advprj;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Launcher extends Application
{
    private static Game game;
    private static boolean chooseUser=true;
    private static Text userr=new Text();
    Text timerr=new Text();
    Button start;
    Stage instanceStage;
    Scene scene1;
    Scene scene2;
    public static void main(String[] args)
    {
        launch(args);
    }
public void ButtonClicked(MouseEvent e) throws IOException
    {
        if (e.getSource()==start){
           instanceStage.setScene(scene2);
           game.start();
        }
        else{
           instanceStage.setScene(scene1);
           game.save();
        }
    }
    @Override
    public void start(Stage stage) throws Exception
    {
        instanceStage=stage;
        BorderPane root2 = new BorderPane();
        root2.setStyle("-fx-background-color: tan;-fx-padding: 10px;");
        VBox center1=new VBox();
        start=new Button("start");
        start.setPrefSize(100, 80);
        start.setOnMouseClicked((new EventHandler<MouseEvent>() { 
        public void handle(MouseEvent event) {
            try {
                ButtonClicked(event);
            } catch (IOException ex) {
                Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } 
          }));
        Button load=new Button("load");
        load.setPrefSize(100, 80);
        Button instruction=new Button("instruction");
        instruction.setPrefSize(100, 80);
        Button exit=new Button("exit");
        exit.setPrefSize(100, 80);
        center1.getChildren().addAll(start,load,instruction,exit);
        root2.setCenter(center1);
        scene1 = new Scene(root2);
        stage.setScene(scene1);
        stage.show();







        
        
        
        
        int rows=10;
        int cols=10;
        int direct;
        String user;
        Integer[] choicePiec=new Integer[2];
        BorderPane root = new BorderPane();
        HBox certain=new HBox();
        VBox table=new VBox();
        VBox action=new VBox();
        game=new Game(rows,cols,table,"user1","user2",timerr);
        userr.setText("user1");
        userr.setFill(Color.RED);
        timerr.setFill(Color.BLUE);
        userr.setFont(Font.font(null, FontWeight.BOLD, 11));
        timerr.setFont(Font.font(null, FontWeight.BOLD, 11));
        Button explotion=new Button("set explotion");
        explotion.setOnMouseClicked((new EventHandler<MouseEvent>() { 
        public void handle(MouseEvent event) {
            if(chooseUser){
                game.informGunnery(choicePiec[0], choicePiec[1],"user1");
            }
            else{
                game.informGunnery(choicePiec[0], choicePiec[1],"user2");
            }
            
            //System.out.println(choicePiec[0]+"   "+choicePiec[1]);
            changeUser();
        } 
          }));
        explotion.setPrefSize(100, 80);
        
        //explotion.setPadding(new Insets(20));
        action.getChildren().add(explotion);
        Button shoot=new Button("set shoot");
        shoot.setPrefSize(100, 80);
        //shoot.setPadding(new Insets(20));
        shoot.setOnMouseClicked((new EventHandler<MouseEvent>() { 
        public void handle(MouseEvent event) {
            
            if(chooseUser){
                game.informShootEvent(choicePiec[0], choicePiec[1],"user1");
            }
            else{
                game.informShootEvent(choicePiec[0], choicePiec[1],"user2");
            }
            changeUser();
        } 
          }));
        action.getChildren().add(shoot);
        Button move=new Button("move");
        //move.setPadding(new Insets(20));
        move.setPrefSize(100, 80);
        move.setOnMouseClicked((new EventHandler<MouseEvent>() { 
        public void handle(MouseEvent event) { 
            if(chooseUser){
                game.informMoveEvent(choicePiec[0], choicePiec[1],"user1");
            }
            else{
                game.informMoveEvent(choicePiec[0], choicePiec[1],"user2");
            }
            changeUser();
        } 
          }));
        action.getChildren().add(move);
        Button stop=new Button("stop");
        stop.setPrefSize(100, 80);
//stop.setPadding(new Insets(20));
        stop.setOnMouseClicked((new EventHandler<MouseEvent>() { 
        public void handle(MouseEvent event) { 
            if(chooseUser){
                game.informStopEvent(choicePiec[0], choicePiec[1],"user1");
            }
            else{
                game.informStopEvent(choicePiec[0], choicePiec[1],"user2");
            }
            changeUser();
        } 
          }));
        Button up=new Button("up");
        up.setPrefSize(60, 50);
        up.setOnMouseClicked((new EventHandler<MouseEvent>() { 
        
            public void handle(MouseEvent event) { 
            game.setDirect(1);
        } 
          }));
        Button down=new Button("down");
        down.setPrefSize(60, 50);
        down.setOnMouseClicked((new EventHandler<MouseEvent>() { 
        public void handle(MouseEvent event) { 
            game.setDirect(3);
        } 
          }));
        Button left=new Button("left");
        left.setPrefSize(60, 50);
        left.setOnMouseClicked((new EventHandler<MouseEvent>() { 
        public void handle(MouseEvent event) { 
            game.setDirect(2);
        } 
          }));
        Button right=new Button("right");
        right.setPrefSize(60, 50);
        right.setOnMouseClicked((new EventHandler<MouseEvent>() { 
        public void handle(MouseEvent event) { 
            game.setDirect(4);
        } 
          }));
        Button turnoff=new Button("",load(new File("icons", "turnoff.png")));
        turnoff.setPrefSize(60, 50);
        turnoff.setOnMouseClicked((new EventHandler<MouseEvent>() { 
        public void handle(MouseEvent event) { 
            try {
                ButtonClicked(event);
            } catch (IOException ex) {
                Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
          }));        
        action.getChildren().add(stop);
        action.getChildren().add(up);
        action.getChildren().add(down);
        action.getChildren().add(left);
        action.getChildren().add(right);
        action.getChildren().add(turnoff);
        action.getChildren().add(userr);
        action.getChildren().add(timerr);
        final MyMouseEventHandler myMouseEventHandler = new MyMouseEventHandler(choicePiec);
        for(int i=0 ;i<rows;i++){          
            HBox tmp=new HBox();
            for(int j=0;j<cols ; j++){
                Piece tmp2=new Piece(j+1,i+1);
                tmp2.setPrefSize(80, 40);
                    tmp2.setStyle("-fx-border-style: solid inside;" +  
                      "-fx-border-color: blue;");
                tmp2.addEventHandler(MouseEvent.MOUSE_CLICKED, myMouseEventHandler);
                tmp.getChildren().add(tmp2);
            }
                    tmp.setStyle("-fx-border-style: solid inside;" +  
                      "-fx-border-color: blue;");
            table.getChildren().add(tmp);
        }
        certain.getChildren().add(table);
        certain.getChildren().add(action);
        root.setCenter(certain);
        scene2 = new Scene(root);
//        stage.setScene(scene);
//        
//        stage.show();
        
//      Circle circle = new Circle(); 
//      
//      //Setting the position of the circle 
//      circle.setCenterX(300.0f); 
//      circle.setCenterY(135.0f); 
//      
//      //Setting the radius of the circle 
//      circle.setRadius(25.0f);

        
        
        /*
        Game game = new Game(10, 10);
        Officer of = (Officer) game.getEventListeners().get(0);
        BorderPane root = new BorderPane();
        Button explode = new Button("Explode");
        root.setTop(explode);
        Button officer = new Button(of.getHealth() + "");
        root.setCenter(officer);
        explode.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                game.informExplosionEvent(0, 0);
                updateGraphics();
            }

            private void updateGraphics()
            {
                officer.setText(of.getHealth() + "");
            }
        });
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        game.start();
*/
    }
    static void informExplotion(int x, int y,boolean damage,boolean guiver){
        game.informExplosionEvent(x, y, true, true);
    }
    static void changeUser(){
        chooseUser=!chooseUser;
        if (chooseUser==true){
            userr.setText("user1");
        }
        else{
            userr.setText("user2");
            
        }
        
    }
    static void setUser(){
        //chooseUser=true;
        System.out.println(chooseUser);
    }
        public static ImageView load(File file)
    {
        Image image = new Image(file.toURI().toString());
        ImageView iv = new ImageView(image);
        iv.setFitHeight(40);
        iv.setFitWidth(20);
        return iv;
    }
}
