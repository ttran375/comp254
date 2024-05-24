import java.util.Arrays;

public class DemoClass {
    public static void main(String[] args) {
        // int[] data = { 12 };
        // int[] backup;
        // backup = data;
        // data[0] = 11;
        // System.out.println(backup[0]);

        // System.out.println(data == backup);

        // int[] data = { 12 };
        // int[] backup = new int[1];
        // data[0] = 11;
        // System.out.println(data.equals(backup));

        int[] data = { 12 };
        int[] backup = new int[1];
        backup[0] = 12;
        System.out.println(Arrays.equals(data, backup));
    }
}
