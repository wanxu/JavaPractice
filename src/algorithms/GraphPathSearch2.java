package algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by Json Wan on 2018/10/18.
 * 2.��0��3֮��ɴ������·��
 ����������ǹ�����������������,��������Ҫע�⵽���ܲ�����·��.
 �㷨��������:
 top_node:��ǰջ��Ԫ��
 adjvex_node;��ǰtop_node�Ѿ����ʵ��ڽӵ�
 next_node:�������ʵ�Ԫ�أ�top_node�ĵ�adjvex_node���ڽӵ�����Ӧ��Ԫ�أ�
 �ҳ�����·�����õ��Ǳ����ķ������ԡ�������ȡ��㷨Ϊ��������Դ��������ȵ�Դ��ĵ�һ���ڽӵ�N00���ٵ�N00�ĵ�һ���ڽӵ�N10���ٵ�N10�ĵ�һ���ڽӵ�N20...��������Ŀ���ʱ�����ҵ�һ��·����
 ��������ĺ������ݽṹΪһ��ջ����Ҫ���裺
 ��Դ������ջ�������б��
 �ڻ�ȡջ��Ԫ��top_node�����ջ��Ϊ�յ�ʱ�����ҵ�һ��·��,ջ��Ԫ��top_node��ջ����ʱadjvex_node=top_node,�µ�ջ��Ԫ��Ϊtop_node������ִ�Т�
 �۴�top_node�������ڽӵ��У���adjvex_nodeΪ��㣬ѡȡ��һ���ڽӵ�next_node�������Ԫ�طǿ�,����ջ,ʹ��adjvex_node=-1,(adjvex_node=-1����top_node���ڽӵ�һ����û�з���)����ջ��ǡ��������û�к����ڵ���,��ʱ�����ջջ��Ԫ��,����adjvex_nodeΪ��ջ��Ԫ��,������ջ��ǡ�
 ��Ϊ�����·������ջԪ��Ҫ��¼��ѡȡ����ջ����ʱӦ��������ջ�Ķ���,��ջΪ��ʱ���������
 */

class Vertex {
    //��ŵ���Ϣ
    public int data;
    //��õ��ڽӵĵ�һ���߽ڵ�
    public Edge firstEdge;
}

//�߽ڵ�
class Edge {
    //��Ӧ�ĵ��±�
    public int vertexId;
    //�ߵ�Ȩ��
    public int weight;
    //��һ���߽ڵ�
    public Edge next;

    //getter and setter���в���
    public int getVertexId() {
        return vertexId;
    }

    public void setVertexId(int vertexId) {
        this.vertexId = vertexId;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Edge getNext() {
        return next;
    }

    public void setNext(Edge next) {
        this.next = next;
    }
}

class Graph {
    public Vertex[] vertexList; //��ŵ�ļ���

    public Graph(int vertexNum) {
        this.vertexNum = vertexNum;
        vertexList = new Vertex[vertexNum];
    }

    //�����
    public int vertexNum;
    //�߸���
    public int edgeLength;

    public void initVertext(int datas[]) {
        for (int i = 0; i < vertexNum; i++) {
            Vertex vertext = new Vertex();
            vertext.data = datas[i];
            vertext.firstEdge = null;
            vertexList[i] = vertext;
            //System.out.println("i"+vertexList[i]);
        }
        boolean[] isVisited = new boolean[vertexNum];
        for (int i = 0; i < isVisited.length; i++) {
            isVisited[i] = false;
        }
    }

    //���x�ڵ���ӱ߽ڵ�y
    public void addEdge(int x, int y, int weight) {
        Edge edge = new Edge();
        edge.setVertexId(y);
        edge.setWeight(weight);
        //��һ���߽ڵ�
//        System.out.println(vertexList.length);
        if (null == vertexList[x].firstEdge) {
            vertexList[x].firstEdge = edge;
            edge.setNext(null);
        }
        //���ǵ�һ���߽ڵ�,�����ͷ�巨
        else {
            edge.next = vertexList[x].firstEdge;
            vertexList[x].firstEdge = edge;
        }
    }

    //�õ�x���ڽӵ�Ϊy�ĺ�һ���ڽӵ�λ��,Ϊ-1˵��û���ҵ�
    public int getNextNode(int x, int y) {
        int next_node = -1;
        Edge edge = vertexList[x].firstEdge;
        if (null != edge && y == -1) {
            int n = edge.vertexId;
            //Ԫ�ػ�����stack��
            if (!states.get(n))
                return n;
            return -1;
        }

        while (null != edge) {
            //�ڵ�δ����
            if (edge.vertexId == y) {
                if (null != edge.next) {
                    next_node = edge.next.vertexId;
                    if (!states.get(next_node))
                        return next_node;
                } else
                    return -1;
            }
            edge = edge.next;
        }
        return -1;
    }

    //����ĳ�ڵ��Ƿ���stack��,���������·
    public Map<Integer, Boolean> states = new HashMap();

    //��ŷ���stack�еĽڵ�
    public Stack<Integer> stack = new Stack();

    //���2���ڵ�֮������·��
    public void visit(int x, int y) {
        //��ʼ�����нڵ���stack�е����
        for (int i = 0; i < vertexNum; i++) {
            states.put(i, false);
        }
        //stack topԪ��
        int top_node;
        //��ŵ�ǰtopԪ���Ѿ����ʹ����ڽӵ�,������������-1,��ʱ������ʸ�topԪ�صĵ�һ���ڽӵ�
        int adjvex_node = -1;
        int next_node;
        stack.add(x);
        states.put(x, true);
        while (!stack.isEmpty()) {
            top_node = stack.peek();
            //�ҵ���Ҫ���ʵĽڵ�
            if (top_node == y) {
                //��ӡ��·��
                printPath();
                adjvex_node = stack.pop();
                states.put(adjvex_node, false);
            } else {
                //����top_node�ĵ�advex_node���ڽӵ�
                next_node = getNextNode(top_node, adjvex_node);
                if (next_node != -1) {
                    stack.push(next_node);
                    //�õ�ǰ�ڵ����״̬Ϊ����stack��
                    states.put(next_node, true);
                    //�ٽӵ�����
                    adjvex_node = -1;
                }
                //�������ٽӵ㣬��stack topԪ���˳�
                else {
                    //��ǰ�Ѿ����ʹ���top_node�ĵ�adjvex_node�ڽӵ�
                    adjvex_node = stack.pop();
                    //����stack��
                    states.put(adjvex_node, false);
                }
            }
        }
    }

    //��ӡstack����Ϣ,��·����Ϣ
    public void printPath() {
        StringBuilder sb = new StringBuilder();
        for (Integer i : stack) {
            sb.append(i + "->");
        }
        sb.delete(sb.length() - 2, sb.length());
        System.out.println(sb.toString());
    }

}

public class GraphPathSearch2 {
    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.initVertext(new int[]{1, 2, 3, 4, 4});
        //System.out.println(g.vertexList[0]);
        g.addEdge(0, 1, 1);
        g.addEdge(0, 2, 3);
        g.addEdge(0, 3, 4);
        g.addEdge(1, 2, 1);
        g.addEdge(2, 3, 1);
//        g.addEdge(2, 0, 1);
//        g.addEdge(1, 3, 2);
        g.visit(0, 3);
    }
}
