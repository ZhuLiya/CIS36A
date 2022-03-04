//Liya Zhu, CIS 36A, Mon Wed 9-12
import objectdraw.*;
import java.util.Scanner;

public class BouncingBallController extends WindowController{

    public void begin(){
        new Text("Click to make a new bouncing ball", 10, 20, canvas);
    }

    public void onMouseClick(Location point){
        new BouncingBall(point, canvas);
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Please enter the width and height of the window: ");
        int width = keyboard.nextInt();
        int height = keyboard.nextInt();

        new BouncingBallController().startController(width, height);
    }
}
