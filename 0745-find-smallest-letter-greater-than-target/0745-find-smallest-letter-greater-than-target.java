class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int s=0,e=letters.length-1,m=0;

        while(s<=e)
        {
             m=s+(e-s)/2;
            
             if(target<letters[m])
             {
                 e=m-1;
             }
             else
             {
                s=m+1;
             }
        }
        return letters[s%letters.length];
    }
                
    
}