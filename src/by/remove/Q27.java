package by.remove;

/** 27. �Ƴ�Ԫ�� */
public class Q27 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int len = removeElement2(nums, 3);

        // �ں������޸�����������ڵ������ǿɼ��ġ�
        // ������ĺ������صĳ���, �����ӡ�������� �ó��ȷ�Χ�� ������Ԫ�ء�
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }
    // ����ָ�룬�ϸ�˳��
    public static int removeElement(int[] nums, int val) {
        int slow = 0, fast = 0;
        while (true) {
            if (fast >= nums.length) {
                return slow;
            }
            // ��ǰ�ҵ� һ������ val ��λ��
            if (nums[fast] == val) {
                fast++;
                continue;
            }
            // �� fast ��ֵ�����Ƶ� slow λ����
            // Ȼ������ָ�붼�ƶ�����һλ

            if (slow != fast) {
                nums[slow] = nums[fast];
            }

            slow++;
            fast++;
        }
    }
    // ���� ˫ָ�� �ⷨ��˳���ϸ�
    public static int removeElement2(int[] nums, int val) {
        int left = 0, right = nums.length - 1;
        while (true) {
            if (left > right) {
                return left;
            }
            // ��ǰ�ҵ�һ�� �� val ��λ��
            if (nums[left] != val) {
                left ++;
                continue;
            }

            // ����������rightλ�õ�Ԫ�أ����Ƶ� ��ǰ left���� val ��λ�ã� λ����
            nums[left] = nums[right];
            right --;

            // ��� right Ϊ val ����ѭ�����������˴���
        }
    }
}
