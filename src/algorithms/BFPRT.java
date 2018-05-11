package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Json Wan on 2018/5/11.
 */
public class BFPRT {
    public int find(int[] a, int j) {
        System.out.println("================================");
        System.out.println("�����ҵ����� �� ");
        print(a);
        System.out.println("�ҳ��� " + j + "С����");
        if (a.length / 5 <= 1) {
            Arrays.sort(a);
            return a[j];
        }

        int x = getCenterForArray(a);

        // 4. ��x���ָ����飬��С�ڵ���x�ĸ���Ϊk������x�ĸ�����Ϊn-k��
        List<Integer> left = new ArrayList<Integer>();
        List<Integer> right = new ArrayList<Integer>();

        for (int i = 0; i < a.length; i++) {
            if (a[i] <= x) {
                left.add(a[i]);
            } else {
                right.add(a[i]);
            }
        }
        // 5. ��i==k������x����i<k����С��x��Ԫ���еݹ���ҵ�iС��Ԫ�أ���i>k���ڴ���x��Ԫ���еݹ���ҵ�i-k С��Ԫ�ء�
        int K = left.size();
        if (j == K) {
            return x;
        } else if (j < K) {
            int[] leftArray = new int[left.size()];
            for (int i = 0; i < left.size(); i++) {
                leftArray[i] = left.get(i);
            }
            return find(leftArray, j);
        } else {
            int[] rightArray = new int[right.size()];
            for (int i = 0; i < right.size(); i++) {
                rightArray[i] = right.get(i);
            }
            return find(rightArray, j - K);
        }
    }

    // �õ���������ķָ���
    private int getCenterForArray(int[] a) {
        // 1.��n��Ԫ��ÿ5��һ�飬�ֳ�n/5(�Ͻ�)�飬����һ�����Ԫ�ظ���Ϊn%5����Ч������Ϊn/5��
        int length = a.length;
        int num = length / 5;
        int[] centers = new int[num];
        for (int i = 0; i < num; i++) {
            // ȡÿһ���е���λ��
            int center = getCenterPerArray(a, 5 * i, 5 * (i + 1) - 1);
            centers[i] = center;
            System.out.println("���������λ�� : " + center);
        }
        System.out.println("��λ���ļ��� �� ");
        print(centers);
        // 3. �ݹ�ĵ��� selection �㷨������һ����������λ������λ������Ϊx��ż������λ����������趨Ϊѡȡ�м�С��һ����
//        new Selectionsort().sort(centers);
        Arrays.sort(centers);
        System.out.println("����ѡ����������λ������ �� ");
        print(centers);
        int x = 0;

        if (centers.length % 2 == 0) {
            // ż������λ��
            x = min(centers[centers.length / 2 - 1],
                    centers[centers.length / 2]);
        } else {
            x = centers[centers.length / 2];
        }
        System.out.println("�����x Ϊ �� " + x);

        return x;
    }

    private int min(int a, int b) {
        if (a >= b) {
            return b;
        } else {
            return a;
        }
    }

    // �õ�ÿ���������е���λ��
    private int getCenterPerArray(int[] a, int start, int end) {
        // 2.ȡ��ÿһ�����λ�������һ����Ĳ��ü�����λ�����������򷽷�����������ݱȽ���ֻ��5���������ü򵥵�ð��������ǲ�������
        int[] b = new int[end - start + 1];
        int index = 0;
        for (int i = start; i <= end; i++) {
            b[index++] = a[i];
        }
        System.out.println("���ָ������ �� ");
        print(b);
//        new Insertsort().sort(b);
        Arrays.sort(b);
        return b[b.length / 2];
    }

    public static void main(String[] args) {
        // �������е�7С����

        int[] datas = { 4, 1, 2, 56, 24, 5, 6, 97, 8, 0, 4, 8, 6, 2, 3, 6, 1, 9, 3, 4, 6, 2 };
//        int[] datas = { 4, 1, 2, 56, 24};
        int index = 3;
        int findX = new BFPRT().find(datas, index);
//        datas = new QuickSort().sort(datas);
        Arrays.sort(datas);
        print(datas);
        System.out.println("��" + index + "С����Ϊ �� " + findX);
    }

    public static void print(int[] datas) {
        for (int i = 0; i < datas.length; i++) {
            System.out.print(datas[i] + " ");
        }
        System.out.println("");
    }

}
