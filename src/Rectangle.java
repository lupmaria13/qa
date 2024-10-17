import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor @AllArgsConstructor

public class Rectangle extends Shape{
    @Getter @Setter
    private double length;
    @Getter @Setter
    private double width;

//    public Rectangle(double length, double width) {
//        this.length = length;
//        this.width = width;
//    }

    public double getArea(){
      return this.length * this.width;
    }

    public double getPerimeter(){
      return Math.sqrt(Math.pow(length, 2) + Math.pow(width, 2));
    }

    public double getDiagonal(){
    return 2* (length + width);
    }

    @Override
    public void draw(){
        //super.draw(); // apeleaza si metoda din clasa parinte
        System.out.println("Drawing a rectangle");
    }
}
