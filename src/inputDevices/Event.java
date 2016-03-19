package inputDevices;

public class Event {
	private Object value;
	private EventType type;
	
	public Event(Object value, EventType type)
	{
		this.value = value;
		this.type = type;
	}
	
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	public EventType getType() {
		return type;
	}
	public void settype(EventType type) {
		this.type = type;
	}
}
