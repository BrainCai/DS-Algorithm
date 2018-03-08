package graph.search;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class DFSearch {
	/**
	 * ��ȱ��� DFSearch
	 * 
	 * @param node
	 *            ��ǰ�ڵ�
	 * @param visited
	 *            �����ʹ��Ľڵ��б�
	 */
	public void searchTraversing(GraphNode node, List<GraphNode> visited) {
		// �ж��Ƿ������
		if (visited.contains(node)) {
			return;
		}

		visited.add(node);
		System.out.println("�ڵ㣺" + node.getLabel());
		for (int i = 0; i < node.edgeList.size(); i++) {
			searchTraversing(node.edgeList.get(i).getNodeRight(), visited);
		}
	}

	@Test
	public void test() {
		Graph graph = new Graph();
		graph.initGraph();
		searchTraversing(graph.getGraphNodes().get(0), new ArrayList<>());
	}
}
