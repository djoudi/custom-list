package com.cobyplain.customlist.model;

/*
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 * 
 * @author Coby Plain coby.plain@gmail.com
 */

import android.graphics.Color;

import com.cobyplain.customlist.R;

public class Item {

	private String main;
	private String secondary;
	private int progressImage;
	private int textColor = -1;
	private int backgroundColor;
	private int rightBackground;

	public Item(String main, String secondary) {
		super();
		this.main = main;
		this.secondary = secondary;

		this.progressImage = R.drawable.progress_icon;
		this.textColor = Color.BLACK;
		this.backgroundColor = R.drawable.list_item;
		this.rightBackground = R.drawable.right_background;

	}
	
	public Item(String main, String secondary, int progressImage, int textColor, int backGroundColor, int rightBackground) {
		super();
		this.main = main;
		this.secondary = secondary;
		this.progressImage = progressImage;
		this.textColor = textColor;
		this.backgroundColor = backGroundColor;
		this.rightBackground = rightBackground;

	}

	public Item() {
		// TODO Auto-generated constructor stub
	}

	public String getMain() {
		return main;
	}

	public void setMain(String main) {
		this.main = main;
	}

	public String getSecondary() {
		return secondary;
	}

	public void setSecondary(String secondary) {
		this.secondary = secondary;
	}

	public int getProgressImage() {
		return progressImage;
	}

	public void setProgressImage(int progressImage) {
		this.progressImage = progressImage;
	}

	public int getTextColor() {
		return textColor;
	}

	public void setRightBackground(int rightBackground) {
		this.rightBackground = rightBackground;
	}

	public int getRightBackground() {
		return rightBackground;
	}

	public void setTextColor(int textColor) {
		this.textColor = textColor;
	}

	public int getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(int backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
}
