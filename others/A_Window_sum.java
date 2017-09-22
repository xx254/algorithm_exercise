public class Demo {
    public static int[] windowSum(int[] arr, int k){
        int[] sum = new int[arr.length];
        int [] res = new int[arr.length - k + 1];
        sum[0] = arr[0];
        for(int i=1; i<arr.length; i++){
            sum[i] = sum[i-1] + arr[i];
        }

        res[0] = sum[k-1];
        for(int i=1; i<res.length; i++){
            res[i] = sum[i+k-1] - sum[i-1];
        }
        return res;
    }


    public static void main(String args[]) {
//        int[] a = {1,2,7,8,5};
        int[] a = {1,2};
        int k = 2;
        int[] res = windowSum(a, k);
        for(int num : res){
            System.out.println(num);
        }
    }
}
