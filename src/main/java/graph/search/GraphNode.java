package graph.search;

import java.util.ArrayList;
import java.util.List;

/**
 * ͼ����Ķ���
 * 
 * @author BrianCai
 *
 */
public class GraphNode {
	public List<GraphEdge> edgeList = null;

	private String label = "";

	public GraphNode(String label) {
		this.label = label;
		if (edgeList == null) {
			edgeList = new ArrayList<GraphEdge>();
		}
	}

	/**
	 * ����ǰ�ڵ�����һ���� GraphNode
	 * 
	 * @param edge
	 *            ���ӵı�
	 */
	public void addEdgeList(GraphEdge edge) {
		edgeList.add(edge);
	}

	public String getLabel() {
		return label;
	}
}