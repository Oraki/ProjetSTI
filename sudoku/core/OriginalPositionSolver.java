package tchok.sudoku.core;

/**
 * Solve a State but starting back from the original solution.
 * Returns null if the original solution is empty.
 */
public class OriginalPositionSolver extends SimpleSolver {
	@Override
	public State solve(State state_p) {
		// Build a copy
		Template template = state_p.getTemplate();
		State state = new State(template);
		
		// Fill it
		for(int index=0; index<template.maxIndex; index++) {
			// Only original positions
			if(state_p.isOriginalPosition(index)) {
				state.play(index, state_p.getValue(index));
			}
		}
		
		// And solve it
		return super.solve(state);
	}
}
