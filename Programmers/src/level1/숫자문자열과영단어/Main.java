package level1.숫자문자열과영단어;

public class Main {
    public static void main(String[] args) {
        int answer = 0;
        String s = "one4seveneight";

        String alphabets[] = {"zero","one","two","three","four","five","six","seven","eight","nine"};

        for(int i=0; i<10; i++) {
            s = s.replaceAll(alphabets[i],String.valueOf(i));
        }
        answer = Integer.parseInt(s);
        System.out.println(answer);
    }
}
