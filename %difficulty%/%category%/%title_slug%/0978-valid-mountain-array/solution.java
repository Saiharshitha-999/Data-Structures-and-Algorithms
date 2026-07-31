class Solution {
    public boolean validMountainArray(int[] arr) {

        if(arr.length < 3)
        {
            return false;
        }
        boolean flag = false;
        for(int i = 1 ; i < arr.length ; i++)
        {
            
            if(flag)
            {
                if(arr[i-1] < arr[i])
                {
                    return false;
                }
            }
            if(arr[i] == arr[i-1] || (i==1 && arr[i] < arr[i-1]))
            {
                return false;
            }
            if(arr[i] < arr[i - 1])
            {
                flag = true;
            }
            
        }
        if(flag != true)
        {
            return false;
        }
        return true;

    }
}
