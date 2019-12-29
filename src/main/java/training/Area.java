package training;

public class Area

{
 
   public double  getAreaforAllShapes()
 {

  
      Shapes type[]=new Shapes[3];
      
  type[0]= new Rectangle(10, 4);
   
     type[1] = new Square(7);
      
   type[2] = new Circle(3.5);

System.out.println("Rectangle Area : " + type[0].getArea());
 
System.out.println("Square Area : " + type[1].getArea());

System.out.println("Circle Area : " + type[2].getArea());
  
    
  System.out.println();
     return 0;
 }
}
