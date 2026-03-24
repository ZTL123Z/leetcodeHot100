public class code05_盛最多水的容器 {
    public int maxArea(int[] height) {
        int maxres = 0;
        int l = 0;
        int r = height.length - 1;
        while(l <r){
            maxres = Math.max(maxres, Math.min(height[r], height[l]) * (r - l));
            if(height[l] < height[r]){
                l++;
            }else{
                r--;
            }
        }
        return maxres;
    }
}
