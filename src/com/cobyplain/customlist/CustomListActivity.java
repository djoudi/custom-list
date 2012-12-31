package com.cobyplain.customlist;

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

import java.util.ArrayList;
import java.util.List;

import com.cobyplain.customlist.adapter.ItemAdapter;
import com.cobyplain.customlist.model.Item;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.graphics.Color;
import android.widget.ListView;

public class CustomListActivity extends Activity {

	ListView mList;
	List<Item> mListOfItems;
	ItemAdapter mAdapter;
	String mTitle;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_custom_list);

		setUpList();

		//This will simulate what the progression would look like for you
		mHandler.removeCallbacks(mFakeMovement);
		mHandler.postDelayed(mFakeMovement, 1000);
	}

	@Override
	protected void onPause() {
		mHandler.removeCallbacks(mFakeMovement);
		super.onPause();
	}

	private void setUpList() {

		mList = (ListView) findViewById(R.id.listview);

		mListOfItems = new ArrayList<Item>();
		mListOfItems.add(new Item("Category, Item one and some text", "2:45pm", R.drawable.list_item_next, Color.WHITE, R.drawable.progress_icon_current, R.drawable.right_background_current));
		mListOfItems.add(new Item("Category, Item two and some text", "2:46pm"));
		mListOfItems.add(new Item("Category2, Item three and some text", "2:52pm"));
		mListOfItems.add(new Item("Category2, Item four and some text", "2:58pm"));
		mListOfItems.add(new Item("Category, Item five and some text", "3:02pm"));
		mListOfItems.add(new Item("Category3, Item six and some text", "3:07pm"));

		mAdapter = new ItemAdapter(this, mListOfItems);
		mList.setAdapter(mAdapter);

	}

	private Handler mHandler = new Handler();
	private Runnable mFakeMovement = new Runnable() {
		int i = 0;

		public void run() {

			mListOfItems.get(i).setBackgroundColor(R.drawable.list_item_passed);
			mListOfItems.get(i).setTextColor(Color.GRAY);
			mListOfItems.get(i).setProgressImage(R.drawable.progress_icon_passed);
			mListOfItems.get(i).setRightBackground(R.drawable.right_background_passed);

			mListOfItems.get(i + 1).setBackgroundColor(R.drawable.list_item_next);
			mListOfItems.get(i + 1).setProgressImage(R.drawable.progress_icon_current);
			mListOfItems.get(i + 1).setRightBackground(R.drawable.right_background_current);
			mListOfItems.get(i + 1).setTextColor(Color.WHITE);

			mAdapter.notifyDataSetChanged();

			i++;

			if (i < mListOfItems.size() - 1)
				mHandler.postDelayed(this, 2000);
		}
	};
}
