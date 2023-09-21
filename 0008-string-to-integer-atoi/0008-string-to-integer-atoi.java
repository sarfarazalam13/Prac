class Solution {
    public int myAtoi(String s) {


        int num = 0;
        int neg = 1;
        int i = 0;
        for(char c : s.toCharArray()){
            if(c != ' ' )
                i++;
          
            if(num ==0 ){
                if( c == '-' || c == '+' ){
                    neg = c == '-' ? -1 : 1;
                
                    if(i > 1)
                        return 0;
                    continue;
                }
            }
            if(Character.isDigit(c)){

                int digit=  c - '0';
                if(Integer.MAX_VALUE/10 < num || Integer.MAX_VALUE/10 == num && Integer.MAX_VALUE %10 < digit){
                    return neg == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE ;

                }
               
                num = num * 10 + c - '0';
            }
            else if(!Character.isDigit(c) && c != ' ' && num != 0 ){
                return num * neg;
            } else if(c != ' '){
                return num * neg;
            } else if(c == ' ' && i >= 1){
                return num*neg;
            }
            
        }
        return num * neg;
        
    }
}