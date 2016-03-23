package inputDevices;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.concurrent.BlockingQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 * ExitButton stub class. It creates a small window and allows users to input 'exit' phrase,
 * when they want to finalize their transaction and print the receipt.
 *
 */
public class ExitButton implements InputDevice {

	private BlockingQueue<Event> queue;
	
	public ExitButton(BlockingQueue<Event> queue) {
		this.queue = queue;
		createConsole();
	}
	
	@Override
	public void sendEvent(Event event) {
		try {
			queue.put(event);
		} catch (InterruptedException e) {
			System.out.println("Sending event failed");
		}
	}
	private void createConsole()
	{
		JFrame frame = new JFrame("Exit scanner ");
		frame.setSize(300, 300); 
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(new JLabel("Write an exit phrase: "),BorderLayout.NORTH);
		
		JTextField text = new JTextField();
		text.setPreferredSize(new Dimension(100,100));
		text.setEditable(true);
		text.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER)
				{
					if(text.getText().compareTo("exit")==0)
						sendEvent(new Event(text.getText(),EventType.ExitButtonClickedEvent));
					text.setText("");
				}
			}
		});
		
		panel.add(text,BorderLayout.CENTER);
		frame.add(panel);
		frame.setVisible(true);
	}

}
