class Solution {
    public boolean search(int[] arr, int target) 
    {
        int start = 0;
        int end = arr.length - 1;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            if (arr[mid] == target) {
                return true;
            }
            if(arr[start] == arr[mid] && arr[mid] == arr[end]) 
            {
                start++;
                end--;
                continue;
            }
            // Case 1: Left half is sorted
            if (arr[start] <= arr[mid]) {
                // Check if target lies within the sorted left half bounds
                if (target >= arr[start] && target < arr[mid]) {
                    end = mid - 1; // Search left
                } else {
                    start = mid + 1; // Search right
                }
            } 
            // Case 2: Right half must be sorted
            else {
                // Check if target lies within the sorted right half bounds
                if (target > arr[mid] && target <= arr[end]) {
                    start = mid + 1; // Search right
                } else {
                    end = mid - 1; // Search left
                }
            }
        }
        return false; // Target not found
    }
}
