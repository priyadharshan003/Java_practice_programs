public class Mem_manage {
    int num;
    String Pri;
}
class Main extends Mem_manage{
    static Mem_manage var1 = new Mem_manage();

     static String var2 = new String("pri"+"ya");

    public static void main(String[] args) {
        System.out.println(var2.length());
        System.out.println(var1);
    }

}
