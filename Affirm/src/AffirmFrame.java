import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

// holds an AffirmComponent & controls & a timer to drive it
public class AffirmFrame extends JFrame implements ActionListener { // Our AffirmComponent, installed in the CENTER
	private AffirmComponent myAffirmComponent;
	
	// Our many controls
	private JButton myBeep; 
	private JTextField myField; 
	private JButton myAdd; 
	private JButton myGood; 
	private JButton myRemove;
	private JButton myCenter; 
	private JButton myStart; 
	private JButton myStop; 
	private JButton mySpeed;
	
	
	// Our timer
	private javax.swing.Timer myTimer;
	
	public final String[ ] GOOD = new String[ ] { "Lookin' good","Mind the gap", "You can do it","Word!", "Yo go!"};
	
	
	public AffirmFrame( ) {
		setTitle("AffirmFrame");
		Container content = getContentPane( );
		// horizontal & vertical space between child components content.setLayout(new BorderLayout(4, 4));
		// make and install our component
		myAffirmComponent = new AffirmComponent( ); content.add(myAffirmComponent, BorderLayout.CENTER);
		// Panel for controls in south
		JPanel panel = new JPanel( );
		// the code below is a little repetitive - don't worry about it
		myBeep = new JButton("Beep"); panel.add(myBeep); myBeep.addActionListener(this);
		myField = new JTextField(20); panel.add(myField); myField.addActionListener(this);		
		myAdd = new JButton("Add Field"); panel.add(myAdd); myAdd.addActionListener(this);
		myGood = new JButton("Add Good"); panel.add(myGood); myGood.addActionListener(this);
		myRemove = new JButton("Remove"); panel.add(myRemove); myRemove.addActionListener(this);
		myCenter = new JButton("Center"); panel.add(myCenter); myCenter.addActionListener(this);
		myStart = new JButton("Start"); panel.add(myStart); myStart.addActionListener(this);
		myStop = new JButton("Stop"); panel.add(myStop); myStop.addActionListener(this);
		mySpeed = new JButton("Speed"); panel.add(mySpeed); mySpeed.addActionListener(this);
		// Create timer, 200 milliseconds
		// does nothing until start( )
		myTimer = new javax.swing.Timer(200, this);
		// Add panel
		content.add(panel, BorderLayout.SOUTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); pack( );
		setVisible(true);
	}
	
	// Sent by the various controls -- test e.getSource( ) // to see which control is talking this time
	public void actionPerformed(ActionEvent e) {
		if (e.getSource( ).equals(myBeep)) { 
			Toolkit.getDefaultToolkit( ).beep( );
		}
		else if (e.getSource( ).equals(myField)|| e.getSource( ).equals(myAdd)) { 
			myAffirmComponent.add( myField.getText( ) );
		}
		else if (e.getSource( ).equals(myGood)) {
			String s = GOOD[(int)(Math.random( )*GOOD.length)];
			myAffirmComponent.add( s ); }
		else if (e.getSource( ).equals(myRemove)) { 
			myAffirmComponent.removeRandom( );
		}
		else if (e.getSource( ).equals(myStart)) {
			myTimer.start( );
		}
	
		else if (e.getSource( ).equals(myCenter)) {
			myAffirmComponent.centerAll( );
		}
		else if (e.getSource( ).equals(myStop)) {
			myTimer.stop( );
		}
		else if (e.getSource( ).equals(myTimer)) {
			myAffirmComponent.moveAll( );
		}
		else if (e.getSource( ).equals(mySpeed)) {
			String s = myField.getText( );
			myTimer.setDelay(Integer.parseInt(s));
		}
	}

	public static void main(String[ ] args) { 
		AffirmFrame frame = new AffirmFrame( );
	}
 
}