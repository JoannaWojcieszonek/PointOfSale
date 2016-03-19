package inputDevices;

public interface InputDevice extends Runnable {
	public void sendEvent(Event event);
}
