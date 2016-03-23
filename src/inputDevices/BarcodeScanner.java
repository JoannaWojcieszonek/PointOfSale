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


public class BarcodeScanner implements InputDevice {
	
	private BlockingQueue<Event> queue;
	private void createConsole()
	{
		JFrame frame = new JFrame("BarcodeScanner");
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(new JLabel("Write the bar-code: "),BorderLayout.NORTH);
		
		JTextField text = new JTextField();
		text.setPreferredSize(new Dimension(100,100));
		text.setEditable(true);
		text.addKeyListener(new KeyAdapter() {
			@Override
			   public void keyTyped(KeyEvent e) {
				      char c = e.getKeyChar();
				      if (!((c >= '0') && (c <= '9') ||
				         (c == KeyEvent.VK_BACK_SPACE) ||
				         (c == KeyEvent.VK_DELETE))) {
				        e.consume();
				      }
				    }
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER)
				{
					if(text.getText().length()< 10)
						sendEvent(new Event(Integer.parseInt(text.getText()),EventType.ProductScannedEvent));
					text.setText("");
				}
			}
		});
		panel.add(text,BorderLayout.CENTER);
		frame.add(panel);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
	public BarcodeScanner(BlockingQueue<Event> queue)
	{
		this.queue = queue;
		createConsole();
	}
	
	public BlockingQueue<Event> getQueue() {
		return queue;
	}
	
	@Override
	public void sendEvent(Event event) {
		try {
			queue.put(event);
		} catch (InterruptedException e) {
			System.out.println("Sending event failed");
		}
	}
	/*
	@Override
	public void run() {
		
				while(true) {
					String input = JOptionPane.showInputDialog("Please input a value");
					Integer barcode = Integer.parseInt(input);
					Event event = new Event(barcode, EventType.ProductScannedEvent);
					sendEvent(event);
					}
		
	}*/
}
