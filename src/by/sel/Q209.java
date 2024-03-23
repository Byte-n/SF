package by.sel;

/**
 * 209. 长度最小的子数组
 */
public class Q209 {
    public static void main(String[] args) {
        int i = minSubArrayLen(15, new int[]{5, 1, 3, 5, 10, 7, 4, 9, 2, 8});
        System.out.println(i);
    }

    public static int minSubArrayLen(int target, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int start = 0, end = 0;
        // 最小数组长度
        int minLen = nums.length;
        // 记录 minLen 是不是被 额外赋值过一次及以上
        boolean hasResult = false;
        // 当前累计的结果
        int curSum = nums[start];
        while (true) {
            // 满足条件，就记录
            if (curSum >= target) {
                hasResult = true;
                minLen = Math.min(minLen, end - start + 1);
                // 吐出最后一个
                // 如果窗口到头了，也还有可能 存在满足条件的更小窗口
                // 例如： 101 {1,1,1,100}. 满足条件的有 [1,1,1,100] 和 [1,100]
                curSum -= nums[start];
                start++;
                continue;
            }
            // 窗口的两个指针 移动

            // curSum 还没到 target，就不断扩展 窗口的长度
            if (end < nums.length - 1) {
                end++;
                curSum += nums[end];
            }
            // 结束判断
            else {
                return hasResult ? minLen : 0;
            }
        }
    }
}
