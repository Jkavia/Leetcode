class Solution {
    public int fib(int n) {
        int f0 = 0, f1 = 1;
        if(n < 2){
            return (n==0)?f0:f1;
        }
        int num =0;

        for(int i=2;i<=n;i++){
            num = f0+f1;
            f0 = f1;
            f1 = num;
        }
        return num;
    }
}