
/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package training;

public class App {

    public static void main(String[] args) throws InterruptedException {


        ItemsCreator item = new ItemsCreator();

        item.putItem();
        System.out.println(new App().getGreeting());

        System.out.println(new Area().getAreaforAllShapes());
        System.out.print(new Employees().obj.toJSONString());
       AddingData add= new AddingData();
       add.save();

    }

    public String getGreeting() {
        return "Hello consortium world.";
    }
}
