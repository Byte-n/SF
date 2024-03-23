package by.utls;

import java.util.List;

/**
 * 创建二叉树的工具
 */
public class TreeCreator<D> {

    public static void main(String[] args) {
        TreeCreator<Integer> creator = TreeCreator
                // 根几节点
                .create(5)
                // 左节点
                .leftSon(2,
                        // 子节点
                        creator1 -> creator1.left(1).right(3)
                )
                // 创建根结点的右结点，并返回右结点
                .rightSon(9)
                // 结点9的左结点7，并返回结点7
                .leftSon(7)
                // 结点7的子节点
                .left(6).right(8)
                // 从结点7返回到结点9
                .back()
                // 设置结点9的右结点10
                .right(10);
// 生成树，并返回根结点
        TreeNode treeNode = creator.build(TreeNode::new);
        System.out.println(treeNode);
    }

    private TreeCreator<D> left;
    private TreeCreator<D> right;
    private TreeCreator<D> rootCreator = null;
    private TreeCreator<D> parentCreator = null;
    private D rootData = null;

    TreeCreator() {

    }


    public static <T> TreeCreator<T> create(T rootData) {
        TreeCreator<T> c = new TreeCreator<>();
        c.rootData = rootData;
        return c;
    }

    public <T extends TreeNode> T build(CreateNode<T, D> createNode) {
        // 获取最初的创建者
        TreeCreator<D> treeCreator = this.rootCreator == null ? this : this.rootCreator;
        // 创建根结点
        T root = createNode.create(treeCreator.rootData);
        build(createNode, treeCreator, root);
        return root;
    }

    private static <T extends TreeNode, D> void build(CreateNode<T, D> createNode, TreeCreator<D> creator, TreeNode current) {
        // 左
        if (creator.left != null) {
            current.left = createNode.create(creator.left.rootData);
            build(createNode, creator.left, current.left);
        }
        if (creator.right != null) {
            current.right = createNode.create(creator.right.rootData);
            build(createNode, creator.right, current.right);
        }
    }

    public TreeCreator<D> left(D left) {
        leftSon(left);
        return this;
    }

    public TreeCreator<D> leftSon(D left) {
        TreeCreator<D> creator = createSon();
        creator.rootData = left;
        this.left = creator;
        return creator;
    }


    /**
     * 设置右子树，返回当前树结点
     *
     * @return 当前树结点
     */
    public TreeCreator<D> right(D right) {
        rightSon(right);
        return this;
    }

    /**
     * 设置右子树，返回右子树
     *
     * @return 右子树
     */
    public TreeCreator<D> rightSon(D right) {
        TreeCreator<D> creator = createSon();
        creator.rootData = right;
        this.right = creator;
        return creator;
    }


    /**
     * 设置右子树，返回当前树
     *
     * @return 当前树
     */
    public TreeCreator<D> rightSon(D right, CreateSon<D> son) {
        TreeCreator<D> rCreator = rightSon(right);
        son.create(rCreator);
        return this;
    }

    public TreeCreator<D> leftSon(D left, CreateSon<D> son) {
        TreeCreator<D> rCreator = leftSon(left);
        son.create(rCreator);
        return this;
    }

    /**
     * 返回上一层
     */
    public TreeCreator<D> back() {
        return this.parentCreator == null ? this : this.parentCreator;
    }

    /**
     * 返回 到 结点d,如果没有匹配的结点,则一直退到根节点
     */
    public TreeCreator<D> backTo(D d) {
        if (this.parentCreator == null) {
            return this;
        }
        TreeCreator<D> c = this.parentCreator;
        while (d != c.rootData) {
            if (c.parentCreator == null) {
                return c;
            }
            c = c.parentCreator;
        }

        return c;
    }

    TreeCreator<D> createSon() {
        TreeCreator<D> creator = new TreeCreator<>();
        // 子节点为空。
        if (this.rootCreator == null) {
            this.rootCreator = this;
        } else {
            creator.rootCreator = this.rootCreator;
        }
        creator.parentCreator = this;
        return creator;
    }

    public interface CreateSon<D> {
        void create(TreeCreator<D> creator);
    }

    public interface CreateNode<T extends TreeNode, D> {
        T create(D d);
    }

}

