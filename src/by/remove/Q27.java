package by.remove;

/** 27. 移除元素 */
public class Q27 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int len = removeElement2(nums, 3);

        // 在函数里修改输入数组对于调用者是可见的。
        // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }
    // 快慢指针，严格顺序
    public static int removeElement(int[] nums, int val) {
        int slow = 0, fast = 0;
        while (true) {
            if (fast >= nums.length) {
                return slow;
            }
            // 向前找到 一个不是 val 的位置
            if (nums[fast] == val) {
                fast++;
                continue;
            }
            // 将 fast 的值，复制到 slow 位置上
            // 然后两个指针都移动到下一位

            if (slow != fast) {
                nums[slow] = nums[fast];
            }

            slow++;
            fast++;
        }
    }
    // 左右 双指针 解法。顺序不严格
    public static int removeElement2(int[] nums, int val) {
        int left = 0, right = nums.length - 1;
        while (true) {
            if (left > right) {
                return left;
            }
            // 向前找到一个 非 val 的位置
            if (nums[left] != val) {
                left ++;
                continue;
            }

            // 将数组后面的right位置的元素，复制到 当前 left（非 val 的位置） 位置上
            nums[left] = nums[right];
            right --;

            // 如果 right 为 val ，则，循环还会来到此处。
        }
    }
}
