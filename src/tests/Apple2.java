package tests;

/**
 * Created by Json Wan on 2018/10/30.
 */
public class Apple2 {

    public static void main(String[] args) {
        String[][] strings=new String[][]{
                {"The"},
                {"dog","cat"},
                {"runs","walks"},
                {"quickly","slowly"},
                {"."}
        };
        expand(new StringBuilder(),strings,0);
    }

    public static void expand(StringBuilder builder,String[][] strings,int i){
        for(int j=0;j<strings[i].length;j++){
            StringBuilder next=new StringBuilder(builder).append(strings[i][j]);
            //һ��Ҫע��i++��i+1��������ѭ������дi++һ��Ҫ����������һ��ѭ����i�ĸı��Ӱ������ѭ������
//            i++;
            if(i+1<strings.length){
                //nextֻ�ᱻʹ��һ�Σ�����������û������
                expand(new StringBuilder(next.append(" ")),strings,i+1);
//                expand(new StringBuilder(next).append(" "),strings,i+1);
            }else{
                System.out.println(next);
            }
        }
    }
}
