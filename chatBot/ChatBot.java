package chatBot;

import java.util.HashMap;
import java.util.Arrays;
import java.util.function.Consumer;
import java.lang.Runtime;
import java.util.Date;

public class ChatBot {
    private static Console cl = new Console();

    public static void help(){
        cl.print("Hello world!\nYou can use:");
        cl.print("    help - for printing this help");
        cl.print("    echo - for printing your input");
        cl.print("    authors - for printing our names");
        cl.print("    calc - running calculator");
        cl.print("    games - for opening game menu");
        cl.print("    date - for printing current date");
        cl.print("    run - for running following application");
        cl.print("    exit - for exit");
    }

    public static void run(String str){
        try {Runtime.getRuntime().exec(str);}
        catch (Throwable s) {cl.print(s.toString());}
    }

    public static void auths(){
        cl.print("Authors:");
        cl.print("    Papa Karlo");
        cl.print("    Buratino");
    }

    public static void main(String[] args) {
        var coms = new HashMap<String, Consumer<String[]>>();
        coms.put("help", s -> help());
        coms.put("echo", s -> cl.print(String.join(" ", s)));
        coms.put("exit", s -> System.exit(0));
        coms.put("authors", s -> auths());
        coms.put("calc", s -> (new Calc()).main());
        coms.put("games", s -> (new Games()).main());
        coms.put("run", s -> run(String.join(" ", s)));
        coms.put("date", s -> cl.print((new Date()).toString()));
        executor(args, coms);

        while(true)
        {
            var line = cl.read();
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
            cl.print("No such comands!");
		}
	}
}
