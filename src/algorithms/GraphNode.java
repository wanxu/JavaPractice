package algorithms;

import java.util.ArrayList;

/**
 * Created by Json Wan on 2018/10/18.
 * ͼ�ڵ㣨�ڽӱ���ʽ��
 */
public class GraphNode {
    public String name = null;
    public ArrayList<GraphNode> relationNodes = new ArrayList<GraphNode>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<GraphNode> getRelationNodes() {
        return relationNodes;
    }

    public void setRelationNodes(ArrayList<GraphNode> relationNodes) {
        this.relationNodes = relationNodes;
    }
}
