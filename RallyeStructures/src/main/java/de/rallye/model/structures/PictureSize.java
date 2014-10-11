/*
 * Copyright (c) 2014 Jakob Wenzel, Ramon Wirsch.
 *
 * This file is part of RallySoft.
 *
 * RallyeSoft is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * RallyeSoft is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Rallyesoft.  If not, see <http://www.gnu.org/licenses/>.
 */

package de.rallye.model.structures;

public enum PictureSize {
	Thumbnail, Mini, Standard, Original, Preview;
	
	private static final int THUMB_SIZE = 96;
	private static final int MINI_SIZE = 480;
	private static final int PREVIEW_SIZE = 800;
	private static final int STD_SIZE = 1280;
	
	private static final String[] abr =  new String[]{ "thumb", "mini", "std", "org", "preview" };
	private static final Dimension[] dims = new Dimension[]{ new Dimension(THUMB_SIZE, THUMB_SIZE), new Dimension(MINI_SIZE, MINI_SIZE), new Dimension(STD_SIZE, STD_SIZE), null, new Dimension(PREVIEW_SIZE, PREVIEW_SIZE) };
	
	public static PictureSize fromString(String s) {
		for(int i=0; i<abr.length; i++) {
			if (abr[i].equalsIgnoreCase(s))
				return PictureSize.values()[i];
		}
		return null;
	}
	
	public String toShortString() {
		return abr[this.ordinal()];
	}
	
	public Dimension getDimension() {
		return dims[this.ordinal()];
	}
	
	public static class PictureSizeString {
		
		final public PictureSize size;
		
		public PictureSizeString(String s) {
			PictureSize size;
			
			try {
				size = PictureSize.valueOf(s);
			} catch (Exception e) {
				size = PictureSize.fromString(s);
			}
			
			this.size = (size == null)? PictureSize.Standard : size;
		}
	}
}
