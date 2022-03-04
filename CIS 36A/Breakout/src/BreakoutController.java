/* Liya Zhu, CIS 36A
    02/24/2022 */
import objectdraw.*;
import java.awt.*;

public class BreakoutController extends WindowController{

    public static FilledRect paddle;
    final double BRICK_X_OFFSET = (BreakoutProgram.CANVAS_WIDTH - ((BreakoutProgram.BRICK_SEP * (BreakoutProgram.NBRICK_COLUMNS - 1)) + (BreakoutProgram.NBRICK_COLUMNS * BreakoutProgram.BRICK_WIDTH)) )/ 2;
    private Color[] colorList = new Color[BreakoutProgram.NBRICK_ROWS];
    public static FilledRect[][] bricks = new FilledRect[BreakoutProgram.NBRICK_ROWS][BreakoutProgram.NBRICK_COLUMNS];

    private void setColorList(){
        for (int i = 0; i < BreakoutProgram.NBRICK_ROWS; i++){
            if (i % 10 == 0 || 1 % 10 == 1) {
                colorList[i] = Color.RED;
            }
            if (i % 10 == 2 || i % 10 == 3){
                colorList[i] = Color.ORANGE;
            }
            if (i % 10 == 4 || i % 10 == 5){
                colorList[i] = Color.YELLOW;
            }
            if (i % 10 == 6 || i % 10 == 7){
                colorList[i] = Color.GREEN;
            }
            if (i % 10 == 8 || i % 10 == 9){
                colorList[i] = Color.CYAN;
            }
        }
    }

    private void drawBricks(){
        setColorList();
        for (int i = 0; i < BreakoutProgram.NBRICK_ROWS; i++){
            for (int j = 0; j < BreakoutProgram.NBRICK_COLUMNS; j++){
               bricks[i][j] = new FilledRect(BRICK_X_OFFSET + (BreakoutProgram.BRICK_SEP + BreakoutProgram.BRICK_WIDTH) * j, BreakoutProgram.BRICK_Y_OFFSET + (BreakoutProgram.BRICK_SEP + BreakoutProgram.BRICK_HEIGHT) * i,
                        BreakoutProgram.BRICK_WIDTH, BreakoutProgram.BRICK_HEIGHT, colorList[i], canvas);
            }
        }

    }

    private void drawPaddle(){
        paddle = new FilledRect((BreakoutProgram.CANVAS_WIDTH - BreakoutProgram.PADDLE_WIDTH) / 2, BreakoutProgram.CANVAS_HEIGHT - BreakoutProgram.PADDLE_Y_OFFSET, BreakoutProgram.PADDLE_WIDTH,BreakoutProgram.PADDLE_HEIGHT, canvas);
    }

    public void onMouseDrag(Location point){ // move paddle along with mouse
        paddle.moveTo((point.getX() - (BreakoutProgram.PADDLE_WIDTH / 2)), BreakoutProgram.CANVAS_HEIGHT - BreakoutProgram.PADDLE_Y_OFFSET);
        if (paddle.getX() <= 0){
            paddle.moveTo(0, BreakoutProgram.CANVAS_HEIGHT - BreakoutProgram.PADDLE_Y_OFFSET);
        }
        if (paddle.getX() + BreakoutProgram.PADDLE_WIDTH >= BreakoutProgram.CANVAS_WIDTH ){
            paddle.moveTo(BreakoutProgram.CANVAS_WIDTH - BreakoutProgram.PADDLE_WIDTH, BreakoutProgram.CANVAS_HEIGHT - BreakoutProgram.PADDLE_Y_OFFSET);
        }
    }

    public void begin(){
        drawBricks();
        drawPaddle();
        new Breakout(canvas);
    }


    public static void main(String[] args) {
        new BreakoutController().startController(BreakoutProgram.CANVAS_WIDTH, BreakoutProgram.CANVAS_HEIGHT);
    }
}
