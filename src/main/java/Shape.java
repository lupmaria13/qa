import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor
public class Shape extends AbstractShape implements IShape{
    @Getter @Setter
    private String color;


    public void draw(){
        System.out.println("Drawing shape");
    }

    public void erase(){
        System.out.println("erasing a shape");
    }

    @Override
    public void myMethod() {

    }
}
