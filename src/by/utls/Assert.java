package by.utls;

public class Assert {
    public static void isEq (int a, int b) {
        if (a != b) {
            thrError(a, b);
        }
    }

    private static void thrError(Object a, Object b) {
        throw new AssertionError("����ֵ��" + a.toString() + " ʵ�ʣ�" + b.toString());
    }
}
