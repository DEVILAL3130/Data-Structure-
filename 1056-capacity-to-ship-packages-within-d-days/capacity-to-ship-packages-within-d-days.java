class Solution {
    public int shipWithinDays(int[] weights, int days) {
       int left=0;
       int right=0;
       for(int w:weights){
        left=Math.max(left,w);
        right+=w;
       }
       while(left<right){
       int mid=left+(right-left)/2;
       if(canShip(weights,days,mid)){
        right=mid;
       }else{
        left=mid+1;
       }
    }
       return left;
    }  
    boolean canShip(int[] weights,int days,int mid){
        int requiredDays=1;
        int currentCapacity=0;
        for(int w:weights){
            if(currentCapacity+w>mid){
                requiredDays++;
                currentCapacity=w;
            }else{
                currentCapacity+=w;
            }
        }
        return requiredDays<=days;
    }    
}