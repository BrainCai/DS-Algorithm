package graph;

import java.util.Scanner;

import org.junit.Test;

/**
 * �����ڽӱ�洢ͼ
 * 
 * @author Administrator
 *
 */

public class AdjacencyListBuildGraph {
	static Scanner inputTool = new Scanner(System.in);

	/**
	 * �����û���������ݳ�ʼ��һ��ͼ�����ڽӱ����ʽ����!
	 * 
	 * @param graph
	 *            ���ɵ�ͼ
	 */
	public void initialGraph(GraphDNWithAdjList graph) {

		// ��������ͱ���
		inputVexNumAndEdgeNum(graph);

		// ���붥�������
		inputVexNam(graph);

		// ����ʹ�ö����ʾ��
		inputEdgeInVex(graph);

	}

	/**
	 * 
	 * @param graph
	 */
	private void outputGraphNode(GraphDNWithAdjList graph) {
		printMessage("��ӡͼ�ڽӱ�");
		for (int i = 0; i < graph.verNum; i++) {
			// ��ȡ�˶���
			Vertex1 vertex1 = graph.vertexArray[i];
			// ������ǰ���������
			while (vertex1 != null) {
				printMessageWithoutEnter(vertex1.verName);
				if (vertex1.nextNode != null) {
					printMessageWithoutEnter("-->");
				}
				vertex1 = vertex1.nextNode;
			}
			printMessage("");
		}
	}

	/**
	 * 
	 * @param graph
	 */
	private void inputEdgeInVex(GraphDNWithAdjList graph) {
		printMessage("���붥���ʾ�ıߣ�");
		for (int i = 0; i < graph.edgeNum; i++) {
			String preName = inputTool.next();
			String floName = inputTool.next();
			Vertex1 preNode = getVertex(graph, preName);
			Vertex1 floNode = getVertex(graph, floName);
			if (checkNodeInGraph(preName, preNode) && checkNodeInGraph(floName, floNode)) {
				bulidNodeList(graph, preNode, floNode);
			}
		}
	}

	/**
	 * 
	 * @param graph
	 * @param preNode
	 * @param floNode
	 */
	private void bulidNodeList(GraphDNWithAdjList graph, Vertex1 preNode, Vertex1 floNode) {
		for (int i = 0; i < graph.verNum; i++) {
			if (preNode.verName.equals(graph.vertexArray[i].verName)) {
				// �˴���Ҫ�����µĽ��
				Vertex1 vertex1 = new Vertex1();
				vertex1.verName = floNode.verName;
				vertex1.nextNode = preNode.nextNode;
				preNode.nextNode = vertex1;
			}
		}

	}

	/**
	 * 
	 * @param nodeName
	 * @param node
	 * @return
	 */
	private boolean checkNodeInGraph(String nodeName, Vertex1 node) {
		if (node == null) {
			printMessage(nodeName + "����ͼ��");
			return false;
		}
		return true;
	}

	/**
	 * �������붥�����ƣ��жϸõ��Ƿ���ͼ��
	 * 
	 * @param graph
	 * @param pre
	 * @return
	 */
	private Vertex1 getVertex(GraphDNWithAdjList graph, String pre) {
		for (int i = 0; i < graph.verNum; i++) {
			if (graph.vertexArray[i].verName.equals(pre)) {
				return graph.vertexArray[i];
			}
		}
		return null;
	}

	/**
	 * 
	 * @param graph
	 */
	private void inputVexNam(GraphDNWithAdjList graph) {
		printMessage("���붥������ƣ�");
		for (int i = 0; i < graph.verNum; i++) {
			Vertex1 vertex1 = new Vertex1();
			vertex1.verName = inputTool.next();
			graph.vertexArray[i] = vertex1;
		}
	}

	/**
	 * 
	 * @param graph
	 */
	private void inputVexNumAndEdgeNum(GraphDNWithAdjList graph) {
		printMessage("���붥�����ͱ�����");
		graph.verNum = inputTool.nextInt();
		graph.edgeNum = inputTool.nextInt();
	}

	/**
	 * 
	 * @param messsage
	 */
	private void printMessage(String messsage) {
		System.out.println(messsage);
	}

	/**
	 * 
	 * @param messsage
	 */
	private void printMessageWithoutEnter(String messsage) {
		System.out.print(messsage);
	}

	@Test
	public void test() {
		GraphDNWithAdjList graph = new GraphDNWithAdjList();
		initialGraph(graph);
		outputGraphNode(graph);
	}

	/**
	 * ͼ
	 * 
	 * @author BrianCai
	 *
	 */

	class GraphDNWithAdjList {
		Vertex1[] vertexArray = new Vertex1[100];// ��Ŷ��������
		int verNum = 0;// ���������
		int edgeNum = 0;// ����
	}

	/**
	 * ͼ�Ķ���
	 * 
	 * @author BrianCai
	 *
	 */
	class Vertex1 {
		String verName;
		Vertex1 nextNode;
	}

}