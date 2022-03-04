//Liya Zhu, CIS 36A, Mon Wed 9-12
import objectdraw.ActiveObject;
import objectdraw.DrawingCanvas;
import objectdraw.FilledOval;
import objectdraw.Location;
import java.awt.*;
import java.util.Random;

public class BouncingBall extends ActiveObject {
    private Random rand = new Random();

    private static final int SIZE_MIN = 10;
    private static final int SIZE_MAX = 31;
    private static final int SPEED_MIN = 2;
    private static final int SPEED_MAX = 11;
    private static final int COLOR_RANGE = 255;
    private int randomSize, randomXSpeed, randomYSpeed;
    private Color randomColor;

    private static final int DELAY_TIME = 30;

    private FilledOval circle;
    private DrawingCanvas canvas;

    private int setRandomSpeed(){
        int speed;
        speed = rand.nextInt(SPEED_MAX + SPEED_MAX) -SPEED_MAX; // SPEED_MAX - (-SPEED_MAX) + (-SPEED_MAX),  max in different direction
        while (speed > ( 0 - SPEED_MIN) && speed < SPEED_MIN){//limit to be greater than min in different direction
            speed = rand.nextInt(SPEED_MAX + SPEED_MAX) -SPEED_MAX;
        }
        return speed;
    }

    public BouncingBall(Location initialLocation, DrawingCanvas aCanvas){
        randomSize = rand.nextInt(SIZE_MAX - SIZE_MIN) + SIZE_MIN;
        randomColor = new Color (rand.nextInt(COLOR_RANGE),
                                    rand.nextInt(COLOR_RANGE),
                                    rand.nextInt(COLOR_RANGE));//random r, g, b, and not white
        canvas = aCanvas;
        circle = new FilledOval(initialLocation, randomSize, randomSize, randomColor, canvas);
        start();
    }

    public void run() {
        randomXSpeed = setRandomSpeed();
        randomYSpeed = setRandomSpeed();
        while (true) {
            circle.move(randomXSpeed, randomYSpeed);
            pause(DELAY_TIME);
            if (circle.getY() <= 0 || (circle.getY() + circle.getHeight()) >= canvas.getHeight()) {//if hit top or bottom
                randomYSpeed = 0 - randomYSpeed;
            }
            if (circle.getX() <= 0 || (circle.getX() + circle.getWidth()) >= canvas.getWidth()) {//if hit left or right
                randomXSpeed = 0 - randomXSpeed;
            }
        }
    }
}
