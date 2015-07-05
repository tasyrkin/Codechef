import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class LonglongestPathTree {

    private static class Edge {
        int from;
        int to;
        Integer cost;

        private Edge(final int from, final int to, final int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    private static class Node {
        int id;
        long costToRoot;
        Edge edge;

        private Node(final int id, final long costToRoot, final Edge edge) {
            this.id = id;
            this.costToRoot = costToRoot;
            this.edge = edge;
        }
    }

    private static class Cmp implements Comparator<Edge> {

        @Override
        public int compare(final Edge o1, final Edge o2) {
            return o2.cost.compareTo(o1.cost);
        }
    }

    public long getLength(final int[] A, final int[] B, final int[] L) {
        Map<Integer, List<Edge>> index = new HashMap<Integer, List<Edge>>();
        Map<Integer, List<Edge>> revIndex = new HashMap<Integer, List<Edge>>();

        int root = -1;
        for (int i = 0; i < A.length; i++) {
            Edge curr = new Edge(A[i], B[i], L[i]);
            List<Edge> edges = index.get(curr.from);
            if (edges == null) {
                edges = new ArrayList<Edge>();
            }

            edges.add(curr);
            index.put(curr.from, edges);

            Edge currRev = new Edge(B[i], A[i], L[i]);
            List<Edge> nodesRev = revIndex.get(currRev.from);
            if (nodesRev == null) {
                nodesRev = new ArrayList<Edge>();
            }

            nodesRev.add(currRev);
            revIndex.put(currRev.from, nodesRev);
            root = curr.from;
        }

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(new Node(root, 0, null));

        Set<Node> leaves = new HashSet<Node>();
        Set<Integer> visited = new HashSet<Integer>();

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            if (visited.contains(curr.id)) {
                continue;
            }

            visited.add(curr.id);

            List<Edge> edgesDirect = index.get(curr.id);
            List<Edge> edgesReverse = revIndex.get(curr.id);
            boolean wasSomethingAdded = false;
            if (edgesDirect != null) {
                for (Edge ch : edgesDirect) {
                    if (!visited.contains(ch.to)) {
                        wasSomethingAdded = true;
                        queue.offer(new Node(ch.to, curr.costToRoot + ch.cost, ch));
                    }
                }
            }

            if (edgesReverse != null) {
                for (Edge ch : edgesReverse) {
                    if (!visited.contains(ch.to)) {
                        wasSomethingAdded = true;
                        queue.offer(new Node(ch.to, curr.costToRoot + ch.cost, ch));
                    }

                }
            }

            if (!wasSomethingAdded) {
                leaves.add(curr);
            }
        }

        Node[] leaveNodes = leaves.toArray(new Node[0]);

        PriorityQueue<Edge> pq = new PriorityQueue<Edge>(2000, new Cmp());
        for (int i = 0; i < leaveNodes.length; i++) {
            pq.offer(leaveNodes[i].edge);
        }

        if (leaveNodes.length == 1) {
            return leaveNodes[0].costToRoot;
        }

        if (leaveNodes.length == 2) {
            return leaveNodes[0].costToRoot + leaveNodes[1].costToRoot;
        }

        long res = -1;
        for (int i = 0; i < leaveNodes.length; i++) {
            for (int j = i + 1; j < leaveNodes.length; j++) {
                pq.remove(leaveNodes[i].edge);
                pq.remove(leaveNodes[j].edge);

                Edge max = pq.peek();
                long curr = leaveNodes[i].costToRoot + leaveNodes[j].costToRoot + max.cost;
                if (curr > res) {
                    res = curr;
                }

                pq.add(leaveNodes[i].edge);
                pq.add(leaveNodes[j].edge);
            }
        }

        return res;
    }

    public static void main(final String[] args) {

        // System.out.println(new LonglongestPathTree().getLength(new int[] {0, 0, 0}, new int[] {1, 2, 3},
        // new int[] {2, 4, 8}));
        // System.out.println(new LonglongestPathTree().getLength(new int[] {0, 1, 2, 3}, new int[] {1, 2, 3, 4},
        // new int[] {1, 2, 3, 4}));
        System.out.println(new LonglongestPathTree().getLength(new int[] {0, 1, 0, 3, 0, 6, 7, 7, 8, 9, 11},
                new int[] {1, 2, 3, 4, 5, 5, 5, 8, 9, 10, 9},
                new int[] {100, 1000, 100, 1000, 1, 10, 10, 10, 10, 100, 100}));
    }
}
