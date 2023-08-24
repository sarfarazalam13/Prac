class Solution {
    public String defangIPaddr(String ad) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<ad.length();i++)
        {
            if(ad.charAt(i)=='.')
            {
                sb.append("[.]");
            }
            else
            {
                sb.append(ad.charAt(i));
            }
        }
        return sb.toString();
    }
}