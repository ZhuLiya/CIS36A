/* Liya Zhu, CIS 36A
    02/24/2022 */
import objectdraw.*;
import java.util.Random;

public class Breakout extends ActiveObject{
    private Random rand = new Random();
    private DrawingCanvas canvas;

    private FilledOval ball;
    private double randomXSpeed, ySpeed;
    private int lives = BreakoutProgram.NTURNS;
    private int scores = 0;
    private Text scoreLabel, showScore, liveLabel, showLive;
    private Text win, lose;

    private void setRandomXSpeed(){
        randomXSpeed = rand.nextDouble() * (BreakoutProgram.VELOCITY_X_MAX + BreakoutProgram.VELOCITY_X_MAX) - BreakoutProgram.VELOCITY_X_MAX; // (MAX - (-MAX)) + (-MAX)
        while (randomXSpeed > ( 0 - BreakoutProgram.VELOCITY_X_MIN) && randomXSpeed < BreakoutProgram.VELOCITY_X_MIN){ // exclude min
            randomXSpeed = rand.nextDouble() * (BreakoutProgram.VELOCITY_X_MAX + BreakoutProgram.VELOCITY_X_MAX) - BreakoutProgram.VELOCITY_X_MAX;
        }
    }

    private void hitBrick(){
        for (int i = 0; i < BreakoutProgram.NBRICK_ROWS; i++){
            for (int j = 0; j < BreakoutProgram.NBRICK_COLUMNS; j++){
                if (BreakoutController.bricks[i][j].overlaps(ball)){
                    BreakoutController.bricks[i][j].moveTo(BreakoutProgram.CANVAS_WIDTH * 2, BreakoutProgram.CANVAS_HEIGHT * 2);
                    BreakoutController.bricks[i][j].hide();
                    scores++;
                    showScore.removeFromCanvas();
                    showScore = new Text(scores + ",", scoreLabel.getWidth() + 5, scoreLabel.getHeight() + 5, canvas);
                    ySpeed = 0 - ySpeed;
                }
            }
        }

    }

    public Breakout(DrawingCanvas aCanvas){
        canvas = aCanvas;

        //set up the texts
        scoreLabel = new Text("Score:", 0, 0, canvas);
        scoreLabel.setFont(BreakoutProgram.SCREEN_FONT);
        scoreLabel.moveTo(0, scoreLabel.getHeight() + 5);

        showScore = new Text(scores + ",", scoreLabel.getWidth() + 5, scoreLabel.getY(), canvas);
        showScore.setFont(BreakoutProgram.SCREEN_FONT);

        liveLabel = new Text("Turns:", showScore.getX() + showScore.getWidth() + 15, scoreLabel.getY(), canvas);
        liveLabel.setFont(BreakoutProgram.SCREEN_FONT);

        showLive = new Text(lives, liveLabel.getX() + liveLabel.getWidth() + 5, scoreLabel.getY(), canvas);
        showLive.setFont(BreakoutProgram.SCREEN_FONT);

        win = new Text("YOU WIN!", canvas.getWidth(), canvas.getHeight(), canvas);
        win.setFont(BreakoutProgram.SCREEN_FONT);
        win.hide();

        lose = new Text("Game Ends :(", canvas.getWidth(), canvas.getHeight(), canvas);
        lose.setFont(BreakoutProgram.SCREEN_FONT);
        lose.hide();

        //set up ball
        ball = new FilledOval((BreakoutProgram.CANVAS_WIDTH - BreakoutProgram.BALL_RADIUS) / 2, (BreakoutProgram.CANVAS_HEIGHT - BreakoutProgram.BALL_RADIUS) / 2,
                                    BreakoutProgram.BALL_RADIUS, BreakoutProgram.BALL_RADIUS, canvas);

        start();
    }
    public void run(){
        ySpeed = BreakoutProgram.VELOCITY_Y;
        setRandomXSpeed();

        while (lives > 0){


            ball.move(randomXSpeed, ySpeed);
            pause(BreakoutProgram.DELAY);

            if (ball.getX() <= 0 || (ball.getX() + ball.getWidth()) >= canvas.getWidth()){ // if hit left or right
                randomXSpeed = 0 - randomXSpeed;
            }

            if (ball.getY() <= 0){ // if hit top
                ySpeed = 0 - ySpeed;
            }

            if (ball.getY() + ball.getHeight() >= canvas.getHeight()){ // if falls
                lives -= 1;
                showLive.removeFromCanvas();
                showLive = new Text(lives, liveLabel.getX() + liveLabel.getWidth() + 5, scoreLabel.getY(), canvas);
                ball.moveTo((BreakoutProgram.CANVAS_WIDTH - BreakoutProgram.BALL_RADIUS) / 2, (BreakoutProgram.CANVAS_HEIGHT - BreakoutProgram.BALL_RADIUS) / 2);
                setRandomXSpeed();
            }

            /*for some unknown wired reason, if I use overlaps() for checking if hits paddle it sometimes run in to a weird bug, the ball will bounce in the paddle for a while */
            if (ball.getY() + ball.getHeight() >= BreakoutController.paddle.getY() && ball.getX() >= BreakoutController.paddle.getX() &&
                    ball.getX() + ball.getWidth() <= BreakoutController.paddle.getX() + BreakoutController.paddle.getX() + BreakoutController.paddle.getWidth()){ //if hit the paddle
                ySpeed = 0 - ySpeed;
            }
            hitBrick();
            if (scores >= BreakoutProgram.NBRICK_ROWS * BreakoutProgram.NBRICK_COLUMNS){ // if wins
                ball.hide();
                BreakoutController.paddle.hide();
                win.moveTo((canvas.getWidth() - win.getWidth()) / 2, (canvas.getHeight() - win.getHeight()) / 2);
                win.show();
                break;
            }

        }
        if (lives == 0){ // if loses
            ball.hide();
            BreakoutController.paddle.hide();
            lose.moveTo((canvas.getWidth() - lose.getWidth()) / 2, (canvas.getHeight() - lose.getHeight()) / 2);
            lose.show();
        }
    }
}
