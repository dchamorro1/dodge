import java.awt.*;
import java.util.ArrayList;

public class Game
{
    public Player player;

    public ArrayList<UpDownRect> upDownRects = new ArrayList<UpDownRect>();

    public ArrayList<Wall> walls = new ArrayList<Wall>();

    public ArrayList<LeftRightRect> leftRightRects = new ArrayList<LeftRightRect>();

    public ArrayList<PatternRect> patternRects = new ArrayList<PatternRect>();

    //LASERS
    public ArrayList<Laser> lasers = new ArrayList<Laser>();

    public GoalBox goal;

    public Game() {
        super();
    }

    public void loadLevel(int level)
    {
        if(level==1)
        {
            //MAIN PIECE
            player = new Player(new Rectangle(5, 370, 10, 10), Color.GREEN, 5, 5, 370, 10, 10);

            //deletes previous upDownRects
            upDownRects.clear();
            //clears previous leftRightRects
            leftRightRects.clear();
            //clears patternRects
            patternRects.clear();
            //deletes previous walls
            walls.clear();
            //deletes previous lasers
            lasers.clear();

            //UP DOWN RECTANGLES
            //up down 1
            upDownRects.add( new UpDownRect(new Rectangle(60, 200, 15, 15), Color.BLUE, UpDownRect.DOWN, 15, 384));
            //up down 2
            upDownRects.add( new UpDownRect(new Rectangle(100, 250, 15, 15), Color.BLUE, UpDownRect.UP, 15, 384));
            //up down 3
            upDownRects.add(new UpDownRect(new Rectangle(140, 100, 15, 15), Color.BLUE, UpDownRect.DOWN, 15, 384));
            //4th up down
            upDownRects.add( new UpDownRect(new Rectangle(180, 100, 15, 15), Color.BLUE, UpDownRect.UP, 15, 384));
            //5th up down
            upDownRects.add (new UpDownRect(new Rectangle(220, 250, 15, 15), Color.BLUE, UpDownRect.DOWN, 15, 384));
            //6th up down
            upDownRects.add (new UpDownRect(new Rectangle(260, 100, 15, 15), Color.BLUE, UpDownRect.DOWN, 15, 384));

            //WALLS
            //south wall
            walls.add(new Wall(new Rectangle(0, 385, 400, 15), Color.BLACK));
            //east wall
            walls.add(new Wall(new Rectangle(385, 0, 15, 385), Color.BLACK));
            //north wall
            walls.add(new Wall(new Rectangle(0, 0, 385, 15), Color.BLACK));
            //west wall
            walls.add(new Wall(new Rectangle(0, 0, 15, 350), Color.BLACK));

            //GOAL BOX
            goal = new GoalBox(new Rectangle(365, 15, 20, 20), Color.GREEN);
        }

        if(level == 2)
        {
            //clears all obstacles
            upDownRects.clear();
            //clears walls
            walls.clear();
            //deletes previous upDownRects
            leftRightRects.clear();
            //clears lasers
            lasers.clear();


            //REMEMBER TO RESET THE ENTRANCE LOCATION HERE WITH BOT HX AND Y COORDINATES
            //MAIN PIECE
            player = new Player(new Rectangle(10, 30, 10, 10), Color.GREEN, 5, 10, 30, 10, 10);

            //UP DOWN RECTANGLES
            //up down 1
            upDownRects.add( new UpDownRect(new Rectangle(80, 200, 15, 15), Color.BLUE, UpDownRect.DOWN, 15, 385));
            //up down 2
            upDownRects.add( new UpDownRect(new Rectangle(120, 250, 15, 15), Color.BLUE, UpDownRect.UP, 15, 385));
            //up down 3
            upDownRects.add(new UpDownRect(new Rectangle(160, 15, 15, 15), Color.BLUE, UpDownRect.UP, 15, 385));
            //4th up down is not necessary
            //upDownRects.add( new UpDownRect(new Rectangle(200, 100, 20, 20), Color.BLUE, UpDownRect.UP, 15, 385));
            //new 4th up down
            upDownRects.add (new UpDownRect(new Rectangle(240, 250, 15, 15), Color.BLUE, UpDownRect.UP, 15, 385));
            //new 5th up down
            upDownRects.add (new UpDownRect(new Rectangle(280, 15, 15, 15), Color.BLUE, UpDownRect.UP, 15, 385));



            //LEFT TO RIGHT RECTANGLES
            //top left leftRightRec
            leftRightRects.add(new LeftRightRect(new Rectangle(40, 70, 15, 15), Color.BLUE, LeftRightRect.LEFT, 15, 200));
            //bottom right leftRightRec
            leftRightRects.add(new LeftRightRect(new Rectangle(215, 300, 15, 15), Color.BLUE, LeftRightRect.LEFT, 215, 385));
            //top right leftRightRec
            leftRightRects.add(new LeftRightRect(new Rectangle(215, 100, 15, 15), Color.BLUE, LeftRightRect.LEFT, 215, 385));



            //WALLS
            //south wall
            walls.add(new Wall(new Rectangle(0, 385, 400, 15), Color.BLACK));
            //east wall
            walls.add(new Wall(new Rectangle(385, 0, 15, 385), Color.BLACK));
            //north wall
            walls.add(new Wall(new Rectangle(0, 0, 385, 15), Color.BLACK));
            //west wall
            walls.add(new Wall(new Rectangle(0, 50, 15, 350), Color.BLACK));

            //MAZE WALLS
            walls.add(new Wall(new Rectangle(200, 15, 15, 180), Color.BLACK));
            walls.add(new Wall(new Rectangle(200, 250, 15, 110), Color.BLACK));

            //GOAL BOX
            goal = new GoalBox(new Rectangle(365, 15, 20, 20), Color.GREEN);
        }
        if(level == 3) {
            player = new Player(new Rectangle(10, 30, 10, 10), Color.GREEN, 5, 10, 30, 10, 10);

            //clears all obstacles
            upDownRects.clear();
            //clears walls
            walls.clear();
            //deletes previous upDownRects
            leftRightRects.clear();
            //clears lasers
            lasers.clear();

            //WALLS
            //south wall
            walls.add(new Wall(new Rectangle(0, 385, 400, 15), Color.BLACK));
            //east wall
            walls.add(new Wall(new Rectangle(385, 0, 15, 385), Color.BLACK));
            //north wall
            walls.add(new Wall(new Rectangle(0, 0, 385, 15), Color.BLACK));
            //west wall
            walls.add(new Wall(new Rectangle(0, 50, 15, 350), Color.BLACK));

            //3 PIECE MAZE
            //piece 1
            walls.add(new Wall(new Rectangle(150, 15, 15, 130), Color.BLACK));
            //piece 2
            walls.add(new Wall(new Rectangle(200, 235, 15, 150), Color.BLACK));
            //piece 3
            walls.add(new Wall(new Rectangle(300, 15, 15, 230), Color.BLACK));

            //PATTERN OBSTACLE
            //patterned 1
            patternRects.add(new PatternRect(new Rectangle(100, 150, 15, 15), Color.BLUE, 1, 100, 150, 100, 150, 150, 200, 15, 15));
            //patterned 2
            patternRects.add(new PatternRect(new Rectangle(230, 50, 15, 15), Color.BLUE, 1, 230, 50, 230, 285, 50, 200, 15, 15));

            //4 up down Rects
            //1
            upDownRects.add(new UpDownRect(new Rectangle(160, 145, 15, 15), Color.BLUE, UpDownRect.UP, 145, 385));
            //2
            upDownRects.add(new UpDownRect(new Rectangle(200, 145, 15, 15), Color.BLUE, UpDownRect.UP, 15, 235));
            //3
            upDownRects.add(new UpDownRect(new Rectangle(315, 145, 15, 15), Color.BLUE, UpDownRect.UP, 15, 385));
            //4
            upDownRects.add(new UpDownRect(new Rectangle(50, 145, 15, 15), Color.BLUE, UpDownRect.UP, 15, 385));

            //4 left right rects

            //1
            leftRightRects.add(new LeftRightRect(new Rectangle(15, 100, 15, 15), Color.BLUE, LeftRightRect.LEFT, 15, 150));
            //2
            leftRightRects.add(new LeftRightRect(new Rectangle(15, 80, 15, 15), Color.BLUE, LeftRightRect.LEFT, 15, 150));
            //3
            leftRightRects.add(new LeftRightRect(new Rectangle(15, 300, 15, 15), Color.BLUE, LeftRightRect.LEFT, 15, 200));

            //4
            leftRightRects.add(new LeftRightRect(new Rectangle(215, 300, 15, 15), Color.BLUE, LeftRightRect.LEFT, 215, 385));
        }
            if(level == 4)
        {
            player = new Player(new Rectangle(10, 30, 10, 10), Color.GREEN, 5, 10, 30, 10, 10);


            //clears all obstacles
            upDownRects.clear();
            //clears walls
            walls.clear();
            //deletes previous upDownRects
            leftRightRects.clear();
            //clears patternRects
            patternRects.clear();
            //clears lasers
            lasers.clear();

            //WALLS
            //south wall
            walls.add(new Wall(new Rectangle(0, 385, 400, 15), Color.BLACK));
            //east wall
            walls.add(new Wall(new Rectangle(385, 0, 15, 385), Color.BLACK));
            //north wall
            walls.add(new Wall(new Rectangle(0, 0, 385, 15), Color.BLACK));
            //west wall
            walls.add(new Wall(new Rectangle(0, 50, 15, 350), Color.BLACK));

            //4 PIECE MAZE
            //piece 1
            walls.add(new Wall(new Rectangle(120, 255, 15, 130), Color.BLACK));
            //piece 2
            walls.add(new Wall(new Rectangle(200, 15, 15, 260), Color.BLACK));
            //piece 3
            walls.add(new Wall(new Rectangle(280, 235, 15, 150), Color.BLACK));
            //piece 4
            walls.add(new Wall(new Rectangle(320, 15, 15, 150), Color.BLACK));

            //2 leftRightRects
            //1
            leftRightRects.add(new LeftRightRect(new Rectangle(15, 100, 15, 15), Color.BLUE, LeftRightRect.LEFT, 15, 200));
            //2
            leftRightRects.add(new LeftRightRect(new Rectangle(155, 320, 15, 15), Color.BLUE, LeftRightRect.LEFT, 135, 280));

            //2 upDownRects
            //1
            upDownRects.add(new UpDownRect(new Rectangle(115, 145, 15, 15), Color.BLUE, UpDownRect.UP, 15, 255));
            //2
            upDownRects.add(new UpDownRect(new Rectangle(200, 275, 15, 15), Color.BLUE, UpDownRect.UP, 275, 385));

            // 2 patternedRects
            //1
            patternRects.add(new PatternRect(new Rectangle(100, 150, 15, 15), Color.BLUE, 1, 100, 150, 100, 150, 150, 200, 15, 15));
            //2
            patternRects.add(new PatternRect(new Rectangle(300, 165, 15, 15), Color.BLUE, 1, 300, 165, 300, 350, 165, 215, 15, 15));

            //4 lasers
            //1
            lasers.add(new Laser(new Rectangle(215, 240, 65, 2), Color.RED));
            //2
            lasers.add(new Laser(new Rectangle(135, 260, 65, 2), Color.RED));
            //3
            lasers.add(new Laser(new Rectangle(135, 360, 145, 2), Color.RED));
            //4
            lasers.add(new Laser(new Rectangle(215, 160, 105, 2), Color.RED));


        }
        if(level == 5)
        {
            player = new Player(new Rectangle(10, 30, 10, 10), Color.GREEN, 5, 10, 30, 10, 10);

            //clears all obstacles
            upDownRects.clear();
            //clears walls
            walls.clear();
            //deletes previous upDownRects
            leftRightRects.clear();
            //clears patternRects
            patternRects.clear();
            //clears lasers
            lasers.clear();

            //WALLS
            //south wall
            walls.add(new Wall(new Rectangle(0, 385, 400, 15), Color.BLACK));
            //east wall
            walls.add(new Wall(new Rectangle(385, 0, 15, 385), Color.BLACK));
            //north wall
            walls.add(new Wall(new Rectangle(0, 0, 385, 15), Color.BLACK));
            //west wall
            walls.add(new Wall(new Rectangle(0, 50, 15, 350), Color.BLACK));

            //5 PIECE MAZE
            //piece 1
            walls.add(new Wall(new Rectangle(50, 15, 15, 130), Color.BLACK));
            //piece 2
            walls.add(new Wall(new Rectangle(200, 235, 15, 150), Color.BLACK));
            //piece 3
            walls.add(new Wall(new Rectangle(250, 15, 15, 130), Color.BLACK));
            //piece 4
            walls.add(new Wall(new Rectangle(300, 215, 15, 110), Color.BLACK));
            //piece 5
            walls.add(new Wall(new Rectangle(120, 115, 15, 160), Color.BLACK));

            //2 leftRightRects
            //1
            leftRightRects.add(new LeftRightRect(new Rectangle(15, 100, 15, 15), Color.BLUE, LeftRightRect.LEFT, 15, 50));
            //2
            leftRightRects.add(new LeftRightRect(new Rectangle(215, 300, 15, 15), Color.BLUE, LeftRightRect.LEFT, 215, 300));

            //2 Updown rects
            //1
            upDownRects.add(new UpDownRect(new Rectangle(115, 15, 15, 15), Color.BLUE, UpDownRect.UP, 15, 115));
            //2
            upDownRects.add(new UpDownRect(new Rectangle(50, 145, 15, 15), Color.BLUE, UpDownRect.UP, 145, 385));

            // 2 patternedRects
            //1
            patternRects.add(new PatternRect(new Rectangle(150, 100, 15, 15), Color.BLUE, 1, 150, 100, 150, 200, 100, 150, 15, 15));
            //2
            patternRects.add(new PatternRect(new Rectangle(200, 150, 15, 15), Color.BLUE, 1, 200, 150, 200, 250, 150, 200, 15, 15));

            //6 LASERS
            //1
            lasers.add(new Laser(new Rectangle(215, 240, 85, 2), Color.RED));
            //2
            lasers.add(new Laser(new Rectangle(315, 240, 70, 2), Color.RED));
            //3
            lasers.add(new Laser(new Rectangle(135, 240, 65, 2), Color.RED));
            //4
            lasers.add(new Laser(new Rectangle(135, 260, 65, 2), Color.RED));
            //5
            lasers.add(new Laser(new Rectangle(135, 130, 115, 2), Color.RED));
            //6
            lasers.add(new Laser(new Rectangle(65, 130, 55, 2), Color.RED));
        }
    }
}
