package tree;

import java.util.HashMap;

class GfG
{
    HashMap<Integer,NodeSimple> map=new HashMap();
    NodeSimple root=null;
    public NodeSimple createTree(int parent[], int N)
    {
        for(int i=0;i<N;i++){
            createNode(parent, i);
        }
        return root;
    }
    private NodeSimple createNode(int parent[],int i){
        if(!map.containsKey(i)){
            NodeSimple node=new NodeSimple(i);
            int parentIndex=parent[i];
            if(parentIndex==-1){
                map.put(i, node);
                root=node;
                return node;
            }
            //Check if parent exists

            if(!map.containsKey(parentIndex)){
                //Create parent
                createNode(parent, parentIndex);
            }
            NodeSimple parentNode=map.get(parentIndex);

            if(parentNode.left==null){
                parentNode.left=node;
            }
            if(parentNode.right==null){
                parentNode.right=node;
            }
            map.put(i, node);
        }
        return map.get(i);
    }



}
