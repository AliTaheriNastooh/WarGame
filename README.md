# WarGame
new game

I use netbeans IDE

The game page is a chess page (a rectangle)

The game is a two-player game that can either be a person  and the other be computer or both of them are user.

Each player has a number of beads that they can only order them

In a piece of board , every number of your beads and your enemy beads

Each player's bead is one of a variety of soldiers, officers and cars that a car can have between 1 and 4 beads that contain
soldier or officer or a combination of them.


The goal is to destroy all enemy's beads in such a way that at any time all the beads of a player are destroyed
That player is lost. If both players are destroyed  all beads at the same time, the game is equal.

At first, each player will receive two cars from a number of officers or officers at random.

The passing of time in the game is discrete, so the game runs in discrete time units

At each time, each player orders one command, and then the two player commands are execute.

Each player per one time can only order one command from the following commands:

    1)choose  a cell of board and shoot the Artillery. The cell explodes after 3 time , As a result of this blast, all the beads hit it.    A soldier has been dropped dies.

    As a result of this blast, decreases 2 units of officer power. Every officer in
    First, it has 11 power units and dies when it's gone. A dead soldier and officer is deleted from
    The playing field.

    As a result of this blast,a car has been destroyed and removed from the playing field
    And its occupants will be hurt.

    Also, all cell in the neighboring exploded cell are effected
    and this effect cause all member of this cell will be herted.

    Damage to a soldier leads to a soldier's runaway escape. Escape is the phrase
    Move from one of the top, bottom, left, and right directions at the speed of a house per unit time 
    Damage to an officer leads to a reduction of one unit of his power and shift his position to 
    neighborhood of four direction accidently.

    Some cell are mined that may be explosed or being affected (by the blast of a neighboring cell)
    
    2)Select a cell that containing at least one your beads, order to shoot, and then select one
    direction: In this case, the strongest bead in that cell (are the officer of a stronger soldier) shoot.a sodier's bullet move 2 cell
    per time and officer's bullet move 3 cell per time. The bullet comes out of the field or hit an your beads
    Or your enemy beads in a cell.in each cell at the beginig if neads of your enemy exist his enemy hurt or if dont exist your beads       hurt.
    
    The soldier is injured by bullet shooting
    And 3 units of time are stuck at the same cell and can not move and shoot
    
    An officer loses a unit of powe by bullet shooting and may die.
    
    The car explodes through the collision of the 5th bullet and leads to a cell exploding.
    
    3)Choose a cell and order to move in a direction.
    all your beads in that cell follow your command.soldier start to moving a cell per a time
    officer just move one cell and stay in that cell.
    The car and all its occupants start moving in that direction, and at each time it moves two cell
    Moving beads are capable of receiving firing orders. In this case, they perform their firing first before moving on at each time,       and then move on  
    
    Choosing a cell and a stop order that will stop all of the beads moving in that home.
    The beads do not move out of the playing field, but stop at the edge of the field.
