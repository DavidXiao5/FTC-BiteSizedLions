package TeleOp;
import java.util.Random;

public class math {
    public static void main(String[] args){
        Random random = new Random();
        int total = 0;
        for (int i = 0; i < 10000000; i++){
            boolean exit = true;
            while (exit){
                float sum = 0;
                int randomnum = random.nextInt(5);
                if (randomnum >= 3){
                    sum += 1.6F;
                }
                else{
                    sum+= 1.4F;
                    total+= (int) sum;
                    exit = false;
                }
            }
        }
        System.out.println(total);
    }
}


