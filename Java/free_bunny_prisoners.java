//this is the 1st question of level4
import java.util.*;
public class Answer {

    public static int[][] answer(int num_buns, int num_required) {
        //total unique key needed is l = n!/((m-1)!(n-m+1)!)
        //for each bunny, keynumber = (n - m + 1)*l/n because
        //each key needs to repeat (n - m + 1) times at least
        int repeat = num_buns - num_required + 1;
        int totalKeyNumber = f(num_buns)/(f(repeat) * f(num_required - 1));
        int eachKeyNumber = repeat * totalKeyNumber / num_buns;
        //get the combination
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < num_buns;i++){
            list.add(new ArrayList<Integer>());
        }
        Stack<Integer> st = new Stack<>();
        Stack<Integer> st1 = new Stack<>();
        for (int i = 0; i < repeat; i++){
            st.push(i);
        }
        for (int key = 0; key < totalKeyNumber; key++){
            //put into arraylist
            while (!st.isEmpty()){
                int temp = st.pop();
                list.get(temp).add(key);
                st1.push(temp);
            }
            while (!st1.isEmpty()){
                int temp = st1.pop();
                st.push(temp);
            }
            //check if out of range
            int last = st.pop();
            if (last + 1 < num_buns){
                st.push(last + 1);
                continue;
            }
            int out = 1;
            while (last + out >= num_buns && st.size() != 0){
                last = st.pop();
                out++;
            }
            while (out != 0){
                last++;
                st.push(last);
                out--;
            }
        }
        //convert to int[]
        int[][] result = new int[num_buns][eachKeyNumber];
        for (int i = 0; i < num_buns; i++){
            for (int j = 0; j < eachKeyNumber;j++){
                result[i][j] = list.get(i).get(j);
            }
        }
        return result;
    }
    private static int f(int n){
        int i = 1;
        while (n > 1){
            i = i * n;
            n = n - 1;
        }
        return i;
    }
}
