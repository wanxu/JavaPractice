package tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Json Wan on 2018/10/10.
 * description����Ŀ������
 �г���Ϊn���������飬���� n �������а���˳��ѡȡm����Ҫ����������������ԭ�����е�λ��������i��ʹ���� m �������ĳ˻�����뷵�����˻���
 ����
 ��һ�� ����n ��1<n<20��
 �ڶ��� ��˳���n������   �����ķ�Χ��-50 �� 50֮��
 ������ ����i��m  ��1<i<20, 1<m<50)
 ���
 ���س˻�
 */
public class MoMo3 {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int arr[]=new int[n];
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
            list.add(arr[i]);
        }
        int i=scanner.nextInt();
        int m=scanner.nextInt();
        ArrayList<Integer> copyList= (ArrayList<Integer>) list.clone();
        Arrays.sort(arr);
        for(int k=0;k<n-m;k++){
            list.remove(new Integer(arr[k]));
        }
        int result=1;
        for(int x:list){
            result*=x;
        }
        System.out.println(result);
    }
}
