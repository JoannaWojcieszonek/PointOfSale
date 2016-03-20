package controller;

import inputDevices.Event;

public interface EventStrategy {
	public void execute(Event event);
}
