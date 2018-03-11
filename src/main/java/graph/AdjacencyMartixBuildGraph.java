package graph;

import java.util.Scanner;

import org.junit.Test;

import utile.PrintMessageUtil;

public class AdjacencyMartixBuildGraph {

	static Scanner inputTool = new Scanner(System.in);

	public void initGraph(GraphDNWithAdjMatrix graph) {

		// �������Ƿ�Ϊ��
		graph = checkInputParameter(graph);

		// ���붥�����
		inputGraphNum(graph);
	}

	/**
	 * �������Ƿ�Ϊ��
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
	 * ��ͼ�ĳ�ʼ��
	 * 
	 * @param graph
	 */
	private void inputGraphNum(GraphDNWithAdjMatrix graph) {

		// ��ʼ��ͼ�ж���ĸ������ڽӾ���
		initVertexNumAndAdjMartix(graph);

		// ��ʼ�����������
		initVertexName(graph);

		// ��ʼ������
		initEdgeNum(graph);

		// ���ݱ߹�ϵ��ʼ������
		bulidAdjMatrix(graph);
	}

	/**
	 * ��ʼ��ͼ�ж���ĸ������ڽӾ���
	 * 
	 * @param graph
	 */
	private void initVertexNumAndAdjMartix(GraphDNWithAdjMatrix graph) {

		PrintMessageUtil.printMsgWithNewLine("�����붥��ĸ��� :)");
		int vertexNum = getVertexNum();
		graph.verNum = vertexNum;
		graph.vertexArray = new int[vertexNum][vertexNum];
	}

	private int getVertexNum() {
		int verNum;
		while ((verNum = inputTool.nextInt()) <= 1) {
			PrintMessageUtil.printMsgWithNewLine("����ĵ�ĸ���������ڵ���1 :)");
		}
		return verNum;
	}

	/**
	 * ��ʼ�����������,���Զ��㰴��洢
	 * 
	 * @param graph
	 */
	private void initVertexName(GraphDNWithAdjMatrix graph) {
		PrintMessageUtil.printMsgWithNewLine("�����붥�������:)");
		int verNum = graph.verNum;// ע��˴�������������Ϊ�ֲ�����
		graph.vertexName = new String[verNum];
		int idx = 0;
		while (verNum > 0) {
			graph.vertexName[idx] = inputTool.next();
			idx++;
			verNum--;
		}

	}

	/**
	 * ��ʼ������
	 * 
	 * @param graph
	 */
	private void initEdgeNum(GraphDNWithAdjMatrix graph) {
		int edgeNum = 0;
		int edgeNumMax = 0;
		int verNum = graph.verNum;
		while (true) {
			PrintMessageUtil.printMsgWithNewLine("�������:)");
			edgeNum = inputTool.nextInt();
			edgeNumMax = verNum * (verNum - 1) / 2;
			if (edgeNum <= 0 || edgeNum > edgeNumMax) {
				PrintMessageUtil.printMsgWithNewLine("����ı���������� 0 С�ڵ���" + edgeNumMax + "��Χ��");
				continue;
			} else {
				graph.edgeNum = edgeNum;
				break;
			}
		}
	}

	/**
	 * ���ݱߵĹ�ϵ�����ڽӾ���
	 * 
	 * @param graph
	 */
	private void bulidAdjMatrix(GraphDNWithAdjMatrix graph) {
		PrintMessageUtil.printMsgWithNewLine("���ݶ�������߹�ϵ");
		for (int i = 0; i < graph.edgeNum; i++) {
			String proVerName = inputTool.next();// ǰһ������
			String floVerName = inputTool.next();// ��һ������
			int proVerIdx = getVerIdx(proVerName, graph);
			int floVerIdx = getVerIdx(floVerName, graph);
			graph.vertexArray[proVerIdx][floVerIdx] = 1;
			// graph.vertexArray[floVerIdx][proVerIdx] = 1;// ���ݶԳ���ֻ��Ҫ�洢һ�뼴��
		}
	}

	/**
	 * ���ݴ���Ķ������ƻ�ȡ�����λ��
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
		PrintMessageUtil.printMsgWithNewLine("����Ķ��㲻��ͼ��");
		return -1;
	}

	/**
	 * ����idx����Ԫ�صĶ���
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
		int[][] vertexArray;// ��Ŷ��������
		int verNum = 0;// ���������
		int edgeNum = 0;// ����
		String[] vertexName;// ��������
	}

}
