package graph;

import java.util.Scanner;

import org.junit.Test;

/**
 * 基于邻接表存储图
 * 
 * @author Administrator
 *
 */

public class AdjacencyListBuildGraph {
	static Scanner inputTool = new Scanner(System.in);

	/**
	 * 根据用户输入的数据初始化一个图，以邻接表的形式构建!
	 * 
	 * @param graph
	 *            生成的图
	 */
	public void initialGraph(GraphDNWithAdjList graph) {

		// 输入点数和边数
		inputVexNumAndEdgeNum(graph);

		// 输入顶点的名称
		inputVexNam(graph);

		// 输入使用顶点表示边
		inputEdgeInVex(graph);

	}

	/**
	 * 
	 * @param graph
	 */
	private void outputGraphNode(GraphDNWithAdjList graph) {
		printMessage("打印图邻接表");
		for (int i = 0; i < graph.verNum; i++) {
			// 获取了顶点
			Vertex1 vertex1 = graph.vertexArray[i];
			// 遍历当前顶点的链表
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
		printMessage("输入顶点表示的边：");
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
				// 此处需要创建新的结点
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
			printMessage(nodeName + "不在图中");
			return false;
		}
		return true;
	}

	/**
	 * 根据输入顶点名称，判断该点是否在图中
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
		printMessage("输入顶点的名称：");
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
		printMessage("输入顶点数和边数：");
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
	 * 图
	 * 
	 * @author BrianCai
	 *
	 */

	class GraphDNWithAdjList {
		Vertex1[] vertexArray = new Vertex1[100];// 存放顶点的数组
		int verNum = 0;// 顶点的总数
		int edgeNum = 0;// 边数
	}

	/**
	 * 图的顶点
	 * 
	 * @author BrianCai
	 *
	 */
	class Vertex1 {
		String verName;
		Vertex1 nextNode;
	}

}