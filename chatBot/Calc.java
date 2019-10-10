package chatBot;


import java.lang.Math;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.function.Function;

class Calc
{
    private Console cl = new Console();
    private double saved_var = 0;
    private HashMap<String, Function<Double[], Double>> coms = 
        new HashMap<String, Function<Double[], Double>>();
    private double exit = 0;

	public Calc()
	{
        coms.put("save", num -> saved_var = num[0]);
        coms.put("load", num -> num[0]);
        coms.put("exit", num -> exit++);
        coms.put("help", num -> help());
        coms.put("ln", num -> Math.log(num[0]));
        coms.put("sin", num -> Math.sin(num[0]));
        coms.put("cos", num -> Math.cos(num[0]));
        coms.put("tg", num -> Math.tan(num[0]));
        coms.put("+", num -> num[0] + num[1]);
        coms.put("-", num -> num[0] - num[1]);
        coms.put("*", num -> num[0] * num[1]);
        coms.put("/", num -> num[0] / num[1]);
        coms.put("^", num -> Math.pow(num[0], num[1]));
        coms.put("e", num -> Math.E);
        coms.put("pi", num -> Math.PI);
	}
    
    public void main()
    {
        while(exit == 0)
        {
            var data = parse(cl.read());
            exec(data[0], new Double[]{0.0,1.0});
        }
    }
    
    public double help()
    {
        cl.print("This is a calculator!\nYou can use:");
        cl.print("    help - for printing this help");
        cl.print("    funcs - for printing info about functions");
        return 0;
    }
    
    private String[] parse(String expr)
    {
        return new String[]{expr, ""};
    }
    
    private double exec(String action, Double[] vars)
    {
		if (coms.containsKey(action))
			return coms.get(action).apply(vars);
        cl.print("No such comands!");
        return 0;
	}
}
