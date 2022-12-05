import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        DynamicArray array = new DynamicArray();
        array.insert(1);
        array.insert(2);
        array.insert(4);
        array.insert(3);
        array.insert(9);
        array.insert(10);
        array.insert(11);
        array.insert(12);
        array.insert(13);
        array.insert(14);
        array.insert(15);

        System.out.println(Arrays.toString(array.getDataBin()));
        System.out.println(array.search(0));;


    }
}