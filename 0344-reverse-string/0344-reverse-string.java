class Solution {
    public void reverseString(char[] s) {
       int n=s.length;
       rev(s,0,n-1);

    }
    void rev(char[]s,int left, int right)
    {
        if(left>=right)
            return;
            char ch=s[right];
            s[right]=s[left];
            s[left]=ch;
            rev(s,left+1,right-1);
    }
}