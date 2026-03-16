class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right = 0;
        
        for(int n : nums){
            right = Math.max(right, n);
        }
        
        while(left < right){
            
            int mid = left + (right - left)/2;
            
            if(canPossible(nums, mid, threshold)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    boolean canPossible(int[] nums, int divisor, int threshold){
        
        int sum = 0;
        
        for(int n : nums){
            sum += Math.ceil((double)n/divisor);
        }
        
        return sum <= threshold;  
    }
}