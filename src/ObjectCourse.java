public class ObjectCourse {
    public static void main(String[] args) {
        //Car dacia1300 = new Car();
        Car vwPassat = new Car ();
//        dacia1300.printCar();
//
//        dacia1300.color = "RED";
//        dacia1300.carType = "Sedan";
//        dacia1300.model = "Dacia 1300";
//        dacia1300.cylinderCapacity= 1300;
//        dacia1300.carPosition = 45;

        Car dacia1300 = new Car("sedan", "RED", "dacia 1300", 1300, 45 );

        dacia1300.startCar();
        dacia1300.accelerate(20);
        dacia1300.gearUp();
        dacia1300.steerRight(45);
        dacia1300.increaseMileage(5);
        dacia1300.stopCar();

    dacia1300.setSpeed(5000);
    System.out.println(dacia1300.getSpeed());


        dacia1300.printCar();


        Square squareabcd = new Square();
        squareabcd.setSide(5);
        //System.out.println("Square with side " + squareabcd.squareSide + "has area of " + squareabcd.getArea());
        squareabcd.printCurrentSquare();


        for(String value : args){
          Square cmdSquare = new Square();
          cmdSquare.setSide(Double.parseDouble(value));
            //System.out.println("Square with side " + cmdSquare.squareSide + "has area of " + cmdSquare.getArea());
          cmdSquare.printCurrentSquare();
        }
    Rectangle rectangle = new Rectangle(5,10);
        System.out.println("area is " + rectangle.getArea() + " diagonal is " + rectangle.getDiagonal() + " perimeter is " + rectangle.getPerimeter());


    }
}
