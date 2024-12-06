public class LinearSearch {

    // Phương thức tìm kiếm tuyến tính
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            // So sánh phần tử hiện tại với giá trị mục tiêu
            if (arr[i] == target) {
                return i; // Trả về chỉ số của phần tử nếu tìm thấy
            }
        }
        return -1; // Trả về -1 nếu không tìm thấy
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2}; // Mảng không được sắp xếp
        int target = 10; // Giá trị mục tiêu

        // Gọi phương thức tìm kiếm tuyến tính
        int result = linearSearch(arr, target);

        // Kiểm tra kết quả và in ra
        if (result != -1) {
            System.out.println("Phần tử " + target + " được tìm thấy tại chỉ số: " + result);
        } else {
            System.out.println("Phần tử " + target + " không được tìm thấy trong mảng.");
        }
    }
}