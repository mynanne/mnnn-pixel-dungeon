/*
 * Pixel Dungeon
 * Copyright (C) 2012-2015 Oleg Dolya
 *
 * Shattered Pixel Dungeon
 * Copyright (C) 2014-2026 Evan Debenham
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

package com.shatteredpixel.shatteredpixeldungeon;

import java.util.ArrayList;

import com.shatteredpixel.shatteredpixeldungeon.items.Dewdrop;
import com.shatteredpixel.shatteredpixeldungeon.items.Item;

public class Challenges {
	static abstract public class AbstractChallenge {
		private String id;
		private String name;

		abstract void apply();

		public String getId() { return id; }
		public void setId(String id) { this.id = id; }

		public String getName() { return name; }
		public void setName(String name) { this.name = name; }
		
	}
	static public final ArrayList<AbstractChallenge> challenges = new ArrayList<>();

	public static int activeChallenges(){
		return activeChallenges(Dungeon.challenges);
	}

	public static int activeChallenges(ArrayList<AbstractChallenge> values){
		return values.size();
	}

	public static boolean isItemBlocked( Item item ){

		if (Dungeon.isChallenged(findChallenge("NO_HERBALISM")) && item instanceof Dewdrop){
			return true;
		}

		return false;

	}

	//@TODO: 나중에 사라져야 할 것
	static public AbstractChallenge findChallenge( String id ) {
		for (AbstractChallenge ch : challenges) {
			if (ch.getId().equals(id)) {
				return ch;
			}
		}
		return null;
	}
}