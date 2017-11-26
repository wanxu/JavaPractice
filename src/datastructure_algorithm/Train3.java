package datastructure_algorithm;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Json Wan on 2017/11/16.
 * Description:
 */
public class Train3 {

    /**
     * ��ӡ�б�
     * @param list
     * @param <T>
     */
    public static <T> void  printList(MyLinkedList<T> list){
        Iterator<T> iterator=list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    /**
     * �жϱ��ʽ�ǲ��������
     * @param exp
     * @return
     */
    public static boolean isOperator(String exp){
        if(exp.equals("+")||exp.equals("-")||exp.equals("*")||exp.equals("/")||exp.equals("("))
            return true;
        return false;
    }

    /**
     * ������ŵ����ȼ�
     * @param op
     * @return
     */
    public static short getOperatorPriority(String op){
        switch (op){
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            default:
                throw new IllegalArgumentException("����������ȷ��������ţ�");
        }
    }
    /**
     * �����ʽ�ָ�Ϊһ���������������
     * @param expression
     * @return
     */
    public static MyLinkedList<String> splitExpression(String expression){
        System.out.println("splitExpression begin:");
        MyLinkedList<String> elementList=new MyLinkedList<>();
        boolean minusSign=false;
        boolean pointSign=false;
        boolean operatorSign=false;
        boolean rightBracketSign=false;
        String element="";
        Stack<Character> bracketStack=new Stack<>();
        for(int i=0;i<expression.length();i++){
            char ch=expression.charAt(i);
            switch(ch){
                case '.':
                    if(pointSign)
                        throw new IllegalArgumentException("С����ʹ�ò�����");
                    else if(rightBracketSign){
                        throw new IllegalArgumentException("�����ź�����С���㣡");
                    }
                    else{
                        operatorSign=false;
                        rightBracketSign=false;
                        pointSign = true;
                        element+=ch;
                    }
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    if(rightBracketSign){
                        throw new IllegalArgumentException("�����ź�����С���㣡");
                    }else {
                        operatorSign = false;
                        rightBracketSign=false;
                        element += ch;
                    }
                    break;
                case '+':
                case '-':
                case '*':
                case '/':
                case ')':
                case '(':
                    //�����������Ż򸺺ţ������������Ų�������һ��
                    if(ch!='('&&ch!='-') {
                        if (operatorSign)
                            throw new IllegalArgumentException("�����ʹ�ò�����");
                    }
                    //��֮ǰ��Ԫ�ش������
                    if(!element.equals("")) {
                        elementList.add(element);
                        System.out.println(element);
                    }
                    //������б�־��Ԫ�����
                    minusSign=false;
                    pointSign=false;
                    element="";
                    //����Ԫ�ش������
                    elementList.add(""+ch);
                    System.out.println(ch);
                    //��־��λ
                    operatorSign = true;
                    //�����ŵ����⴦��
                    if(ch==')') {
                            operatorSign=false;
                            rightBracketSign=true;
                            try {
                                //��ջ
                                bracketStack.pop();
                            } catch (EmptyStackException e) {
                                throw new IllegalArgumentException("����ʹ�ò�����");
                            }
                    }
                    //�����ŵ����⴦��
                    else if(ch=='('){
                        //ѹջ
                        bracketStack.push('(');
                    }
                    //���ŵ����⴦��
                    else if(ch=='-'){
                        //������������
                        if(minusSign)
                            throw new IllegalArgumentException("����ʹ�ò�����");
                        else {
                            minusSign = true;
                        }
                    }
                    if(ch!=')'){
                        rightBracketSign=false;
                    }
                    break;
                default:
                    throw new IllegalArgumentException("�Ƿ��ַ���");
            }
            //���һ���ַ�
            if(i==expression.length()-1){
                if(operatorSign)
                    throw new IllegalArgumentException("�����ʹ�ò�����");
                else{
                    //��֮ǰ��Ԫ�ش������
                    if(!element.equals("")) {
                        elementList.add(element);
                        System.out.println(element);
                    }
                }
            }
        }
        MyLinkedList<String> newElementList=new MyLinkedList<>();
        //��ĳЩ����ĸ����������
        for(int i=0;i<elementList.size()-1;i++){
            String ch=elementList.get(i);
            if(ch.equals("-")){
                if(i==0){
                    newElementList.add(ch+elementList.get(i+1));
                    i++;
                }else{
                    String previousCh=elementList.get(i-1);
                    if(isOperator(previousCh)) {
                        newElementList.add(ch + elementList.get(i + 1));
                        i++;
                    }else{
                        newElementList.add(ch);
                    }
                }
            }else{
                newElementList.add(ch);
            }
            if(i==elementList.size()-2){
                newElementList.add(elementList.get(i+1));
            }
        }
        System.out.println("splitExpression end!");
        return newElementList;
    }
    /**
     *
     * ����׺���ʽת��Ϊ��׺���ʽ
     * @param elementList
     * @return
     */
    public static MyLinkedList<String> convertToPostfix(MyLinkedList<String> elementList){
        MyLinkedList<String> outputList=new MyLinkedList<>();
        Stack<String> stack=new Stack<>();
        Iterator<String> iterator=elementList.iterator();
        while(iterator.hasNext()){
            String ch=iterator.next();
            if(isOperator(ch)||ch.equals(")")){
                //����Ƿ��ŵĻ�
                //���ջΪ��
                if(stack.size()==0){
                    //ѹջ
                    stack.push(ch);
                }
                //ջ��Ϊ��
                else{
                    if(ch.equals("(")){
                        //���������⴦��ֱ��ѹջ
                        stack.push(ch);
                    }
                    else if(ch.equals(")")){
                        //һ����������Ӧ�����ϵ�ջ
                        String tempCh;
                        do {
                            tempCh=stack.pop();
                            if(!tempCh.equals("(")) {
                                outputList.add(tempCh);
                            }
                            //����>����>=����ΪֻҪ��ǰ���ȼ����Ǳ�ջ�е�һ�������ȼ�С����Ӧ������ջ�еģ�������
                        } while (!tempCh.equals("("));
                    }
                    else {
                        //�ȽϷ�����ջ����һ�����ŵ����ȼ�
                        String previousCh = stack.peek();
                        if(previousCh.equals("(")) {
                            //ջ�����һ���������ţ�ֱ��ѹջ
                            stack.push(ch);
                        }
                        else{
                            short currentPriority = getOperatorPriority(ch);
                            //������ȼ�����һ�����Ÿ�
                            if (currentPriority > getOperatorPriority(previousCh)) {
                                //ѹջ
                                stack.push(ch);
                            } else {
                                //��ջֱ����ǰ���ȼ���ջ�и�Ϊֹ
                                do {
                                    outputList.add(stack.pop());
                                    if (stack.size() > 0) {
                                        previousCh = stack.peek();
                                        if(previousCh.equals("("))
                                            break;
                                    } else {
                                        break;
                                    }
                                    //����>����>=����ΪֻҪ��ǰ���ȼ����Ǳ�ջ�е�һ�������ȼ�С����Ӧ������ջ�еģ�������
                                } while (currentPriority >= getOperatorPriority(previousCh));
                                //�ٰѵ�ǰ����ѹջ
                                stack.push(ch);
                            }
                        }
                    }
                }
            }else{
                outputList.add(ch);
            }
        }
        //���ȫ����ջ
        while(stack.size()>0){
            outputList.add(stack.pop());
        }
        return outputList;
    }

    /**
     * �����׺���ʽ��ֵ
     * @param elementList
     * @return
     */
    public static float calcPostfixExpression(MyLinkedList<String> elementList){
        Stack<Float> elementStack=new Stack<>();
        for(int i=0;i<elementList.size();i++){
            String element=elementList.get(i);
            if(isOperator(element)){
                if(elementStack.size()>=2){
                    //�������������������������
                    float num2=elementStack.pop();
                    float num1=elementStack.pop();
                    float num;
                    switch (element){
                        case "+":
                            num=num1+num2;
                            break;
                        case "-":
                            num=num1-num2;
                            break;
                        case "*":
                            num=num1*num2;
                            break;
                        case "/":
                            num=num1/num2;
                            break;
                        default:
                            throw new IllegalArgumentException("�����׺���ʽ�з�������");
                    }
                    //��ѹ��ȥ
                    elementStack.push(num);
                }else{
                    throw new IllegalArgumentException("����ĺ�׺���ʽ�Ƿ���");
                }
            }else{
                //�����������ֱ��ѹջ
                elementStack.push(Float.parseFloat(element));
            }
        }
        return elementStack.pop();
    }
    //������ʽ
    public static float calcExpression(String expression){
        //1.�ָ���ʽΪ��������������
        MyLinkedList<String> elementList=splitExpression(expression);
        if(elementList==null){
            throw new IllegalArgumentException("���ʽ���Ϸ���");
        }
        //2.����׺���ʽת��Ϊ��׺���ʽ
        elementList=convertToPostfix(elementList);
        //3.�����׺���ʽ��ֵ
        return calcPostfixExpression(elementList);
    }
    public static void main(String[] args) {
        MyLinkedList<String> list=new MyLinkedList();
        list.add("aaaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddda");
        System.out.println(list.size());
        Iterator iterator=list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        String expression="-2.3*2+4*-5-2.4*3/2+(-2.3/2*-12/2+2)/2+5";
        expression="1+2*3-5*2+2/1+1";
        expression="-1.2+2*-3.5-4.5/3";
        expression="1*((2+3)*4+5)+25";
        System.out.println("expression="+expression);
        System.out.println("---------------------------------------------------");
        System.out.println("after split:");
        MyLinkedList<String> elementList=splitExpression(expression);
        printList(elementList);
        System.out.println("---------------------------------------------------");
        System.out.println("after convert:");
        elementList=convertToPostfix(elementList);
        printList(elementList);
        System.out.println("---------------------------------------------------");
        System.out.println("after calc:");
        System.out.println(expression + "=" + calcPostfixExpression(elementList));
        System.out.println("---------------------------------------------------");
        System.out.println("cyclic test:");
        Scanner scanner=new Scanner(System.in);
        while(true){
            System.out.println("��������ʽ��");
            expression=scanner.next();
            try {
                System.out.println(expression + "=" + calcExpression(expression));
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
