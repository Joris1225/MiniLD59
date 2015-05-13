package com.jorisvanvugt.minild59.models;

public enum Direction {
	NORTH,
	EAST,
	SOUTH,
	WEST;
	
	public int getValue() {
		return this.ordinal();
	}
}
