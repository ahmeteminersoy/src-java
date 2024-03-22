public class Main {
    public static void main(String[] args) {

    }
    public static void run()
    {

    }
}
class A{
    A(String a)
    {
        System.out.println();
    }
    A()
    {

    }
}
class B extends A implements IX{

    public int startEngine() {

        return 0;
    }
}
interface IX{
    int a = 10;

    default int startEngine() {
        return 0;
    }
}