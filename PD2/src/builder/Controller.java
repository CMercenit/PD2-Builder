package builder;

public class Controller
{
	private View myView;
	
	public Controller()
	{
		myView = new View(this);
	}
	
	public static void main(String args[])
	{
		new Controller();
	}
}
