/*
 * Paintroid: An image manipulation application for Android.
 * Copyright (C) 2010-2015 The Catrobat Team
 * (<http://developer.catrobat.org/credits>)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.catrobat.paintroid.test.espresso.util.wrappers;

import org.catrobat.paintroid.R;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewInteraction;
import androidx.test.platform.app.InstrumentationRegistry;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public final class TopBarViewInteraction extends CustomViewInteraction {
	private TopBarViewInteraction() {
		super(onView(withId(R.id.pocketpaint_layout_top_bar)));
	}

	public static TopBarViewInteraction onTopBarView() {
		return new TopBarViewInteraction();
	}

	public ViewInteraction onUndoButton() {
		return onView(withId(R.id.pocketpaint_btn_top_undo));
	}

	public ViewInteraction onRedoButton() {
		return onView(withId(R.id.pocketpaint_btn_top_redo));
	}

	public ViewInteraction onCheckmarkButton() {
		return onView(withId(R.id.pocketpaint_btn_top_checkmark));
	}

	public ViewInteraction onPlusButton() {
		return onView(withId(R.id.pocketpaint_btn_top_plus));
	}

	public TopBarViewInteraction performUndo() {
		onUndoButton()
				.perform(click());
		return this;
	}

	public TopBarViewInteraction performRedo() {
		onRedoButton()
				.perform(click());
		return this;
	}

	public TopBarViewInteraction performClickCheckmark() {
		onCheckmarkButton()
				.perform(click());
		return this;
	}

	public TopBarViewInteraction performClickPlus() {
		onPlusButton()
				.perform(click());
		return this;
	}

	public TopBarViewInteraction performOpenMoreOptions() {
		openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getInstrumentation().getTargetContext());
		return this;
	}

	public TopBarViewInteraction onHomeClicked() {
		Espresso.pressBack();
		return this;
	}
}
