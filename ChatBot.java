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

    public static void echo(){
        System.out.println("Hello world!\nYou can use:");
    }

    public static void main(String[] args) {
        var in = new Scanner(System.in);
        var dictionary = new HashMap<String, Consumer<String>>();
        dictionary.put("help", s -> help());
        dictionary.put("echo", s -> System.out.println(s));
        if (args.length == 1 && dictionary.containsKey(args[0])){
            if (args.length > 1){
                dictionary.get(n).accept(args[1]);
            } else {
                dictionary.get(n).accept("");
            }
        }
        while(true){
            var n = in.nextLine();
            if (dictionary.containsKey(n)){
                dictionary.get(n).accept("");
            }
        }
        //in.close();
    }

}
