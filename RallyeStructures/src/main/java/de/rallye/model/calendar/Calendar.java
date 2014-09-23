/*
 * Copyright (c) 2014 Jakob Wenzel, Ramon Wirsch.
 *
 * This file is part of RallyeSoft.
 *
 * RallyeSoft is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Foobar is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with RallyeSoft. If not, see <http://www.gnu.org/licenses/>.
 */

package de.rallye.model.calendar;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import de.rallye.model.structures.Location;

/**
 * Created by Ramon on 17.09.2014.
 */
public class Calendar implements ICalendar {

	private final List<Day> days;
	private final Long startDay;

	@JsonCreator
	public Calendar(@JsonProperty("days") List<Day> days, Long startDay) {
		this.days = days;
		this.startDay = startDay;
	}

	@Override
	public IDay getDay(int i) {
		return days.get(i);
	}

	@JsonIgnore
	@Override
	public int getDayCount() {
		return days.size();
	}

	@Override
	public Long getStartDay() {
		return startDay;
	}

	public static class Day implements IDay {

		private final int dayOfWeek;
		private final List<IEvent> events;

		@JsonCreator
		public Day(@JsonProperty("dayOfWeek") int dayOfWeek, @JsonProperty("events") List<IEvent> events) {
			this.dayOfWeek = dayOfWeek;
			this.events = events;
		}

		@Override
		public int getDayOfWeek() {
			return dayOfWeek;
		}

		@Override
		public List<IEvent> getEvents() {
			return Collections.unmodifiableList(events);
		}
	}

	public static abstract class AbstractEvent implements IEvent {

		private final int startTime;
		private final int endTime;
		private final String name;
		private final String description;
		private final int color;

		public AbstractEvent(int startTime, int endTime, String name, String description, int color) {
			this.startTime = startTime;
			this.endTime = endTime;
			this.name = name;
			this.description = description;
			this.color = color;
		}

		@Override
		public String getName() {
			return name;
		}

		@Override
		public String getDescription() {
			return description;
		}

		@Override
		public int getColor() {
			return color;
		}

		@Override
		public int getStartTime() {
			return startTime;
		}

		@Override
		public int getEndTime() {
			return endTime;
		}
	}

	public static class Event extends AbstractEvent {

		private final Location location;

		@JsonCreator
		public Event(int startTime, int endTime, String name, String description, int color, Location location) {
			super(startTime, endTime, name, description, color);

			this.location = location;
		}

		@Override
		public Location getLocation(Integer group) {
			return location;
		}

		@Override
		public boolean isAvailableFor(Integer group) {
			return true;
		}

		@Override
		public boolean isGroupSpecific() {
			return false;
		}
	}

	public static class GroupSpecificEvent extends AbstractEvent {

		private final Map<Integer, Location> locations;

		@JsonCreator
		public GroupSpecificEvent(int startTime, int endTime, String name, String description, int color, Map<Integer, Location> locations) {
			super(startTime, endTime, name, description, color);

			this.locations = locations;
		}

		@Override
		public Location getLocation(Integer group) {
			return locations.get(group);
		}

		@Override
		public boolean isAvailableFor(Integer group) {
			return locations.containsKey(group);
		}

		@Override
		public boolean isGroupSpecific() {
			return true;
		}
	}
}
