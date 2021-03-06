/*
Copyright (c) 2010 Ron Alford <ronwalf@volus.net>
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions
are met:
1. Redistributions of source code must retain the above copyright
   notice, this list of conditions and the following disclaimer.
2. Redistributions in binary form must reproduce the above copyright
   notice, this list of conditions and the following disclaimer in the
   documentation and/or other materials provided with the distribution.
3. The name of the author may not be used to endorse or promote products
   derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
package net.volus.ronwalf.phs2010.games.checkers;

import java.util.Arrays;
import java.util.Iterator;

import net.volus.ronwalf.phs2010.games.util.Pair;

public class CheckersMove implements Iterable<CheckersCompass> {

	private final boolean isJump;
	private final CheckersCompass[] directions;
	private final Pair<Integer,Integer> location;
	
	public CheckersMove(int x, int y, boolean isJump, CheckersCompass... directions) {
		this.location = new Pair<Integer,Integer>(x,y);
		this.isJump = isJump;
		this.directions = directions;
	}
	
	public CheckersMove(Pair<Integer,Integer> loc, boolean isJump, CheckersCompass... directions) {
		this(loc.x, loc.y, isJump, directions);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CheckersMove other = (CheckersMove) obj;
		if (isJump != other.isJump)
			return false;
		if (!Arrays.equals(directions, other.directions))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(directions);
		result = prime * result
				+ ((location == null) ? 0 : location.hashCode());
		return result;
	}

	public boolean isJump() { return isJump; }
	
	public Iterator<CheckersCompass> iterator() {
		return Arrays.asList(directions).iterator();
	}

	public int length() { return directions.length; }
	
	public Pair<Integer, Integer> location() { return location; }

	@Override
	public String toString() {
		return "CheckersMove [isJump=" + isJump + ", directions="
				+ Arrays.toString(directions) + ", location=" + location + "]";
	}

}
