package algorithms;

import java.util.ArrayList;
import java.util.HashMap;

//ȥ�����ڵ��ظ��ַ������ظ���������2������������
public class RemoveRepeatedString {
    private static StringBuilder repeatedString; //�ظ����ַ���

    public static void main(String[] args) {
        String strings[] = {
                "�ղ���˵����Ҫ�˿���Ҫ�˿�",
                "�ղ���˵����Ҫ�˿���Ҫ�˿���Ҫ�˿�Ҷ�˵����Ҫ�˿���Ҫ�˿���Ҫ�˿�",
                "�ղ���˵����Ҫ�˿���˵����Ҫ�˿�",
                "10000",
                "����Ͱ�",
                "����������������"
        };
        for (String string : strings) {
            String result = solve(string);
            System.out.println(result);
        }
    }

    //��Ҫ�����Ӵ��������ظ��ַ������
    //˼·����ǰ�����ַ������������ַ���Ӧ�±꣬�������֣�������֮ǰ���ֹ����ַ�֮��˫�±�������ظ����ַ����ɴӺ���ǰ�ң�Ч�ʸ��ߣ�
    private static String solve(String string) {
        char[] chars = string.toCharArray();
        HashMap<Character, ArrayList<Integer>> record = new HashMap<>();
        StringBuilder result = new StringBuilder();
        boolean needBreak;
        for (int i = 0; i < chars.length; i++) {
            needBreak = false;
            char cur = chars[i];
            if (cur < '0' || cur > '9') {
                if (!record.containsKey(cur)) {
                    ArrayList<Integer> indexList = new ArrayList<>();
                    indexList.add(i);
                    record.put(cur, indexList);
                }
                //��ǰ�ַ���֮ǰ���ֹ�
                else {
                    ArrayList<Integer> indexList = record.get(cur);
                    for (int j = 0; j < indexList.size(); j++) {
                        int preIndex = indexList.get(j);
                        int count = getRepeatedCount(chars, preIndex, i);
                        //�ظ���������2
                        if (count >= 2 && repeatedString.length() >= 2) {
                            //�����ظ����ַ�����ֻ����һ��
                            i += (count - 1) * repeatedString.length() - 1;
                            needBreak = true;
                            break;
                        }
                    }
                    if (!needBreak) {
                        //�˴���Ӧֱ�Ӹ��ǣ���Ӧ�ð�֮ǰ���ֹ���λ��ȫ���洢��������Ϊ�ظ����п�����һ���������ظ��ַ����Ӵ�
                        indexList.add(i);
                    }
                }
            }
            if (!needBreak) {
                result.append(cur);
            }
        }
        return result.toString();
    }

    //��ȡ�ظ����ַ�������
    private static int getRepeatedCount(char[] chars, int preIndex, int curIndex) {
        int preIndexBackup=preIndex;
        int repeatLength = curIndex - preIndex;
        int end1 = curIndex - 1;
        int end2 = curIndex - 1 + repeatLength;
        repeatedString = new StringBuilder();
        int count = 1;
        //��ȡ�ظ����ַ���
        while (end2 < chars.length && end1 > preIndex && chars[end1] == chars[end2]) {
            end1--;
            end2--;
            if (end1 == preIndex) {
                count++;
                preIndex+=repeatLength;
                end1 += 2 * repeatLength - 1;
                end2 += 2 * repeatLength - 1;
            }
        }
        if (count > 1) {
            for (int i = preIndexBackup; i < curIndex; i++) {
                repeatedString.append(chars[i]);
            }
        }
        return count;
    }
}
