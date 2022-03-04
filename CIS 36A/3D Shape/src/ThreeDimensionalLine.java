/*  Liya Zhu, CIS 36A, 3D Shapes
    03/01/2022
*/
import java.lang.Math;
public class ThreeDimensionalLine{
    private ThreeDimensionalPoint startPoint, endPoint;

    public ThreeDimensionalLine(ThreeDimensionalPoint startPoint, ThreeDimensionalPoint endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public ThreeDimensionalLine(){
        startPoint = new ThreeDimensionalPoint(0, 0, 0);
        endPoint = new ThreeDimensionalPoint(0, 0, 0);
    }

    public ThreeDimensionalLine line= new ThreeDimensionalLine();

    public ThreeDimensionalPoint getStartPoint() {
        return startPoint;
    }

    public ThreeDimensionalPoint getEndPoint() {
        return endPoint;
    }

    public double getLength(){
        double length;
        double x = (double)(endPoint.getxCoord() - startPoint.getxCoord());
        double y = (double)(endPoint.getyCoord() - startPoint.getyCoord());
        double z = (double)(endPoint.getzCoord() - startPoint.getzCoord());
        length = Math.sqrt(x * x + y * y + z * z);
        return length;
    }


    public void setStartPoint(ThreeDimensionalPoint startPoint) {
        this.startPoint = startPoint;
    }

    public void setEndPoint(ThreeDimensionalPoint endPoint) {
        this.endPoint = endPoint;
    }

    public boolean equals(ThreeDimensionalLine line){
        return (this.line.startPoint.equals(line.startPoint) && this.line.endPoint.equals(line.endPoint));
    }
}
