c class Demo {
    public static boolean isInside(int[] a, int[] b, int[] in){
        if((a[0] < in[0] && in[0] < a[1]) || (b[0] < in[0] && in[0] < b[1])){
            return true;
        } else {
            return false;
        }
    }

    public static boolean overlap(int[] l1, int[] r1, int[] l2, int[] r2){

        if(isInside(l1, r1, l2) || isInside(l1, r1, r2) || isInside(l2, r2, l1) || isInside(l2, r2, r1)){
            return true;
        }

        return false;
    }


    public static void main(String args[]) {
        int[] a = {0, 8}, b = {8, 0}, c = {9, 6}, d = {10, 0};
        boolean m = overlap(a,b,c,d);
        System.out.println(m);

    }
}
