class Solution {
    public int myAtoi(String s) {
        int i=0;
        int n=s.length();
        while(i<n && s.charAt(i)==' ')
            i++;
        int positive=0,negative=0;
        if(i<n && s.charAt(i)=='+')
        {
            positive++;
            i++;
        }
        if(i<n && s.charAt(i)=='-')
        {
            negative++;
            i++;
        }

        if(positive>0 && negative>0)
            return 0;
        long  res=0;
        while(i<n && s.charAt(i)>='0' && s.charAt(i)<='9')
        {
            res=res*10+(s.charAt(i)-'0');
            i++;

            if(res>(Math.pow(2,31)-1)&& negative==0)
                    return (int)(Math.pow(2,31)-1);

            else if(res>(Math.pow(2,31)-1))
                return (int)Math.pow(-2,31);
        }

        if(negative>0)
            res =-1*res;

        return (int)res;
    }
}