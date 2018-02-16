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
public class StopEvent extends Event{
    String user;
    public StopEvent(int x, int y,String user ,int clock) {
        super(x, y, clock);
        this.user=user;
    }
    
}
