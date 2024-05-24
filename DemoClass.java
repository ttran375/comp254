public class DemoClass {
    public static void main(String[] args) {
        int data, backup;
        data = 12;
        backup = data;
        backup = data;
        data = 11;
        System.out.println(backup);
    }
}
