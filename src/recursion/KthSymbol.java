package recursion;

public class KthSymbol {

    int findprev(int N, int K){
        if(N==2){
            if(K==1){

                return 0;
            }else{

                return 1;
            }
        }
        int prev=findprev(N-1,(K+1)/2);
        if(prev==0){
            if(K%2==0){
                return 1;
            }else{
                return 0;
            }
        }else{
            if(K%2==1){
                return 1;
            }else{
                return 0;
            }
        }

    }


    public static void main(String[] args) {
        KthSymbol kthSymbol=new KthSymbol();
        kthSymbol.findprev(1,1);
    }
}
