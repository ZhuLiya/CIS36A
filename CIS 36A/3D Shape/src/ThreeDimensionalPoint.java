/*  Liya Zhu, CIS 36A, 3D Shapes
    03/01/2022
*/

public class ThreeDimensionalPoint {

    private float xCoord, yCoord, zCoord;

    public ThreeDimensionalPoint(float xCoord, float yCoord, float zCoord){
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.zCoord = zCoord;
    }
    public ThreeDimensionalPoint(){
        xCoord = 0;
        yCoord = 0;
        zCoord = 0;
    }

    public ThreeDimensionalPoint point = new ThreeDimensionalPoint();

    public float getxCoord() {
        return xCoord;
    }

    public float getyCoord() {
        return yCoord;
    }

    public float getzCoord() {
        return zCoord;
    }

    public boolean equals(ThreeDimensionalPoint point){
        return (this.point.equals(point));
    }

    public void setxCoord(float xCoord) {
        this.xCoord = xCoord;
    }

    public void setyCoord(float yCoord) {
        this.yCoord = yCoord;
    }

    public void setzCoord(float zCoord) {
        this.zCoord = zCoord;
    }

    public void moveTo(float xCoord, float yCoord, float zCoord){
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.zCoord = zCoord;
    }
}

