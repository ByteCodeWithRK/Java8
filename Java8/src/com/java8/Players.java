package com.java8;

public class Players {
	
	private int number;
	private String name;
	private long runs;
	private long fours;
	private long sixes;
	private long matches;
	
	public Players() {
		super();
	}
	
	public Players(int number, String name, long runs, long fours, long sixes, long matches) {
		super();
		this.number = number;
		this.name = name;
		this.runs = runs;
		this.fours = fours;
		this.sixes = sixes;
		this.matches = matches;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getRuns() {
		return runs;
	}
	public void setRuns(long runs) {
		this.runs = runs;
	}
	public long getFours() {
		return fours;
	}
	public void setFours(long fours) {
		this.fours = fours;
	}
	public long getSixes() {
		return sixes;
	}
	public void setSixes(long sixes) {
		this.sixes = sixes;
	}
	public long getMatches() {
		return matches;
	}
	public void setMatches(long matches) {
		this.matches = matches;
	}
	@Override
	public String toString() {
		return "Players [number=" + number + ", name=" + name + ", runs=" + runs + ", fours=" + fours + ", sixes="
				+ sixes + ", matches=" + matches + "]";
	}
	
}
