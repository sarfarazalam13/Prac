class Solution {
   
   public int find(int arr[],int cap){
       int days=1,load=0;

       for(int i=0;i<arr.length;i++){
           if(arr[i]+load>cap){
               days=days+1; //if the weight exceeds it can ship a day
               load=arr[i]; //now new load will be our weight
           }else{
               load=load+arr[i]; //if it doesn't we will add until it reaches the capacity
           }
       }
       return days;
   }
   
   
    public int shipWithinDays(int[] weights, int days) {
        
        int max=Integer.MIN_VALUE;
        for(int x:weights){
            if(x>max){
                max=x;
            }
        }

        int sum=0;
        int sumofAllelements=0;
        for(int i=0;i<weights.length;i++){
            sumofAllelements+=weights[i];
        }
        int low=max;
        int high=sumofAllelements;
        //low --> maximum weight to be needed to load the package (if it is lower than the maximum element so we cannot load the max element)

   //consider 10 if any weight is taken lesser than our 10 so we cannot load 10     
        //high --> in one day how many we can ship (weights)
        System.out.print(low+" "+high);
        while(low<=high){
            int mid=low+(high-low)/2;
            int daysrequired=find(weights,mid); //mid is one capacity
            if(daysrequired<=days){ //the weight is higher (reduce the weights)
             high=mid-1;
            }else{ //the weight is lower (increase the weights) 
                low=mid+1;
            }
        }

        return low; //low element will be the weight where it is the least

        


    }
}