class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int totalTime = 0;
        int len = garbage.length;
        totalTime+=1*garbage[0].length();
        for(int i = 1; i<len; i++){
            totalTime+=1*garbage[i].length();
            totalTime+=3*travel[i-1]; 
        }
        boolean foundG = garbage[len-1].contains("G");
        boolean foundP = garbage[len-1].contains("P");
        boolean foundM = garbage[len-1].contains("M");
        for(int i = len-1; i>=1; i--){
            if(!foundG)foundG = garbage[i].contains("G");
            if(!foundP)foundP = garbage[i].contains("P");
            if(!foundM)foundM = garbage[i].contains("M");
            if(foundP && foundG && foundM)break;
            if(!foundG)totalTime-=travel[i-1];
            if(!foundP)totalTime-=travel[i-1];
            if(!foundM)totalTime-=travel[i-1];
        }
        return totalTime;
    }
}