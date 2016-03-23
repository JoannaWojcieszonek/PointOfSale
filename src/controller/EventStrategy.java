package controller;

import java.util.concurrent.ExecutionException;

public interface EventStrategy {
	public void execute(Object value) throws ExecutionException;
}
