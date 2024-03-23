package by.sel;

/**
 * 209. ������С��������
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
        // ��С���鳤��
        int minLen = nums.length;
        // ��¼ minLen �ǲ��Ǳ� ���⸳ֵ��һ�μ�����
        boolean hasResult = false;
        // ��ǰ�ۼƵĽ��
        int curSum = nums[start];
        while (true) {
            // �����������ͼ�¼
            if (curSum >= target) {
                hasResult = true;
                minLen = Math.min(minLen, end - start + 1);
                // �³����һ��
                // ������ڵ�ͷ�ˣ�Ҳ���п��� �������������ĸ�С����
                // ���磺 101 {1,1,1,100}. ������������ [1,1,1,100] �� [1,100]
                curSum -= nums[start];
                start++;
                continue;
            }
            // ���ڵ�����ָ�� �ƶ�

            // curSum ��û�� target���Ͳ�����չ ���ڵĳ���
            if (end < nums.length - 1) {
                end++;
                curSum += nums[end];
            }
            // �����ж�
            else {
                return hasResult ? minLen : 0;
            }
        }
    }
}
