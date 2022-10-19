public class Print3x3 {
    public static void main(String[] args) {

    }
    public void printer(){

        for (int a = 1; a < 4; a++) {
            for (int b = 0; b < 4; b++) {
                for (int r = 0; r < 4; r++) {
                    if (a >= b && b>=r){
                        System.out.println(a+""+b+""+r);
                    }
                }
            }
        }

    }
}
