package com.shatteredpixel.shatteredpixeldungeon;

import java.util.Collections;

class Registry {
	public static void registerAll() {
		registerChallenges();
	}

	static private void registerChallenges() {
		Collections.addAll(Challenges.challenges,
			new NO_FOOD(),
			new NO_ARMOR(),
			new NO_HEALING(),
			new NO_HERBALISM(),
			new SWARM_INTELLIGENCE(),
			new DARKNESS(),
			new NO_SCROLLS(),
			new CHAMPION_ENEMIES(),
			new STRONGER_BOSSES()
		);
	}
}