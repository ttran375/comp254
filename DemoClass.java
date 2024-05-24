public class DemoClass {
    public static void main(String[] args) {
        int[] data = { 12 };
        int[] backup;
        backup = data;
        data[0] = 11;
        System.out.println(backup[0]);
    }
}
