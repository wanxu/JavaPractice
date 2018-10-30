package algorithms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

/**
 * Created by Json Wan on 2018/10/18.
 * ��������ͼ������֮�������·��
 * �㷨Ҫ��
 ?1. ��һ��������ͨͼ���������������֮�������·����
 ?2. ������·���ϲ��ܺ��л�·���ظ��ĵ㣻
 ?�㷨˼��������
 ?1. ����ڵ��Ĺ�ϵ��Ϊÿ���ڵ㽨��һ�����ϣ��ü����б���������ýڵ�ֱ�������Ľڵ㣨�������ýڵ�������
 ?2. ��������һ��Ϊ��ʼ�ڵ㣬��һ��Ϊ�յ㣬�������֮�������·����������Ա��ֽ�Ϊ���������������⣺��ÿһ?������ʼ�ڵ�ֱ�������Ľڵ㣬��������յ������·����·���ϲ�������ʼ�ڵ㣩�õ�һ��·�����ϣ�����Щ·��������ӾͿ��Եõ���ʼ�ڵ㵽�յ������·�����������ƾͿ���Ӧ�õݹ��˼�룬���ݹ�ֱ���յ㣬������ϣ���õ���һ��·������ת������ӡ����������ֻ�·��������·����ֹͣѰ·�����أ� ?
 ?3. ��ջ���浱ǰ�Ѿ�Ѱ����·������������·�����ϵĽڵ㣬��ÿһ��Ѱ������·��ʱ����ջ���ڵ㣻����������ջ���ڵ��޷���������Ѱ·ʱҲ������ջ���ڵ㣬�Ӷ�ʵ�ֻ��ݡ�
 */
public class GraphPathSearch {
    /* ��ʱ����·���ڵ��ջ */
    public static Stack<GraphNode> stack = new Stack<GraphNode>();
    /* �洢·���ļ��� */
    public static ArrayList<Object[]> sers = new ArrayList<Object[]>();

    /* �жϽڵ��Ƿ���ջ�� */
    public static boolean isNodeInStack(GraphNode node)
    {
        Iterator<GraphNode> it = stack.iterator();
        while (it.hasNext()) {
            GraphNode node1 = (GraphNode) it.next();
            if (node == node1)
                return true;
        }
        return false;
    }

    /* ��ʱջ�еĽڵ����һ������·����ת������ӡ��� */
    public static void showAndSavePath()
    {
        Object[] o = stack.toArray();
        for (int i = 0; i < o.length; i++) {
            GraphNode nNode = (GraphNode) o[i];

            if(i < (o.length - 1))
                System.out.print(nNode.getName() + "->");
            else
                System.out.print(nNode.getName());
        }
        sers.add(o); /* ת�� */
        System.out.println("\n");
    }

    /*
     * Ѱ��·���ķ��� 
     * cNode: ��ǰ����ʼ�ڵ�currentNode
     * pNode: ��ǰ��ʼ�ڵ����һ�ڵ�previousNode
     * sNode: �������ʼ�ڵ�startNode
     * eNode: �յ�endNode
     */
    public static boolean getPaths(GraphNode cNode, GraphNode pNode, GraphNode sNode, GraphNode eNode) {
        GraphNode nNode = null;
		/* ������������ж�˵�����ֻ�·��������˳�Ÿ�·������Ѱ·������false */
        if (cNode != null && pNode != null && cNode == pNode)
            return false;

        if (cNode != null) {
            int i = 0;
			/* ��ʼ�ڵ���ջ */
            stack.push(cNode);
			/* �������ʼ�ڵ�����յ㣬˵���ҵ�һ��·�� */
            if (cNode == eNode)
            {
				/* ת������ӡ�����·��������true */
                showAndSavePath();
                return true;
            }
			/* �������,����Ѱ· */
            else
            {
				/* 
				 * ���뵱ǰ��ʼ�ڵ�cNode�����ӹ�ϵ�Ľڵ㼯�а�˳������õ�һ���ڵ�
				 * ��Ϊ��һ�εݹ�Ѱ·ʱ����ʼ�ڵ� 
				 */
                nNode = cNode.getRelationNodes().get(i);
                while (nNode != null) {
					/*
					 * ���nNode���������ʼ�ڵ����nNode����cNode����һ�ڵ����nNode�Ѿ���ջ�� �� 
					 * ˵��������· ��Ӧ�������뵱ǰ��ʼ�ڵ������ӹ�ϵ�Ľڵ㼯��Ѱ��nNode
					 */
                    if (pNode != null
                            && (nNode == sNode || nNode == pNode || isNodeInStack(nNode))) {
                        i++;
                        if (i >= cNode.getRelationNodes().size())
                            nNode = null;
                        else
                            nNode = cNode.getRelationNodes().get(i);
                        continue;
                    }
					/* ��nNodeΪ�µ���ʼ�ڵ㣬��ǰ��ʼ�ڵ�cNodeΪ��һ�ڵ㣬�ݹ����Ѱ·���� */
                    if (getPaths(nNode, cNode, sNode, eNode))/* �ݹ���� */
                    {
						/* ����ҵ�һ��·�����򵯳�ջ���ڵ� */
                        stack.pop();
                    }
					/* ��������cNode�����ӹ�ϵ�Ľڵ㼯�в���nNode */
                    i++;
                    if (i >= cNode.getRelationNodes().size())
                        nNode = null;
                    else
                        nNode = cNode.getRelationNodes().get(i);
                }
				/* 
				 * ��������������cNode�����ӹ�ϵ�Ľڵ��
				 * ˵������cNodeΪ��ʼ�ڵ㵽�յ��·���Ѿ�ȫ���ҵ� 
				 */
                stack.pop();
                return false;
            }
        } else
            return false;
    }

    public static void main(String[] args) {
		/* ����ڵ��ϵ */
        int nodeRalation[][] =
                {
                        {1},      //0
                        {0,5,2,3},//1
                        {1,4},    //2
                        {1,4},    //3
                        {2,3,5},  //4
                        {1,4}     //5
                };
		
		/* ����ڵ����� */
        GraphNode[] node = new GraphNode[nodeRalation.length];

        for(int i=0;i<nodeRalation.length;i++)
        {
            node[i] = new GraphNode();
            node[i].setName("node" + i);
        }
		
		/* ������ڵ�������Ľڵ㼯�� */
        for(int i=0;i<nodeRalation.length;i++)
        {
            ArrayList<GraphNode> List = new ArrayList<GraphNode>();

            for(int j=0;j<nodeRalation[i].length;j++)
            {
                List.add(node[nodeRalation[i][j]]);
            }
            node[i].setRelationNodes(List);
            List = null;  //�ͷ��ڴ�
        }
 
		/* ��ʼ��������·�� */
        getPaths(node[0], null, node[0], node[4]);
    }
}
