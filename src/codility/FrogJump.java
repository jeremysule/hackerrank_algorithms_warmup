package codility;

/**
 * Created by jeremy on 19/08/16.
 */
public class FrogJump {
    public int solution(int X, int Y, int D) {
        int ToJump = Y - X;
        if (ToJump%D == 0){
            return ToJump / D;
        } else {
            return ToJump / D + 1;
        }
    }

    public static void main(String[] args) {
        FrogJump task = new FrogJump();
        System.out.println(task.solution(10,85,30));

    }
}
