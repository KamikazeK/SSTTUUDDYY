import java.util.ArrayList;
import java.util.Collections;

public class TextComparableGeometricObject {
    public static void main(String[] args) {
        ArrayList<ComparableGeometricObject> list = new ArrayList<>();
        list.add(new Circle(3));
        list.add(new Rectangle(9,6));
        list.add(new TriAngle(6,7));
        list.add(new Circle(5));
        list.add(new Rectangle(10,8));
        list.add(new TriAngle(7,9));

        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getArea());
        }
    }
}
abstract class GeometricObject{
    public abstract double getArea();
    public abstract void show();
}

abstract class ComparableGeometricObject extends GeometricObject implements Comparable<ComparableGeometricObject>{
    @Override
    public int compareTo(ComparableGeometricObject o) {
        return (int) (o.getArea() - this.getArea());
    }
}

class Circle extends ComparableGeometricObject{
    private double radius;
    public Circle(double radius){
        this.radius = radius;
    }
    public double getRadius(){
        return radius;
    }
    public void setRadius(double radius){
        this.radius = radius;
    }
    public double getArea(){
        return radius * radius * Math.PI;
    }
    public void show(){
        System.out.println("半径为" + radius + "的圆");
    }
}

class Rectangle extends ComparableGeometricObject{
    private double length;//长
    private double width;//宽
    public Rectangle(double length,double width){
        this.length = length;
        this.width = width;
    }
    public double getLength(){
        return length;
    }
    public void setLength(double length){
        this.length = length;
    }
    public double getWidth(){
        return width;
    }
    public void setWidth(double width){
        this.width = width;
    }
    public double getArea(){
        return length * width;
    }
    public void show(){
        System.out.println("长为" + length + ",宽为" + width + "的矩形");
    }
}

class TriAngle extends ComparableGeometricObject{
    private double length;
    private double high;
    public TriAngle(double length,double high){
        this.length = length;
        this.high = high;
    }
    public double getLength(){
        return length;
    }
    public void setLength(double length){
        this.length = length;
    }
    public double getHigh(){
        return high;
    }
    public void setHigh(double high){
        this.high = high;
    }
    public double getArea(){
        return (length * high)/2;
    }
    public void show(){
        System.out.println("底边长为" + length + "，高为" + high + "的三角形");
    }
}

