package co.aurasphere.skillvalue;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

	private static Queue<Node> openList;
	private static List<Node> closedList = new ArrayList<Node>();;
	private static int m, n;
	private static int[][] matrix;

	// Node of the graph for the algorithm.
	public static class Node extends Point {
		// Moves to reach this node.
		public List<Integer> moves = new ArrayList<Integer>();
		// Cost of this node.
		int cost;

		public Node(int x, int y) {
			super(x, y);
		}

		public Node(int x, int y, Node parent, int direction) {
			super(x, y);
			// Checks if this node is valid. If it is, adds to the graph.
			if (x > -1 && y > -1 && x < m && y < n && !closedList.contains(this)) {
				moves.addAll(parent.moves);
				moves.add(direction);
				cost = parent.cost + matrix[x][y];
				openList.offer(this);
			}
		}
	}

	public static void main(String[] args) {
		BufferedReader in;
		Integer[] result = null;
		int E = 0;
		try {
			in = new BufferedReader(new FileReader(new File(args[0])));
			E = Integer.valueOf(in.readLine());
			m = Integer.valueOf(in.readLine());
			n = Integer.valueOf(in.readLine());
			matrix = new int[m][n];
			for (int i = 0; i < m; i++) {
				String[] line = in.readLine().split(" ");
				for (int j = 0; j < line.length; j++) {
					matrix[i][j] = Integer.valueOf(line[j]);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		/* YOUR CODE HERE */
		// Start and end node.
		Node start = new Node(0, 0);
		Node end = new Node(m - 1, n - 1);

		// Local matrix for closure reference.
		final int[][] localMatrix = matrix;

		// Unexplored nodes.
		openList = new PriorityQueue<Node>(
				(p1, p2) -> Integer.compare(localMatrix[p1.x][p1.y], localMatrix[p2.x][p2.y]));

		// Adds the first node to the "to explore" list.
		openList.add(start);

		// Main loop.
		while (!openList.isEmpty()) {
			Node q = openList.poll();

			// Stop if we reached the end and prints the moves or -1 if the cost
			// has been exceeded.
			if (q.equals(end)) {
				if (q.cost > E) {
					result = new Integer[] { -1 };
				} else {
					result = q.moves.toArray(new Integer[q.moves.size()]);
				}
				break;
			}

			// Explores the successors.
			new Node(q.x + 1, q.y, q, 3);
			new Node(q.x, q.y - 1, q, 2);
			new Node(q.x - 1, q.y, q, 1);
			new Node(q.x, q.y + 1, q, 0);

			// This node has been fully explored.
			closedList.add(q);
		}

		/* result should be an array. Check exercise description */
		for (int j = 0; j < result.length; j++) {
			System.out.print(result[j]);
			if (j < result.length - 1) {
				System.out.print(" ");
			}
		}
		System.out.println();
	}
}
