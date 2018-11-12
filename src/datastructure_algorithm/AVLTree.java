package datastructure_algorithm;

/**
 * Created by Json Wan on 2018/11/9.
 */
//����ڵ�
class AvlNode {
    int data;
    //����
    AvlNode lchild;
    //�Һ���
    AvlNode rchild;
    //��¼�ڵ�ĸ߶�
    int height;
}

//�����ﶨ����ֲ���
public class AVLTree {
    //����ڵ�ĸ߶�
    static int height(AvlNode T) {
        if (T == null) {
            return -1;
        } else {
            return T.height;
        }
    }

    //�����ͣ���������
    static AvlNode R_Rotate(AvlNode K2) {
        AvlNode K1;

        //������ת
        K1 = K2.lchild;
        K2.lchild = K1.rchild;
        K1.rchild = K2;

        //���¼���ڵ�ĸ߶�
        K2.height = Math.max(height(K2.lchild), height(K2.rchild)) + 1;
        K1.height = Math.max(height(K1.lchild), height(K1.rchild)) + 1;

        return K1;
    }

    //��������
    static AvlNode L_Rotate(AvlNode K2) {
        AvlNode K1;

        K1 = K2.rchild;
        K2.rchild = K1.lchild;
        K1.lchild = K2;

        //���¼���߶�
        K2.height = Math.max(height(K2.lchild), height(K2.rchild)) + 1;
        K1.height = Math.max(height(K1.lchild), height(K1.rchild)) + 1;

        return K1;
    }

    //��-���ͣ�����������������
    static AvlNode R_L_Rotate(AvlNode K3) {
        //�ȶ��亢�ӽ�������
        K3.lchild = R_Rotate(K3.lchild);
        //�ٽ�������
        return L_Rotate(K3);
    }

    //��-���ͣ��Ƚ���������������
    static AvlNode L_R_Rotate(AvlNode K3) {
        //�ȶԺ��ӽ�������
        K3.rchild = L_Rotate(K3.rchild);
        //������
        return R_Rotate(K3);
    }

    //������ֵ����
    static AvlNode insert(int data, AvlNode T) {
        if (T == null) {
            T = new AvlNode();
            T.data = data;
            T.lchild = T.rchild = null;
        } else if (data < T.data) {
            //�����ӵݹ����
            T.lchild = insert(data, T.lchild);
            //���е�������
            //������ӵĸ߶ȱ��Һ��Ӵ�2
            if (height(T.lchild) - height(T.rchild) == 2) {
                //��-����
                if (data < T.lchild.data) {
                    T = R_Rotate(T);
                } else {
                    //��-����
                    T = R_L_Rotate(T);
                }
            }
        } else if (data > T.data) {
            T.rchild = insert(data, T.rchild);
            //���е���
            //�Һ��ӱ����Ӹ߶ȴ�2
            if (height(T.rchild) - height(T.lchild) == 2)
                //��-����
                if (data > T.rchild.data) {
                    T = L_Rotate(T);
                } else {
                    T = L_R_Rotate(T);
                }
        }
        //��������ڵ��Ѿ������ϴ����ˣ�����ʲôҲ����

        //���¼���T�ĸ߶�
        T.height = Math.max(height(T.lchild), height(T.rchild)) + 1;
        return T;
    }
}
