package chatBot;


import java.util.HashMap;
import java.util.Arrays;
import java.util.function.Consumer;


class Games
{
    private Console cl = new Console();
    private HashMap<String, Consumer<String[]>> coms = 
        new HashMap<String, Consumer<String[]>>();
    private double exit = 0;

    private void help()
    {
        cl.print("This is game menu\nYou can play:");
        cl.print("    matches - you needn`t take the last match");
        cl.print("help - for printing this help");
        cl.print("exit - for exit");
    }
    
    void Games()
    {
        coms.put("matches", s -> matches());
        coms.put("help", s -> help());
        coms.put("exit", s -> exit++);
    }
    
    public void main()
    {
        while(exit == 0)
        {
            var line = cl.read();
            executor(line.split(" "), coms);
        }
    }
    
    private void executor(String[] args,
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
    
    private void matches()
    {
        return;
    }
}
