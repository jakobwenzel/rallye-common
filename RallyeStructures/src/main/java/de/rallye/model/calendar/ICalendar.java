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

package de.rallye.model.calendar;

import de.rallye.model.structures.Location;

import java.util.List;

/**
 * Created by Ramon on 17.09.2014.
 */
public interface ICalendar {
	IDay getDay(int i);
	int getDayCount();

	Long getStartDay();

	interface IDay {
		int getDayOfWeek();
		List<IEvent> getEvents();
	}

	interface IEvent {
		int getStartTime();
		int getEndTime();
		String getName();
		String getDescription();
		Location getLocation(Integer group);
		boolean isAvailableFor(Integer group);
		int getColor();

		boolean isGroupSpecific();
	}
}
