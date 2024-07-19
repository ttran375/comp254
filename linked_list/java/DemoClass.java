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

        // int[] data = { 1,2 };
        // int[] backup = new int[1];
        // backup[0] = 12;
        // System.out.println(Arrays.equals(data, backup));

        // int[][] data = { { 1, 2 }, { 3, 4 } };
        // int[][] backup = new int[2][2];
        // backup[0][0] = 1;
        // backup[0][1] = 2;
        // backup[1][0] = 3;
        // backup[1][1] = 4;
        // System.out.println(data == backup);
        // System.out.println(data.equals(backup));
        // System.out.println(Arrays.equals(data, backup));
        // System.out.println(Arrays.deepEquals(data, backup));

        // int[] data = { 1, 2 };
        // int[] backup;
        // backup = data;
        // data[0] = 11;
        // System.out.println(backup[0]);

        // System.out.println(data == backup);
        // System.out.println(data.equals(backup));
        // System.out.println(Arrays.equals(data, backup));
        // // System.out.println(Arrays.deepEquals(data, backup));

        // int[] data = { 1, 2 };
        // int[] backup;
        // backup = data.clone();
        // data[0] = 11;
        // System.out.println(backup[0]);

        // System.out.println(data == backup);
        // System.out.println(data.equals(backup));
        // System.out.println(Arrays.equals(data, backup));
        // // System.out.println(Arrays.deepEquals(data, backup));

        // int[][] data = { { 1, 2 }, { 3, 4 } };
        // int[][] backup;
        // backup = data.clone();
        // data[0][0] = 11;
        // System.out.println(backup[0][0]);

        // System.out.println(data == backup);
        // System.out.println(data.equals(backup));
        // System.out.println(Arrays.equals(data, backup));
        // // System.out.println(Arrays.deepEquals(data, backup));

        int[][] data = { { 1, 2 }, { 3, 4 } };
        int[][] backup = new int[data.length][];
        backup[0] = data[0].clone();
        backup[1] = data[1].clone();
        data[0][0] = 11;
        System.out.println(backup[0][0]);

        System.out.println(data == backup);
        System.out.println(data.equals(backup));
        System.out.println(Arrays.equals(data, backup));
        // System.out.println(Arrays.deepEquals(data, backup));
    }
}
