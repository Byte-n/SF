package by.sel;

/**
 * 977.���������ƽ��
 */
public class Q977 {
    public static void main(String[] args) {
        sortedSquares(new int[]{-4, -1, 0, 3, 10});
    }

    public static int[] sortedSquares(int[] nums) {
        // ��ʼ�� ����ָ�룬�ֱ�ָ��ʼ�ͽ���λ��
        int left = 0, right = nums.length - 1;
        int[] result = new int[nums.length];
        int resultPoint = result.length - 1;

        while (true) {
            if (left > right) {
                return result;
            }
            // ������ͷ�Ĵ�С
            int leftVal = square(nums[left]);
            int rightVal = square(nums[right]);
            // ȡ���ֵ���������ֵ��Ӧ��ָ�룬�����ƶ�
            int resVal;
            if (leftVal < rightVal) {
                right--;
                resVal = rightVal;
            } else {
                left++;
                resVal = leftVal;
            }
            // ��¼���
            result[resultPoint--] = resVal;
        }
    }

    private static int square(int a) {
        return a * a;
    }
}
