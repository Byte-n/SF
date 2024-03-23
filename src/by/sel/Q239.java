package by.sel;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 239. �����������ֵ
 */
public class Q239 {
    // ˫����� & ��������
    public int[] maxSlidingWindow(int[] nums, int k) {
        // �洢��������
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            // �������⣬iΪnums�±꣬��Ҫ��[i - k + 1, i] ��ѡ�����ֵ��ֻ��Ҫ��֤����
            // 1.����ͷ�����Ҫ��[i - k + 1, i]��Χ�ڣ���������Ҫ����
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }
            // 2.��Ȼ�ǵ�������Ҫ��֤ÿ�ηŽ�ȥ������Ҫ��ĩβ�Ķ��󣬷���Ҳ����
            // ά�� deque��������Ӧ����ֵ�� �ǵ��� ��
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            // ����β��
            deque.offerLast(i);

            // ��Ϊ��������i���������ϵ�һ��k��Χ��ʱ��ÿ����һ����������ͷ�ڵ������������
            if (i >= k - 1) {
                res[idx++] = nums[deque.peekFirst()];
            }
        }
        return res;
    }

    // ���ȶ���
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        // PriorityQueue<[ֵ,ֵ��Ӧ������]>
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> {
            // ����ֵ����ͬ����Ƚ�ֵ
            if (a[0] != b[0]) {
                return b[0] - a[0];
            }
            // ֵ��ͬ����Ƚ�����
            return b[1] - a[1];
        });
        // �������k��Ԫ��
        for (int i = 0; i < k; ++i) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        // �����ʼk��Ԫ�ض�Ӧ�Ĵ�
        ans[0] = pq.peek()[0];
        // ������������Ԫ�������
        for (int i = k; i < n; ++i) {
            pq.offer(new int[]{nums[i], i});
            // ������������С�� i-k ��Ԫ�� �Ӷ������Ƴ�
            // Ҳ���ǽ���������������Ԫ���Ƴ�����������ﵱǰ�����ֵ�ǻ���������ġ�
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            // ��¼��ǰ���������ڵ����ֵ
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }
}
