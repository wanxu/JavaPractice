package leetcode;

/**
 * Created by Json Wan on 2018/1/22.
 * Given an array of integers, every element appears three times except for one, which appears exactly once. Find that single one.

 Note:
 Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class P137 {
    class Solution {
        public int bestSingleNumber(int[] nums) {
            // 1. ����ones
            // 2. ���ones�� ����twos
            // 3. ���twos
            int ones = 0, twos = 0;
            for(int i = 0; i < nums.length; i++){
                ones = (ones ^ nums[i]) & ~twos;
                twos = (twos ^ nums[i]) & ~ones;
            }
            return ones;
        }

        /**
         * int ���ݹ���32λ��������32�����洢 �� N ��Ԫ���и���������λ��  1  ���ֵĴ�������� �ڽ��� ģ�� ���������Ϊ1����˵����һλ��Ҫ��Ԫ�ض����Ʊ�ʾ��Ϊ 1 ����һλ
         * @param nums
         * @return
         */
        public int singleNumber2(int[] nums) {
            int bitNum[]=new int[32];
            int res=0;
            for(int i=0; i<32; i++){
                for(int num:nums) {
                    bitNum[i] += (num >> i) & 1;
                }
                res|=(bitNum[i]%3)<<i;
            }
            return res;
        }
        /**
         * �������������ֱ𱣴����������λ�� 1 ����һ�Ρ����Ρ����εķֲ���������ֻ�践�ر���һ�����ˡ�
         * @param nums
         * @return
         */
        public int singleNumber(int[] nums) {
            int one=0, two=0, three=0;
            for(int i=0; i<nums.length; i++){
                two |= one&nums[i];
                one^=nums[i];
                three=one&two;
                one&= ~three;
                two&= ~three;
            }
            return one;
        }
    }
    public static void main(String[] args) {
        System.out.println(~5);
        System.out.println(~-5);
        System.out.println(~0);
        System.out.println(~-0);
        System.out.println(new P137().new Solution().singleNumber(new int[]{1,2,3,4,4,3,2,1,1,2,3,4,5}));
    }
}
