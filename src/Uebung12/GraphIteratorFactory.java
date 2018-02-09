import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class GraphIteratorFactory implements IGraphIteratorFactory {

	@Override
	public Iterator<GraphNode> createGraphIteratorBFS(List<GraphNode> graph) {

		ArrayList<GraphNode> visited = new ArrayList<>();
		Queue<GraphNode> toVisit = new ArrayDeque<>();
		for (GraphNode s : graph) {
			if (!visited.contains(s)) {
				toVisit.add(s);
				while (!toVisit.isEmpty()) {
					GraphNode tmp = toVisit.poll();
					if (tmp != null) {
						visited.add(tmp);
						for (GraphNode g : tmp.getAdjacentNodes()) {
							if (!visited.contains(g) && !toVisit.contains(g)) {
								toVisit.add(g);
							}
						}
					}
				}
			}
		}
		Iterator<GraphNode> iterator = new Iterator<GraphNode>() {
			ArrayList<GraphNode> order = visited;
			Iterator<GraphNode> i = order.iterator();

			@Override
			public boolean hasNext() {
				return i.hasNext();
			}

			@Override
			public GraphNode next() {
				return i.next();
			}
		};
		return iterator;
	}

	@Override
	public Iterator<GraphNode> createGraphIteratorDFS(List<GraphNode> graph) {
		
		ArrayList<GraphNode> visited = new ArrayList<>();
		Stack<GraphNode> toVisit = new Stack<>();
		for (GraphNode s : graph) {
			if (!visited.contains(s)) {
				toVisit.add(s);
				while (!toVisit.isEmpty()) {
					GraphNode tmp = toVisit.pop();
					if (tmp != null) {
						visited.add(tmp);
						
						List<GraphNode> g = tmp.getAdjacentNodes();
						for(int i = g.size()-1; i >= 0; i--) {
							if (!visited.contains(g.get(i)) && !toVisit.contains(g.get(i))) {
								toVisit.add(g.get(i));
							}
						}
					}
				}
			}
		}

		Iterator<GraphNode> iterator = new Iterator<GraphNode>() {
			ArrayList<GraphNode> order = visited;
			Iterator<GraphNode> i = order.iterator();

			@Override
			public boolean hasNext() {
				return i.hasNext();
			}

			@Override
			public GraphNode next() {
				return i.next();
			}

		};
		return iterator;
	}

}
