package array;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/01/13 22:12
 * @Description: 11.盛最多水的容器 https://leetcode-cn.com/problems/container-with-most-water/
 **/
public class MostWater {
    /**
     * 双指针法，左右夹逼
     *
     * @param height
     * @return
     */
    public int maxArea1(int[] height) {
        int max = 0;
        for (int i = 0, j = height.length - 1; i < j; ) {
            int minHeight = height[i] < height[j] ? height[i++] : height[j--];
            int area = (j - i + 1) * minHeight;
            max = Math.max(max, area);
        }
        return max;
    }

    public int maxArea2(int[] height) {
        if (height == null || height.length == 0) return 0;
        int i = 0, j = height.length - 1, water = 0;

        while (i < j) {
            int h = Math.min(height[i], height[j]);
            water = Math.max(water, (j - i) * h);
            while (i < j && height[i] <= h) i++;
            while (i < j && height[j] <= h) j--;
        }
        return water;
    }
}
