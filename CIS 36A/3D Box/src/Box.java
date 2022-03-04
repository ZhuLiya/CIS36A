import objectdraw.*;

public class Box extends WindowController{

    public void begin(){
        new FramedRect(30.00, 30.00, 100.00, 100.00, canvas);
        new Line(30, 30, 60, 10, canvas);
        new Line(60, 10, 160, 10, canvas);
        new Line(130, 30, 160, 10, canvas);
        new Line(130, 130, 160, 110, canvas);
        new Line(160, 10,160, 110, canvas);
    }

    public static void main(String[] args) {
        new Box().startController(170, 170);
    }
}
