import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Student  extends Person{
    private double[] grades;

    public void takeExam(){
        System.out.println(" The student attends the exam ");
    }

}
