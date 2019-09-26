import java.util.HashMap;
import java.util.Scanner;
import java.util.Arrays;
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
        var coms = new HashMap<String, Consumer<String[]>>();
        coms.put("help", s -> help());
        coms.put("echo", s -> System.out.println(String.join(" ", s)));
        coms.put("exit", s -> System.exit(0));
        coms.put("authors", s -> auths());
        executor(args, coms);

        while(true)
        {
            var line = in.nextLine();
            executor(line.split(" "), coms);
        }
    }

    private static void executor(String[] args,
								 HashMap<String, Consumer<String[]>> coms)
    {
		if (args.length == 0)
			return;
		if (coms.containsKey(args[0])){
			coms.get(args[0]).accept(Arrays.copyOfRange(args, 1, args.length));
		} else {
			 System.out.println("No such comands!");
		}
	}
}
