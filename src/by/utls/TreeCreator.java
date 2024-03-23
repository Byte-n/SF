package by.utls;

import java.util.List;

/**
 * �����������Ĺ���
 */
public class TreeCreator<D> {

    public static void main(String[] args) {
        TreeCreator<Integer> creator = TreeCreator
                // �����ڵ�
                .create(5)
                // ��ڵ�
                .leftSon(2,
                        // �ӽڵ�
                        creator1 -> creator1.left(1).right(3)
                )
                // �����������ҽ�㣬�������ҽ��
                .rightSon(9)
                // ���9������7�������ؽ��7
                .leftSon(7)
                // ���7���ӽڵ�
                .left(6).right(8)
                // �ӽ��7���ص����9
                .back()
                // ���ý��9���ҽ��10
                .right(10);
// �������������ظ����
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
        // ��ȡ����Ĵ�����
        TreeCreator<D> treeCreator = this.rootCreator == null ? this : this.rootCreator;
        // ���������
        T root = createNode.create(treeCreator.rootData);
        build(createNode, treeCreator, root);
        return root;
    }

    private static <T extends TreeNode, D> void build(CreateNode<T, D> createNode, TreeCreator<D> creator, TreeNode current) {
        // ��
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
     * ���������������ص�ǰ�����
     *
     * @return ��ǰ�����
     */
    public TreeCreator<D> right(D right) {
        rightSon(right);
        return this;
    }

    /**
     * ����������������������
     *
     * @return ������
     */
    public TreeCreator<D> rightSon(D right) {
        TreeCreator<D> creator = createSon();
        creator.rootData = right;
        this.right = creator;
        return creator;
    }


    /**
     * ���������������ص�ǰ��
     *
     * @return ��ǰ��
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
     * ������һ��
     */
    public TreeCreator<D> back() {
        return this.parentCreator == null ? this : this.parentCreator;
    }

    /**
     * ���� �� ���d,���û��ƥ��Ľ��,��һֱ�˵����ڵ�
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
        // �ӽڵ�Ϊ�ա�
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

