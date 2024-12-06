public class ArrayExample {
    public static void main(String[] args) {
        int[] array = {10, 20, 30, 40, 50};

        // Access an element (O(1))
        System.out.println("Element at index 2: " + array[2]);

        // Insert an element at index 2 (O(n))
        int insertValue = 25;
        int index = 2;
        int[] newArray = new int[array.length + 1];
        for (int i = 0, j = 0; i < array.length; i++, j++) {
            if (j == index) {
                newArray[j++] = insertValue; // Insert new value
            }
            newArray[j] = array[i];
        }
        System.out.println("Array after insertion: " + java.util.Arrays.toString(newArray));
    }
}
