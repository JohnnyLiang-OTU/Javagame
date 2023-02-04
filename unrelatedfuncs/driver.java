package unrelatedfuncs;
import java.util.Random;
import java.util.Arrays;
public class driver {
    public static void main(String[] args) {
        int numberArr[] = new int[50];
        for(int i = 0; i < 50; i++)
        {
            numberArr[0] = 6;
            Random rand = new Random();
            for(int j = 1; j < 49; j++)
            {
                int b = rand.nextInt(2);
                numberArr[j] = b;
            }
            numberArr[49] = 6;
            for(int k = 0; k < 50; k++)
            {
                System.out.print(numberArr[k] + " ");
            }
            System.out.print("\n");
        }




        
    }
}
