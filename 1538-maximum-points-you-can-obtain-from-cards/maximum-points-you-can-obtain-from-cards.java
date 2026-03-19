class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int leftsum=0;
        int sum=0;
        for(int i=0; i<k; i++){
            sum+=cardPoints[i];
        }
        int maxSum=sum;
        int right=cardPoints.length-1;
        for(int j=k-1; j>=0; j--){
            sum-=cardPoints[j];
            sum+=cardPoints[right];
            right--;
            maxSum=Math.max(maxSum,sum);

        }
        return maxSum;
    }
}