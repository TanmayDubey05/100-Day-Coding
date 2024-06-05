class Solution {
    public int countDigitOne(int n) {
        char arr[]=Integer.toString(n).toCharArray();
        int num=0,x=n,c=0;
        for(int i=0;i<arr.length;i++){
            int temp=(int)Math.pow(10,i);
            num+=temp*(x%10);
            int t=temp/10*(i);
            int t2=num-temp+1;
            // System.out.println(t2+" "+num+" "+temp);
            if(t2>=0){
                 t2=(t2>temp)?temp:t2;
                 c+=t2;
            }
            // System.out.println(t2);
            c+=(num/temp)*t;
            x/=10;
        }
        return c;
    }
}