class Solution {

    public int search(int[] nums, int target) {

        int min = findMin(nums);

        int left = binarySearch(nums, 0, min - 1, target);
        int right = binarySearch(nums, min, nums.length - 1, target);

        if(left != -1) return left;
        return right;
    }

    int findMin(int[] nums){

        int left = 0;
        int right = nums.length - 1;

        while(left < right){

            int mid = left + (right - left)/2;

            if(nums[mid] > nums[right]){
                left = mid + 1;
            }else{
                right = mid;
            }
        }

        return left;
    }

    int binarySearch(int[] nums, int start, int end, int target){

        while(start <= end){

            int mid = start + (end - start)/2;

            if(nums[mid] == target)
                return mid;

            else if(nums[mid] > target)
                end = mid - 1;

            else
                start = mid + 1;
        }

        return -1;
    }
}