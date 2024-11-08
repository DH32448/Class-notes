import java.util.Random;

public class Nes {
    public static void main(String[] args) {
        for (int i = 0; i < 1; i++) {
            Random random=new Random();
            int a=random.nextInt(38)+1;
            System.out.println(a);
        }
    }
}
