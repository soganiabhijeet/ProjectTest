package recursion;

import java.util.ArrayList;

//TODO this
public class AllAdjacentCombination {
    public void combination(int input[],int result[],int k,int pos,int r){
String s="";
        if(pos == input.length){
            for(int i=0; i < r ; i++){
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int i=pos; i < pos + k && i < input.length; i++ ){
            result[r] = formNumber(input,pos,i);
            combination(input,result,k,i+1,r+1);
        }
    }

    private int formNumber(int input[], int start, int end){
        int num = 0;
        for(int i=start; i <=end; i++){
            num = num*10 + input[i];
        }
        return num;
    }

    public static void main(String args[]){
        AllAdjacentCombination adc = new AllAdjacentCombination();
        int input[] = {1,2,3,4,5};
        int result[] = new int[input.length];
        adc.combination(input,result,3,0,0);
    }


}
