class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left=1;
        int right=0;
        for(int p:piles){
           right=Math.max(right,p);
        }
        while(left<right){
            int mid=left+(right-left)/2;
            if(canpossible(piles,h,mid)){
                right=mid;
            }else left=mid+1;
        }
        return left;
    }
    boolean canpossible(int[] piles,int h,int mid){
       int hours = 0;
        for(int p : piles){
            hours += (p + mid - 1) / mid; 
        }
        return hours <= h;
    }
}