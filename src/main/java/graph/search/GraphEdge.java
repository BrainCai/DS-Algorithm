package graph.search;

/**
 * ͼ�ߵĶ���
 * 
 * @author BrianCai
 *
 */
public class GraphEdge {
	private GraphNode nodeLeft;

	private GraphNode nodeRight;

	/**
	 * @param nodeLeft
	 *            �ߵ����
	 * @param nodeRight
	 *            �ߵ��Ҷ�
	 */
	public GraphEdge(GraphNode nodeLeft, GraphNode nodeRight) {
		this.nodeLeft = nodeLeft;
		this.nodeRight = nodeRight;
	}

	public GraphNode getNodeLeft() {
		return nodeLeft;
	}

	public GraphNode getNodeRight() {
		return nodeRight;
	}
}
