package com.bytecodewithrk;

import java.util.ArrayList;
import java.util.List;

public class DataSource {

	public  static List<Players> getData() {
		
		List<Players> players = new ArrayList<>();
		//number,	name,	runs,	fours,	sixes,	matches
		players.add(new Players(7, "MS Dhoni", 10773, 826, 229, 120));
		//players.add(new Players(7, "MS Dhoni", 10773, 826, 229, 120));
		players.add(new Players(18, "Virat Kohli", 13848, 1294, 151, 292));
		players.add(new Players(45, "Rohit Sharma", 10709, 994, 323, 262));
		players.add(new Players(63, "Surya Kumar Yadav", 773, 80, 19, 37));
		players.add(new Players(77, "Shubman Gill", 2271, 254, 52, 44));
		players.add(new Players(1, "KL Rahul", 2820, 224,	61, 75));
		players.add(new Players(41, "Shreyas Iyer", 2383, 219,	62, 59));
		players.add(new Players(21, "Dinesh Karthik", 1752, 176, 15, 94));
		players.add(new Players(8, "Ravindra Jadeja", 2756, 199, 54, 197));
		players.add(new Players(93, "Jasprit Bumra", 3509, 10, 1, 89));
		players.add(new Players(15, "Bhuvaneswar Kumar", 4951, 4,1, 121));
		players.add(new Players(11, "Mohammed Shami", 4618, 17, 9, 101));
		players.add(new Players(33, "Hardik Pandya", 1769, 132, 67, 86));

		return players;

	}

}
