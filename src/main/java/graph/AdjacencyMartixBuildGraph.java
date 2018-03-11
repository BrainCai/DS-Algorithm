package graph;

import java.util.Scanner;

import org.junit.Test;

import utile.PrintMessageUtil;

public class AdjacencyMartixBuildGraph {

	static Scanner inputTool = new Scanner(System.in);

	public void initGraph(GraphDNWithAdjMatrix graph) {

		// 检查入参是否为空
		graph = checkInputParameter(graph);

		// 输入顶点个数
		inputGraphNum(graph);
	}

	/**
	 * 检查入参是否为空
	 * 
	 * @param graph
	 * @return
	 */
	private GraphDNWithAdjMatrix checkInputParameter(GraphDNWithAdjMatrix graph) {
		if (graph == null) {
			graph = new GraphDNWithAdjMatrix();
		}
		return graph;
	}

	/**
	 * 对图的初始化
	 * 
	 * @param graph
	 */
	private void inputGraphNum(GraphDNWithAdjMatrix graph) {

		// 初始化图中顶点的个数和邻接矩阵
		initVertexNumAndAdjMartix(graph);

		// 初始化顶点的名称
		initVertexName(graph);

		// 初始化边数
		initEdgeNum(graph);

		// 根据边关系初始化矩阵
		bulidAdjMatrix(graph);
	}

	/**
	 * 初始化图中顶点的个数和邻接矩阵
	 * 
	 * @param graph
	 */
	private void initVertexNumAndAdjMartix(GraphDNWithAdjMatrix graph) {

		PrintMessageUtil.printMsgWithNewLine("请输入顶点的个数 :)");
		int vertexNum = getVertexNum();
		graph.verNum = vertexNum;
		graph.vertexArray = new int[vertexNum][vertexNum];
	}

	private int getVertexNum() {
		int verNum;
		while ((verNum = inputTool.nextInt()) <= 1) {
			PrintMessageUtil.printMsgWithNewLine("输入的点的个数必须大于等于1 :)");
		}
		return verNum;
	}

	/**
	 * 初始化顶点的名称,并对顶点按序存储
	 * 
	 * @param graph
	 */
	private void initVertexName(GraphDNWithAdjMatrix graph) {
		PrintMessageUtil.printMsgWithNewLine("请输入顶点的名称:)");
		int verNum = graph.verNum;// 注意此处将顶点数拷贝为局部变量
		graph.vertexName = new String[verNum];
		int idx = 0;
		while (verNum > 0) {
			graph.vertexName[idx] = inputTool.next();
			idx++;
			verNum--;
		}

	}

	/**
	 * 初始化边数
	 * 
	 * @param graph
	 */
	private void initEdgeNum(GraphDNWithAdjMatrix graph) {
		int edgeNum = 0;
		int edgeNumMax = 0;
		int verNum = graph.verNum;
		while (true) {
			PrintMessageUtil.printMsgWithNewLine("输入边数:)");
			edgeNum = inputTool.nextInt();
			edgeNumMax = verNum * (verNum - 1) / 2;
			if (edgeNum <= 0 || edgeNum > edgeNumMax) {
				PrintMessageUtil.printMsgWithNewLine("输入的边数必须大于 0 小于等于" + edgeNumMax + "范围内");
				continue;
			} else {
				graph.edgeNum = edgeNum;
				break;
			}
		}
	}

	/**
	 * 根据边的关系构建邻接矩阵
	 * 
	 * @param graph
	 */
	private void bulidAdjMatrix(GraphDNWithAdjMatrix graph) {
		PrintMessageUtil.printMsgWithNewLine("根据顶点输入边关系");
		for (int i = 0; i < graph.edgeNum; i++) {
			String proVerName = inputTool.next();// 前一个顶点
			String floVerName = inputTool.next();// 后一个顶点
			int proVerIdx = getVerIdx(proVerName, graph);
			int floVerIdx = getVerIdx(floVerName, graph);
			graph.vertexArray[proVerIdx][floVerIdx] = 1;
			// graph.vertexArray[floVerIdx][proVerIdx] = 1;// 根据对称性只需要存储一半即可
		}
	}

	/**
	 * 根据传入的顶点名称获取顶点的位置
	 * 
	 * @param proVerName
	 * @return
	 */
	private int getVerIdx(String verName, GraphDNWithAdjMatrix graph) {
		for (int i = 0; i < graph.verNum; i++) {
			if (graph.vertexName[i].equals(verName)) {
				return i;
			}
		}
		PrintMessageUtil.printMsgWithNewLine("输入的顶点不在图中");
		return -1;
	}

	/**
	 * 根据idx返回元素的顶点
	 * 
	 * @param verIdx
	 * @param graph
	 * @return
	 */
	private String getVerName(int verIdx, GraphDNWithAdjMatrix graph) {
		if (graph == null || verIdx >= graph.vertexName.length) {
			return null;
		}
		String[] verNameArray = graph.vertexName;
		for (int i = 0; i < verNameArray.length; i++) {
			if (verIdx == i) {
				return verNameArray[i];
			}
		}
		return null;
	}

	private void outputGrap(GraphDNWithAdjMatrix graph) {
		if (graph == null) {
			return;
		}
		int[][] adjMatrix = graph.vertexArray;
		for (int i = 0; i < graph.verNum; i++) {
			for (int j = 0; j < graph.verNum; j++) {
				if (adjMatrix[i][j] == 1) {
					String proVerStr = getVerName(i, graph);
					String floVerStr = getVerName(j, graph);
					// adjMatrix[j][i] = 0;
					PrintMessageUtil.printMsgWithoutNewLine(proVerStr + " - " + floVerStr + " | ");
				}
			}
		}
	}

	@Test
	public void test() {
		// getVertexNum();
		GraphDNWithAdjMatrix graph = new GraphDNWithAdjMatrix();
		initGraph(graph);
		outputGrap(graph);
	}

	class GraphDNWithAdjMatrix {
		int[][] vertexArray;// 存放顶点的数组
		int verNum = 0;// 顶点的总数
		int edgeNum = 0;// 边数
		String[] vertexName;// 顶点名称
	}

}
