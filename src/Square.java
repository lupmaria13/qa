import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Square extends Rectangle {
//@Setter @Getter
//    private double side;
    //private static int ceva=0;
//    public void setSide(double side){
//        this.side = this.side;
//    }

    public Square(double side){
        super(side, side);
    }

    public double getArea(){
       // return squareSide * squareSide;
        //return Math.pow(side, 2);
        return super.getArea();
    }

    public void printCurrentSquare(){
        System.out.println("Square with side " + getLength() + "has area of " + getArea());
    }
@Override
    public void draw(){
        System.out.println("Drawing a square");
    }
    @Override
    public String toString() {
        return "My Square has 4 sides each " + this.getLength();

    }

    public void setSide(double i) {
        super.setLength(i);
        super.setWidth(i);
    }
}
