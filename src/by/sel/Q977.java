package by.sel;

/**
 * 977.有序数组的平方
 */
public class Q977 {
    public static void main(String[] args) {
        sortedSquares(new int[]{-4, -1, 0, 3, 10});
    }

    public static int[] sortedSquares(int[] nums) {
        // 初始化 左右指针，分别指向开始和结束位置
        int left = 0, right = nums.length - 1;
        int[] result = new int[nums.length];
        int resultPoint = result.length - 1;

        while (true) {
            if (left > right) {
                return result;
            }
            // 计算两头的大小
            int leftVal = square(nums[left]);
            int rightVal = square(nums[right]);
            // 取最大值，并将最大值对应的指针，向内移动
            int resVal;
            if (leftVal < rightVal) {
                right--;
                resVal = rightVal;
            } else {
                left++;
                resVal = leftVal;
            }
            // 记录结果
            result[resultPoint--] = resVal;
        }
    }

    private static int square(int a) {
        return a * a;
    }
}
