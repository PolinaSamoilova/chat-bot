package chatBot;


import java.util.Scanner;


class Console
{
    private Scanner in = new Scanner(System.in);

    public String read()
    {
        return in.nextLine();
    }

    public void print(String text)
    {
        System.out.println(text);
    }
}
