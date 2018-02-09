import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class GraphAlgorithms implements IGraphAlgorithms {

	@Override
	public boolean isDirected(List<GraphNode> graph) {
		for (GraphNode g : graph) {
			for (GraphNode g1 : g.getAdjacentNodes()) {
				if (!g1.getAdjacentNodes().contains(g)) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public Collection<GraphNode> getRoots(List<GraphNode> graph) {
		List<GraphNode> root = new LinkedList<>();
		for (GraphNode g : graph) {
			root.add(g);
		}

		for (GraphNode g : graph) {
			for (GraphNode g1 : g.getAdjacentNodes()) {
				if (root.contains(g1)) {
					root.remove(root.indexOf(g1));
				}
			}
		}
		return root;
	}

	@Override
	public List<List<GraphNode>> getComponents(List<GraphNode> graph) {
		List<List<GraphNode>> tmp = new LinkedList<>();

		Comparator<GraphNode> c = new Comparator<GraphNode>() {
			@Override
			public int compare(GraphNode o1, GraphNode o2) {
				return o1.toString().compareTo(o2.toString());
			}
		};

		for (GraphNode g : graph) {
			ArrayList<GraphNode> visited = new ArrayList<>();
			Queue<GraphNode> toVisit = new ArrayDeque<>();
			toVisit.add(g);
			while (!toVisit.isEmpty()) {
				GraphNode pointer = toVisit.poll();
				if (pointer != null) {
					visited.add(pointer);
					for (GraphNode s : pointer.getAdjacentNodes()) {
						if (!visited.contains(s) && !toVisit.contains(s)) {
							toVisit.add(s);
						}
					}
				}
			}
			tmp.add(visited);
		}

		List<List<GraphNode>> end = new LinkedList<>();
		for (List<GraphNode> l : tmp) {
			Set<GraphNode> set = new LinkedHashSet<>(l);
			for (List<GraphNode> l1 : tmp) {
				for (GraphNode g : l1) {
					if (set.contains(g)) {
						set.addAll(l1);
					}
				}
			}
			List<GraphNode> list = new ArrayList<>(set);
			list.sort(c);
			if (!end.contains(list)) {
				end.add(list);
			}

		}

		return end;
	}

	@Override
	public List<GraphNode> getACycle(List<GraphNode> graph) {

		for (GraphNode g : graph) {
			ArrayList<GraphNode> visited = new ArrayList<>();
			Queue<GraphNode> toVisit = new ArrayDeque<>();
			toVisit.add(g);
			while (!toVisit.isEmpty()) {
				GraphNode pointer = toVisit.poll();
				if (pointer != null) {
					visited.add(pointer);
					for (GraphNode s : pointer.getAdjacentNodes()) {
						if (visited.contains(s)) {
							visited.add(s);
							return visited;
						} else if (!visited.contains(s) && !toVisit.contains(s)) {
							toVisit.add(s);
						}

					}
				}
			}
		}
		return null;
	}

	@Override
	public GraphConnectivityType classifyConnectivity(List<GraphNode> graph) {
		if(graph.size() == 0) {
			return GraphConnectivityType.EMPTY;
		}else if(isDirected(graph) && getComponents(graph).size() == 1) {
			return GraphConnectivityType.STRONGLY_CONNECTED;
		}else if(!isDirected(graph) && getRoots(graph).size() == 1) {
			return GraphConnectivityType.CONNECTED;
		}else if(getComponents(graph).size() > 1) {
			return GraphConnectivityType.WEAKLY_CONNECTED;
		}
		return GraphConnectivityType.DISCONNECTED;
	}

}
