import java.util.LinkedList;

public class BinTreeNode<T extends Comparable<T>> extends AbstractBinTreeNode<T> {

	public BinTreeNode(T value) {
		super(value);
	}

	public BinTreeNode(T value, AbstractBinTreeNode<T> left, AbstractBinTreeNode<T> right) {
		super(value, left, right);
	}

	@Override
	public void addLeft(T value) {
		this.left = new BinTreeNode<T>(value);
		this.getLeft().parent = this;

	}

	@Override
	public void addRight(T value) {
		this.right = new BinTreeNode<T>(value);
		this.getRight().parent = this;
	}

	@Override
	public boolean isLeftChild() {
		return parent != null ? parent.getLeft() == this : false;
	}

	@Override
	public boolean isRightChild() {
		return parent != null ? parent.getRight() == this : false;
	}

	@Override
	public void swap(AbstractBinTreeNode<T> other) {
		T tmp = this.value;
		this.value = other.getValue();
		other.value = tmp;

	}

	@Override
	public int getHeight() {
		if (left == null && right == null) {
			return 0;
		} else if (left == null || right == null) {
			return left == null ? right.getHeight() + 1 : left.getHeight() + 1;
		}
		return left.getHeight() >= right.getHeight() ? left.getHeight() + 1 : right.getHeight();
	}

	@Override
	protected AbstractBinTreeNode<T> findNode(T value) {
		if (getValue().compareTo(value) == 0) {
			return this;
		} else if (getValue().compareTo(value) > 0 && left != null) {
			return left.findNode(value);
		} else if (getValue().compareTo(value) < 0 && right != null) {
			return right.findNode(value);
		}
		return this;
	}

	@Override
	public boolean contains(T value) {
		return findNode(value).getValue().compareTo(value) == 0;
	}

	@Override
	public boolean insert(T value) {
		if (contains(value)) {
			return false;
		}
		AbstractBinTreeNode<T> tmp = findNode(value);

		if (tmp.getValue().compareTo(value) > 0) {
			tmp.addLeft(value);
		} else {
			tmp.addRight(value);
		}
		return true;

	}

	@Override
	public AbstractBinTreeNode<T> getMinNode() {
		if (left != null) {
			return left.getMinNode();
		}
		return this;
	}

	@Override
	public AbstractBinTreeNode<T> getMaxNode() {
		if (right != null) {
			return right.getMaxNode();
		}
		return this;
	}

	@Override
	public AbstractBinTreeNode<T> deleteNode() {
		if (left == null && right == null) {
			if (parent != null) {
				if (parent.right == this) {
					parent.right = null;
				} else {
					parent.left = null;
				}
				return null;
			}
		} else if (right != null) {
			AbstractBinTreeNode<T> min = right.getMinNode();
			if (right == min) {
				swap(right);
				this.right = this.right.right;
				if (right != null) {
					this.right.parent = this;
				}
			} else {
				swap(min);
				min.deleteNode();
			}
		} else {
			swap(left);
			left.deleteNode();
		}
		return this;
	}

	@Override
	public boolean delete(T value) {
		if (!contains(value)) {
			return false;
		}

		BinTreeNode<T> node = (BinTreeNode<T>) findNode(value);
		node.deleteNode();
		return true;

	}

	@Override
	public LinkedList<T> traverse(TreeTraversalOrderType traversalOrder) {
		return traversalOrder == TreeTraversalOrderType.IN ? traverseIn()
				: traversalOrder == TreeTraversalOrderType.PRE ? traversePre() : traversePost();
	}

	private LinkedList<T> traverseIn() {
		LinkedList<T> list = new LinkedList<T>();
		if (getLeft() != null) {
			list.addAll(getLeft().traverse(TreeTraversalOrderType.IN));
		}
		list.add(value);
		if (getRight() != null) {
			list.addAll(getRight().traverse(TreeTraversalOrderType.IN));
		}
		return list;
	}

	private LinkedList<T> traversePre() {
		LinkedList<T> list = new LinkedList<T>();
		list.add(value);
		if (getLeft() != null) {
			list.addAll(getLeft().traverse(TreeTraversalOrderType.PRE));
		}
		if (getRight() != null) {
			list.addAll(getRight().traverse(TreeTraversalOrderType.PRE));
		}
		return list;
	}

	private LinkedList<T> traversePost() {
		LinkedList<T> list = new LinkedList<T>();
		if (getLeft() != null) {
			list.addAll(getLeft().traverse(TreeTraversalOrderType.POST));
		}
		if (getRight() != null) {
			list.addAll(getRight().traverse(TreeTraversalOrderType.POST));
		}
		list.add(value);
		return list;
	}

	@Override
	public AbstractBinTreeNode<T> nextNode() {
		AbstractBinTreeNode<T> root;
		root = this;
		if (root.parent != null) {
			root = root.parent;
		}
		if (root.getParent() != null) {
			root = root.getParent();
		}
		LinkedList<T> tmp = root.traverse(TreeTraversalOrderType.IN);

		for (T a : tmp) {
			if (a.compareTo(this.getValue()) > 0) {
				return root.findNode(a);

			}
		}
		return null;
	}

}
