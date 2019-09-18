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
    
    public static void auths(){
        System.out.println("Authors:");
        System.out.println("    Papa Karlo");
        System.out.println("    Buratino");
    }

    public static void echo(){
        System.out.println("Hello world!\nYou can use:");
    }

    public static void main(String[] args) {
        var in = new Scanner(System.in);
        var coms = new HashMap<String, Consumer<String>>();
        coms.put("help", s -> help());
        coms.put("echo", s -> System.out.println(s));
        coms.put("exit", s -> System.exit(0));
        coms.put("authors", s -> auths());

        if (args.length > 0 && coms.containsKey(args[0])){
            if (args.length > 1){
                coms.get(args[0]).accept(args[1]);
            } else {
                coms.get(args[0]).accept("");
            }
            System.exit(0);
        } else if (args.length != 0) {
            System.out.println("No such comands!");
            System.exit(0);
        }

        while(true){
            var n = in.nextLine();
            if (coms.containsKey(n)){
                coms.get(n).accept("");
            } else {
                 System.out.println("No such comands!");
            }
        }
    }
}
