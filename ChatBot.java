import java.util.HashMap;
import java.util.Scanner;
import java.util.function.Consumer;


public class ChatBot {
    public static void help(){
        System.out.println("Hello world!\nYou can use:");
        System.out.println("    help - for printing this help");
        System.out.println("    echo - for printing your input");
        System.out.println("    authors - for printing our names");
    }

    public static void main(String[] args) {
        var in = new Scanner(System.in);
        var dictionary = new HashMap<String, Consumer<String>>();
        dictionary.put("help", s -> help());
        while(true){
            var n = in.nextLine();
            if (dictionary.containsKey(n)){
                dictionary.get(n).accept("");
            }
        }
        //in.close();
    }

}
