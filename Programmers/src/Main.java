public class Main {
    public static void main(String[] args) {
        String a = "aa";
        String b = "";
        for(int i=0; i<a.length(); i++) {
            b += a.charAt(i);
        }
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
    }
}
