//Liya Zhu, CIS 36A, Mon Wed 9-12
import objectdraw.*;

public class BroomBall extends WindowController{
    private FilledOval ball;
    private FilledRect box;
    public static final int BALL_RAD = 10;
    public static final int BOX_LENGTH= 30;
    public static final int CANVAS_HEIGHT = 600;
    public static final int CANVAS_WIDTH = 600;


    private boolean touchLeft(){
        return(ball.getX() + BALL_RAD > box.getX() && ball.getX() < box.getX() &&
                ball.getY() >= box.getY()  && ball.getY() + BALL_RAD <= box.getY() + BOX_LENGTH);
    }
    private boolean touchRight(){
        return(ball.getX() + BALL_RAD > box.getX() +BOX_LENGTH && ball.getX() < box.getX() + BOX_LENGTH &&
                ball.getY() >= box.getY()  && ball.getY() + BALL_RAD <= box.getY() + BOX_LENGTH);
    }
    private boolean touchTop(){
        return(ball.getY() + BALL_RAD > box.getY() && ball.getY() < box.getY() &&
                ball.getX() > box.getX() && ball.getX() + BALL_RAD < box.getX() + BOX_LENGTH);
    }
    private boolean touchBottom(){
        return(ball.getY() + BALL_RAD > box.getY() + BOX_LENGTH && ball.getY() < box.getY() +BOX_LENGTH &&
                ball.getX() > box.getX() && ball.getX() + BALL_RAD < box.getX() + BOX_LENGTH);
    }

    public void onMousePress(Location point){
        ball.moveTo(point);
        ball.show();
    }
    public void onMouseRelease(Location point){
        ball.hide();
    }

    public void onMouseDrag(Location point){
        ball.moveTo(point);
        if (touchLeft()){
            box.moveTo((point.getX() + BALL_RAD), ball.getY() + box.getY() - point.getY());
        }
        if (touchRight()){
            box.moveTo(point.getX() - BOX_LENGTH, ball.getY() + box.getY() - point.getY());
        }
        if (touchTop()){
            box.moveTo(point.getX() - ball.getX() + box.getX(), point.getY() + BALL_RAD);
        }
        if (touchBottom()){
            box.moveTo(point.getX() - ball.getX() + box.getX(), point.getY() - BOX_LENGTH);
        }

    }

    public void onMouseExit(Location point){
        box.moveTo(CANVAS_WIDTH / 2 - BOX_LENGTH /2, CANVAS_HEIGHT / 2 - BOX_LENGTH / 2);
    }

    public void begin(){
        ball = new FilledOval(-100, -100, BALL_RAD, BALL_RAD, canvas);
        ball.hide();
        box = new FilledRect(CANVAS_WIDTH / 2 - BOX_LENGTH /2, CANVAS_HEIGHT / 2 - BOX_LENGTH / 2, BOX_LENGTH, BOX_LENGTH, canvas);
    }

    public static void main(String[] args) {
        new BroomBall().startController(CANVAS_WIDTH, CANVAS_HEIGHT);
    }
}
