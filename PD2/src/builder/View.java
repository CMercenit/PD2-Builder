package builder;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Point;
import java.awt.Toolkit;
import java.lang.reflect.Method;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

public class View
{
	private int TITLE_BAR = 50;
	
	private Controller myController;
	private JFrame myFrame = new JFrame("Builder");
	private Container myContentPane;
	private SpringLayout myLayout = new SpringLayout();
	private JPanel myBackground, myWeapons, myOthers, myInfamy;//, mySkills;
	private JPanel[] mySkills = new JPanel[5];
	private JTabbedPane mySkillsPane;
	private JButton[] myButtonsOuter = new JButton[6];
	private JButton[] myButtonsInner = new JButton[12];
	
	private double screenWidth = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	private double screenHeight = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	private Dimension FRAME_SIZE = new Dimension((int)(screenWidth/1.5), (int)(screenHeight/1.5));
	private Point FRAME_POS = new Point((int)(screenWidth/5.5), (int)(screenHeight/5.5));
	
	public View(Controller controller)
	{
		/**
		 * make all dimensions + positions dynamic instead of static
		 * make positions + dimensions change when the window is resized
		 * 
		 * create array of images for each skill and assign them when the button is created
		 * create two other arrays of images in the same order as the original array with white and blue images
		 * 
		 * 
		 * Apps/games:
		 * Place the attribution on the credits/description page of the application.
		 * 
		 * 1. Lightbulb - Designed by Freepik from Flaticon
		 * 		https://www.flaticon.com/free-icon/electric-light-bulb_15595
		 * 2. Shield - Designed by Freepik from Flaticon
		 * 		https://www.flaticon.com/free-icon/shield_56755?term=shield&page=1&position=14
		 * 3. Gear - Designed by Freepik from Flaticon
		 * 		https://www.flaticon.com/free-icon/gear_40031?term=gear&page=1&position=29
		 * 4. Ghost - Designed by Freepik from Flaticon
		 * 		https://www.flaticon.com/free-icon/ghost_236468?term=ghost&page=1&position=17
		 * 5. X - Designed by Google from Flaticon
		 * 		https://www.flaticon.com/free-icon/clear-button_60994?term=letter%20x&page=1&position=18
		 * 
		 */
		myController = controller;
		
//		System.out.println("Width: " + screenWidth + "\nHeight: " + screenHeight);
//		System.out.println("Frame Width: " + FRAME_SIZE.getWidth() + "\nFrame Height: " + FRAME_SIZE.getHeight());
		
		myFrame.setSize(FRAME_SIZE);
		myFrame.setLocation(FRAME_POS);
		myFrame.setLayout(null);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		myContentPane = myFrame.getContentPane();
		myContentPane.setLayout(null);

		JTextField test2 = new JTextField();
		JTextField test3 = new JTextField();
		JTextField test4 = new JTextField();
		
		mySkillsPane = new JTabbedPane();
		mySkillsPane.setSize((int)(FRAME_SIZE.getWidth()*0.6), (int)(FRAME_SIZE.getHeight()-TITLE_BAR-FRAME_SIZE.getHeight()/10));
		mySkillsPane.setLocation(5, 5);
		mySkillsPane.setBackground(Color.CYAN);
		mySkillsPane.setUI(new BasicTabbedPaneUI()
		{
			@Override
			protected int calculateTabWidth(int tabPlacement, int tabIndex, 
					FontMetrics metrics)
			{
				return (mySkillsPane.getWidth()/5)-1;
			}
			
		});
		
//		System.out.println("Size: " + mySkills.getSize().getWidth() + ", " + mySkills.getSize().getHeight()
//				+ "\nLocation: " + mySkills.getLocation().getX() + ", " + mySkills.getLocation().getY());
		
		myOthers = new JPanel();
		myOthers.setLayout(myLayout);
		myOthers.setSize((int)(FRAME_SIZE.getWidth()*0.375), (int)(FRAME_SIZE.getHeight()/4));
		myOthers.setLocation(mySkillsPane.getWidth()+10, (int)(FRAME_SIZE.getHeight()-myOthers.getHeight()-TITLE_BAR-5));
		myOthers.setBackground(Color.GREEN);
		test2.setText("Size: " + myOthers.getSize().getWidth() + ", " + myOthers.getSize().getHeight()
				+ "\nLocation: " + myOthers.getLocation().getX() + ", " + myOthers.getLocation().getY());
		myOthers.add(test2);
		
		myWeapons = new JPanel();
		myWeapons.setLayout(myLayout);
		myWeapons.setSize((int)(FRAME_SIZE.getWidth()*0.375), (int)(FRAME_SIZE.getHeight()-myOthers.getHeight()-TITLE_BAR-15));
		myWeapons.setLocation(mySkillsPane.getWidth()+mySkillsPane.getY()+5, 5);
		myWeapons.setBackground(Color.MAGENTA);
		test3.setText("Size: " + myWeapons.getSize().getWidth() + ", " + myWeapons.getSize().getHeight()
				+ "\nLocation: " + myWeapons.getLocation().getX() + ", " + myWeapons.getLocation().getY());
		myWeapons.add(test3);
		
		myInfamy = new JPanel();
		myInfamy.setLayout(new SpringLayout());
		myInfamy.setSize(mySkillsPane.getWidth(), (int)(FRAME_SIZE.getHeight()-TITLE_BAR-mySkillsPane.getHeight()-15));
		myInfamy.setLocation(5, mySkillsPane.getHeight()+mySkillsPane.getY()+5);
		myInfamy.setBackground(Color.YELLOW);
		test4.setText("Size: " + myInfamy.getSize().getWidth() + ", " + myInfamy.getSize().getHeight()
				+ "\nLocation: " + myInfamy.getLocation().getX() + ", " + myInfamy.getLocation().getY());
		myInfamy.add(test4);
		
		for(int j = 0; j < mySkills.length; j++)
		{
			mySkills[j] = new JPanel(null);
			mySkills[j].setSize((int)(FRAME_SIZE.getWidth()*0.6), (int)(FRAME_SIZE.getHeight()-TITLE_BAR-FRAME_SIZE.getHeight()/10));
			mySkills[j].setLocation(5, 5);
			mySkills[j].setBackground(Color.CYAN);
			
			for(int i = 0; i < myButtonsOuter.length; i++)
			{
				myButtonsOuter[i] = new JButton("" + i*(j+1));
				myButtonsOuter[i].setLayout(null);
				myButtonsOuter[i].setSize(50, 50);
				if(i < 3)
				{
					/**
					 * Change 40 here and in else below to tab width
					 */
//					myButtonsOuter[i].setLocation((int)(mySkillsPane.getWidth()/3)*i+100, (int)((mySkillsPane.getHeight()/12)+40));
					myButtonsOuter[i].setLocation((int)(mySkillsPane.getWidth()/3)*i+100, (int)((mySkillsPane.getHeight()/12)));
//					myButtonsOuter[i].setLocation((int)(mySkillsPane.getWidth()/3)*i+100, mySkillsPane.getY()+75);
				}
				else
				{
//					myButtonsOuter[i].setLocation((int)(mySkillsPane.getWidth()/3)*(i-3)+100, (int)((mySkillsPane.getHeight()*0.75)+40));
					myButtonsOuter[i].setLocation((int)(mySkillsPane.getWidth()/3)*(i-3)+100, (int)((mySkillsPane.getHeight()*0.75)));
//					myButtonsOuter[i].setLocation((int)(mySkillsPane.getWidth()/3)*(i-3)+100, mySkillsPane.getHeight()-myButtonsOuter[i].getHeight()-125);
				}
				
//				System.out.println("Added button " + i + " at: " + myButtonsOuter[i].getLocation().getX() + ", " + myButtonsOuter[i].getLocation().getY());
				mySkills[j].add(myButtonsOuter[i]);
			}
	
			for(int i = 0; i < myButtonsInner.length; i++)
			{
				myButtonsInner[i] = new JButton("" + ((i+6)*(j+1)));
				myButtonsInner[i].setLayout(null);
				myButtonsInner[i].setSize(50, 50);
				
				switch(i)
				{
					case 0:
						myButtonsInner[i].setLocation(myButtonsOuter[0].getX()
								-myButtonsInner[i].getWidth()-15, (int)((
								(myButtonsOuter[3].getY()-myButtonsOuter[0].getY())
								/3)-myButtonsInner[i].getHeight()+myButtonsOuter[0].getY()
								+myButtonsOuter[0].getHeight()));
						break;
					case 1:
						myButtonsInner[i].setLocation(myButtonsOuter[0].getX()
								+myButtonsOuter[0].getWidth()+15, (int)((
								(myButtonsOuter[3].getY()-myButtonsOuter[0].getY())
								/3)-myButtonsInner[i].getHeight()+myButtonsOuter[0].getY()
								+myButtonsOuter[0].getHeight()));
						break;
					case 2:
						myButtonsInner[i].setLocation(myButtonsOuter[0].getX()
								-myButtonsInner[i].getWidth()-15, (int)(((
								(myButtonsOuter[3].getY()-myButtonsOuter[0].getY())
								*2)/3)+myButtonsOuter[0].getY()));
						break;
					case 3:
						myButtonsInner[i].setLocation(myButtonsOuter[0].getX()
								+myButtonsOuter[0].getWidth()+15, (int)(((
								(myButtonsOuter[3].getY()-myButtonsOuter[0].getY())
								*2)/3)+myButtonsOuter[0].getY()));
						break;
					case 4:
						myButtonsInner[i].setLocation(myButtonsOuter[1].getX()
								-myButtonsInner[i].getWidth()-15, (int)((
								(myButtonsOuter[4].getY()-myButtonsOuter[1].getY())
								/3)-myButtonsInner[i].getHeight()+myButtonsOuter[1].getY()
								+myButtonsOuter[1].getHeight()));
						break;
					case 5:
						myButtonsInner[i].setLocation(myButtonsOuter[1].getX()
								+myButtonsOuter[1].getWidth()+15, (int)((
								(myButtonsOuter[4].getY()-myButtonsOuter[1].getY())
								/3)-myButtonsInner[i].getHeight()+myButtonsOuter[1].getY()
								+myButtonsOuter[1].getHeight()));
						break;
					case 6:
						myButtonsInner[i].setLocation(myButtonsOuter[1].getX()
								-myButtonsInner[i].getWidth()-15, (int)(((
								(myButtonsOuter[4].getY()-myButtonsOuter[1].getY())
								*2)/3)+myButtonsOuter[1].getY()));
						break;
					case 7:
						myButtonsInner[i].setLocation(myButtonsOuter[1].getX()
								+myButtonsOuter[1].getWidth()+15, (int)(((
								(myButtonsOuter[4].getY()-myButtonsOuter[1].getY())
								*2)/3)+myButtonsOuter[1].getY()));
						break;
					case 8:
						myButtonsInner[i].setLocation(myButtonsOuter[2].getX()
								-myButtonsInner[i].getWidth()-15, (int)((
								(myButtonsOuter[5].getY()-myButtonsOuter[2].getY())
								/3)-myButtonsInner[i].getHeight()+myButtonsOuter[2].getY()
								+myButtonsOuter[2].getHeight()));
						break;
					case 9:
						myButtonsInner[i].setLocation(myButtonsOuter[2].getX()
								+myButtonsOuter[2].getWidth()+15, (int)((
								(myButtonsOuter[5].getY()-myButtonsOuter[2].getY())
								/3)-myButtonsInner[i].getHeight()+myButtonsOuter[2].getY()
								+myButtonsOuter[2].getHeight()));
						break;
					case 10:
						myButtonsInner[i].setLocation(myButtonsOuter[2].getX()
								-myButtonsInner[i].getWidth()-15, (int)(((
								(myButtonsOuter[5].getY()-myButtonsOuter[2].getY())
								*2)/3)+myButtonsOuter[2].getY()));
						break;
					case 11:
						myButtonsInner[i].setLocation(myButtonsOuter[2].getX()
								+myButtonsOuter[2].getWidth()+15, (int)(((
								(myButtonsOuter[5].getY()-myButtonsOuter[2].getY())
								*2)/3)+myButtonsOuter[2].getY()));
						break;
				}
				
	//			System.out.println("Added button " + (i+6) + " at: " + myButtonsInner[i].getLocation().getX() + ", " + myButtonsInner[i].getLocation().getY());
				mySkills[j].add(myButtonsInner[i]);
			}
		}
		mySkillsPane.addTab("Mastermind", new ImageIcon("images/lightbulb.png"), mySkills[0], "Mastermind Skill Tree");
		mySkillsPane.addTab("Enforcer", new ImageIcon("images/shield.png"), mySkills[1], "Enforcer Skill Tree");
		mySkillsPane.addTab("Technician", new ImageIcon("images/gear.png"), mySkills[2], "Technician Skill Tree");
		mySkillsPane.addTab("Ghost", new ImageIcon("images/ghost.png"), mySkills[3], "Ghost Skill Tree");
		mySkillsPane.addTab("Fugitive", new ImageIcon("images/x.png"), mySkills[4], "Fugitive Skill Tree");
		
		System.out.println("Top gap: " + (myButtonsOuter[0].getY() - mySkillsPane.getY()));
		System.out.println("Bot gap: " + (mySkillsPane.getHeight() - (myButtonsOuter[3].getY() + myButtonsOuter[3].getHeight())));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		this.associateListeners(myController);
		
//		myContentPane.add(mySkills);
		myContentPane.add(mySkillsPane);
		myContentPane.add(myWeapons);
		myContentPane.add(myOthers);
		myContentPane.add(myInfamy);
		
		myBackground = new JPanel();
		myBackground.setSize(FRAME_SIZE);
		myBackground.setLocation(0, 0);
		myBackground.setBackground(Color.BLACK);
		myContentPane.add(myBackground);
		
		myFrame.setVisible(true);
	}
	
	private void associateListeners(Controller controller)
	{
		Class<? extends Controller> controllerClass;
		Method generateMethod, encryptMethod, decryptMethod;
		
		controllerClass = myController.getClass();
	}
}
