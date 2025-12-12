public class removeAtTest {
    public static void main(String[] args) {
        int[] a = {-100,67,420,69,100,200,2,1,2003,05,11,3};

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ", ");
        }
        System.out.println("");
        int[]b = removeAt(a,6);

        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + ", ");
        }
  
    }
    public static int[] removeAt(int[] arr, int index) {
        int[] b = new int[arr.length - 1];

        for(int i = 0; i < index; i++) {
            b[i] = arr[i];
        }
        for(int i = index + 1; i < arr.length; i++) {
            b[i - 1] = arr[i];
        }
        return b;
    }
}
