package advprj;

import java.io.File;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class MyMouseEventHandler implements EventHandler<MouseEvent>
{
    private Integer[] choice;
    public MyMouseEventHandler(Integer[] choice)
    {
        this.choice=choice;
    }

    @Override
    public void handle(MouseEvent event)
    {
            Piece p=(Piece) event.getSource();
            choice[0]=(Integer)p.x;
            choice[1]=p.y;
           // System.out.println(choice[0]+"   "+choice[1]);
    }

}
