package example.app;

class App {
    public static void main(String[] args) {
        addingOperation ad1 = (a, b) -> a + a + b;
        System.out.println(ad1.add(3, 2));

    }
}
interface addingOperation
{
    int add(int a, int b);
}