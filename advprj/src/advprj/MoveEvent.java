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
public class MoveEvent extends Event{
    int direct;
    String user;
    public MoveEvent(int x, int y,String user ,int clock,int direct) {
        super(x, y, clock);
        this.direct=direct;
        this.user=user;
    }
    
}
