package project4;



import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;

public class Project4 extends JFrame implements ActionListener {

private static int xpos=0,ypos=0;// place window at this position
private static int xsize=700,ysize=500;// set window to this size

// Private state variables.

private JPanel northPanel,centerPanel;
private JButton pushButton,popButton,dumpButton,exitButton,arrayButton,linkButton,stackButton;
private JTextField colorField;
private JTextField codeField;
private JTextArea outputArea;

private boolean hasKeyboard = false;
private MyStack<Room> stack;
private Room current;
private String[] colors = {"green","blue","pink","brown","yellow","red","gold"};

////////////MAIN////////////////////////

public static void main(String[] args) {
        Project4 tpo = new Project4();
}

////////////CONSTRUCTOR/////////////////////

public Project4 ()
{

    current = new Room("green");
//    addInitialComponets();
       addInitialComponets();   // put the stuff on the screen

       // Exit when the window is closed. i.e. when top right X box pressed
       addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

       setSize(xsize,ysize);
       setLocation(xpos,ypos);
       setVisible(true);

}


public void addInitialComponets(){
    northPanel = new JPanel();
    
    arrayButton = new JButton("Array");
    northPanel.add(arrayButton);
    arrayButton.addActionListener(this);
    
    linkButton = new JButton("Link");
    northPanel.add(linkButton);
    linkButton.addActionListener(this);
    
    stackButton = new JButton("Stack");
    northPanel.add(stackButton);
    stackButton.addActionListener(this);
    


       exitButton = new JButton("Exit");
       northPanel.add(exitButton);
       exitButton.addActionListener(this);

       getContentPane().add("North",northPanel);

       centerPanel = new JPanel();
       outputArea = new JTextArea("Who Dares Enter.... The Temple of Gloom!",20,60);
       centerPanel.add(outputArea);
       getContentPane().add(centerPanel,"Center");
    
}

public void addScreenComponents()  {
    northPanel.remove(arrayButton);
    northPanel.remove(linkButton);
    northPanel.remove(stackButton);
    
    
    
    
    
       northPanel = new JPanel();
       northPanel.add(new JLabel("Enter A Color: "));
       colorField = new JTextField("",15);
       northPanel.add(colorField);
       northPanel.add(new JLabel("And A Code: "));
       codeField = new JTextField("",5);
       northPanel.add(codeField);

       pushButton = new JButton("Push");
       northPanel.add(pushButton);
       pushButton.addActionListener(this);


       popButton = new JButton("Pop");
       northPanel.add(popButton);
       popButton.addActionListener(this);


       dumpButton = new JButton("Dump");
       northPanel.add(dumpButton);
       dumpButton.addActionListener(this);


       exitButton = new JButton("Exit");
       northPanel.add(exitButton);
       exitButton.addActionListener(this);

       getContentPane().add("North",northPanel);

       centerPanel = new JPanel();
       outputArea = new JTextArea("Who Dares Enter.... The Temple of Gloom!",20,60);
       centerPanel.add(outputArea);
       getContentPane().add(centerPanel,"Center");

}
////////////BUTTON CLICKS ///////////////////////////

public void actionPerformed(ActionEvent e) {
    
    
        if(e.getSource() == arrayButton){
            stack = new ArrayStack();
            addScreenComponents();
        }
        
        if(e.getSource() == linkButton){
//            stack = new LinkStack();
//            addScreenComponents();
            northPanel.remove(stackButton);
        }
        
        if(e.getSource() == stackButton){
            stack = new JavaStack();
            addScreenComponents();
        }
    
    

         if (e.getSource()== exitButton) {
            dispose(); System.exit(0);
         }





	if (e.getSource()== pushButton) {
                String newcolor = colorField.getText();
		int code = Integer.parseInt(codeField.getText());
                outputArea.setText("Push entering " + newcolor);
                 // add code to push color/code ON the stack and change to that color room
		

		//Checks if the color entered is valid.
		if(!(Arrays.asList(colors).contains(newcolor.toLowerCase()))){
			outputArea.setText("Not a valid color.");
			return;
			
		}




		if(newcolor.equals("green") && (current.getColor().equals("blue") || current.getColor().equals("pink") || current.getColor().equals("brown"))){
			Room greenRoom = new Room("green");
			current.setCode(code);
			stack.push(current);
			current = greenRoom;
			outputArea.setText("You are in the green room.\nAdjacent rooms are blue pink and brown.");
		}


		if(newcolor.equals("blue") && (current.getColor().equals("pink") || current.getColor().equals("green") || current.getColor().equals("yellow"))){
			Room blueRoom = new Room("blue");
			current.setCode(code);
			stack.push(current);
			current = blueRoom;
			outputArea.setText("You are in the blue room.\nAdjacent rooms are green pink and yellow.");
		}


		if(newcolor.equals("brown") && (current.getColor().equals("pink") || current.getColor().equals("green") || current.getColor().equals("red"))){
			Room brownRoom = new Room("brown");
			current.setCode(code);
			stack.push(current);
			current = brownRoom;
			outputArea.setText("You are in the brown room.\nAdjacent rooms are green pink and red.");
		}


		if(newcolor.equals("pink") && (current.getColor().equals("blue") || current.getColor().equals("green") || current.getColor().equals("brown"))){
			Room pinkRoom = new Room("pink");
			current.setCode(code);
			stack.push(current);
			current = pinkRoom;
			outputArea.setText("You are in the pink room.\nAdjacent rooms are green pink and red.");
		}
                
                
                if(newcolor.equals("yellow") && (current.getColor().equals("blue") || current.getColor().equals("red") || current.getColor().equals("gold"))){
			Room pinkRoom = new Room("yellow");
			current.setCode(code);
			stack.push(current);
			current = pinkRoom;
			outputArea.setText("You are in the yellow room.\nAdjacent rooms are blue red and gold.");
		}
                
                
                if(newcolor.equals("red") && (current.getColor().equals("yellow") || current.getColor().equals("brown"))){
			Room pinkRoom = new Room("red");
			current.setCode(code);
			stack.push(current);
			current = pinkRoom;
			outputArea.setText("You are in the red room.\nAdjacent rooms are brown and yellow.");
		}
                
                
                if(newcolor.equals("gold") && current.getColor().equals("yellow")){
			Room pinkRoom = new Room("gold");
			current.setCode(code);
			stack.push(current);
			current = pinkRoom;
			outputArea.setText("You are in the pink room.\nAdjacent rooms are green pink and red.");
		}










         }






         if (e.getSource()== popButton) {
                String newcolor = colorField.getText();
                outputArea.setText("Pop returning to " + newcolor);
                // add code to pop color off the stack, check that the color/code matches and change to that color room
		
		













         }

         

         if (e.getSource()== dumpButton) {
                System.out.println("Stack Contents Dump: ");
                 // add code to print contents of Stack to the CONSOLE









         }

}

}     // End Of Project4