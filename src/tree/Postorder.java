package tree;

public class Postorder {
    //https://www.geeksforgeeks.org/print-postorder-from-given-inorder-and-preorder-traversals/
    // Driver code
    static int preIndex = 0;
    public static void main(String ars[]) {
        int in[] = {4, 2, 5, 1, 3, 6};
        int pre[] = {1, 2, 4, 5, 3, 6};
        int len = in.length;
        Postorder tree = new Postorder();
        tree.printPost(in, pre, 0, len - 1);
    }

    private void printPost(int[] in, int[] pre, int startIndex, int endIndex) {

        if (startIndex <= endIndex) {
            //startIndex in pre[] is root.
            int index = searchElement(in, startIndex, endIndex, pre[preIndex++]);
            //Iterate to left subtree
            printPost(in, pre, startIndex, index - 1);
            printPost(in, pre, index + 1, endIndex);
            System.out.println(in[index]);
        }

    }

    private int searchElement(int[] arr, int startIn, int endIn, int data) {
        int i = 0;
        for (i = startIn; i < endIn; i++)
            if (arr[i] == data)
                return i;
        return i;
    }
}
