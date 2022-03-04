import objectdraw.*;

class ExpandingDiamond extends WindowController{
    public static final int CANVAS_HEIGHT = 400;
    public static final int CANVAS_WIDTH = 400;

    private int startPoint = 0;

    private Line line1,line2,line3,line4;

    public void onMouseClick(Location point){
        line1.move(-2, -2);
        line2.move(2, -2);
        line3.move(-2, 2);
        line4.move(2, 2);
    }

    public void begin () {
        line1 = new Line(startPoint, CANVAS_HEIGHT / 2, CANVAS_WIDTH / 2, startPoint, canvas);
        line2 = new Line(CANVAS_WIDTH / 2, startPoint, CANVAS_WIDTH, CANVAS_HEIGHT / 2, canvas);
        line3 = new Line(startPoint, CANVAS_HEIGHT / 2, CANVAS_WIDTH / 2, CANVAS_HEIGHT, canvas);
        line4 = new Line(CANVAS_WIDTH / 2, CANVAS_HEIGHT, CANVAS_WIDTH, CANVAS_HEIGHT /2, canvas);
    }

    public static void main(String[] args) {
        new ExpandingDiamond().startController(CANVAS_WIDTH, CANVAS_HEIGHT);
    }
}

