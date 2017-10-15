// continue 是跳出循环而不是纸条出当前一层，所以不能写成 last == 1 时 continue
public static int getGap(int N) {
    // write your code in Java SE 8
    int bit = 0;
    int max = 0;
    int cur = 0;
    int last = -1;
    while(N != 0){
        bit = N & 1;
        if(bit == 1){
            if(last != -1){
                max = Math.max(cur - last, max);
            }
            last = cur;
        }
        N /= 2;
        cur++;
    }

    if(max == 0){
        return max;
    } else {
        return max - 1;
    }
}
//第一次不赋值问题: 即当遇到2的n次方或者位数是很多零的数的case 如 n=51712=110010100000000
