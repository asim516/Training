
/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package training;


public class App {

    public String getGreeting() {
        return "Hello consortium world.";
    }

    public static void main(String[] args) throws InterruptedException {
       
        TableCreator tc =new TableCreator();

        String accessId = System.getenv("AWS_ACCESS_KEY_ID");
        String accessSecret= System.getenv("AWS_SECRET_ACCESS_KEY");
InsertItems item=new InsertItems();
        tc.createTable(accessId,accessSecret);
      item.putItem();
        System.out.println(new App().getGreeting());

        System.out.println(new Area().getAreaforAllShapes());
        System.out.print(new Employees().obj.toJSONString());


            }
}
