import objectdraw.*;

public class CenteredDiamonds extends WindowController{
    public static final int CANVAS_HEIGHT = 400;
    public static final int CANVAS_WIDTH = 400;

    private int startPoint = 0;
    private Line lineupR, lineupL, linedownR, linedownL, lineLeft, lineRight;

    public void begin(){
        lineupL = new Line(startPoint, CANVAS_HEIGHT / 2, CANVAS_WIDTH / 2, startPoint, canvas);
        lineupR = new Line(CANVAS_WIDTH / 2, startPoint, CANVAS_WIDTH, CANVAS_HEIGHT / 2, canvas);
        linedownL = new Line(startPoint, CANVAS_HEIGHT / 2, CANVAS_WIDTH / 2, CANVAS_HEIGHT, canvas);
        linedownR = new Line(CANVAS_WIDTH / 2, CANVAS_HEIGHT, CANVAS_WIDTH, CANVAS_HEIGHT /2, canvas);
        lineLeft = new Line(CANVAS_WIDTH / 4, CANVAS_HEIGHT / 4, CANVAS_WIDTH * 3 / 4, CANVAS_HEIGHT * 3 / 4, canvas);
        lineRight = new Line(CANVAS_WIDTH * 3 / 4, CANVAS_HEIGHT / 4, CANVAS_WIDTH / 4, CANVAS_HEIGHT *3 / 4, canvas);
    }

    public static void main(String[] args) {
        new CenteredDiamonds().startController(CANVAS_WIDTH, CANVAS_HEIGHT);
    }
}
