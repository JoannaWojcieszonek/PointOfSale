package controller;

import java.util.concurrent.ExecutionException;

import inputDevices.Event;

public interface EventStrategy {
	public void execute(Object value) throws ExecutionException;
}
