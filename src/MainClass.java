public class MainClass {
    public static void main(String[] args) throws InterruptedException {
        String text = "Sucessfully cloned :D";
        for (int i = 0; i < text.length(); i++){
            System.out.print(text.charAt(i));
            Thread.sleep(100);
        }
    }
}