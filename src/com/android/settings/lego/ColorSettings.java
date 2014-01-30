/*
 * Copyright (C) 2013-2014 Dokdo Project - Gwon Hyeok
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.settings.lego;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceCategory;
import android.preference.PreferenceScreen;
import android.provider.Settings;

import com.android.settings.R;
import net.margaritov.preference.colorpicker.ColorPickerPreference;
import com.android.settings.SettingsPreferenceFragment;

public class ColorSettings extends SettingsPreferenceFragment implements
        Preference.OnPreferenceChangeListener {

    private static PreferenceCategory PreviewLayout;
    private static final String STATUS_BAR_SHOW_NETWORK_STATS_COLOR = "status_bar_show_network_stats_color";
    private static final String STATUS_BAR_CLOCK_COLOR = "status_bar_clock_color";

    private ColorPickerPreference mStatusBarNetStatsColor;
    private ColorPickerPreference mStatusBarClockColor;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.colorsetting);

	 mStatusBarNetStatsColor = (ColorPickerPreference) findPreference(STATUS_BAR_SHOW_NETWORK_STATS_COLOR);
	 int Color1 = Settings.System.getInt(getActivity().getContentResolver(), Settings.System.STATUS_BAR_SHOW_NETWORK_STATS_COLOR, -1);
	 mStatusBarNetStatsColor.setNewPreviewColor(Color1);
	 mStatusBarNetStatsColor.setOnPreferenceChangeListener(this);

	mStatusBarClockColor = (ColorPickerPreference) findPreference(STATUS_BAR_CLOCK_COLOR);
	int Color = Settings.System.getInt(getActivity().getContentResolver(), Settings.System.STATUS_BAR_CLOCK_COLOR, -1);
 	mStatusBarClockColor.setNewPreviewColor(Color);
	mStatusBarClockColor.setOnPreferenceChangeListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
   public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
        boolean value;
        return super.onPreferenceTreeClick(preferenceScreen, preference);
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
	if (preference == mStatusBarNetStatsColor) {
		int color = ((Integer)newValue).intValue();
	 Settings.System.putInt(getContentResolver(), Settings.System.STATUS_BAR_SHOW_NETWORK_STATS_COLOR, color);
        } else if ( preference == mStatusBarClockColor) {
		int color1 = ((Integer)newValue).intValue();
		Settings.System.putInt(getContentResolver(),
		Settings.System.STATUS_BAR_CLOCK_COLOR, color1);
             return true;
	}
        return false;
    }


}
