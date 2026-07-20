class Solution {
    public int findContentChildren(int[] Student, int[] Cookie) {
        Arrays.sort(Student);
        Arrays.sort(Cookie);
        int count = 0;
        int i = 0;
        int j = 0;
        while(i < Cookie.length && j < Student.length)
        {
             if(Cookie[i] >= Student[j])
             {
                count++;
                i++;
                j++;
             }
             else
             {
                i++;
             }
        }
        return count;
    }
}
