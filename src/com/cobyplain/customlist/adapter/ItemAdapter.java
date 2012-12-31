package com.cobyplain.customlist.adapter;

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

import java.util.List;

import com.cobyplain.customlist.R;
import com.cobyplain.customlist.model.Item;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ItemAdapter extends BaseAdapter {
    private Context mContext;
    private List<Item> mListOfItems;

    public ItemAdapter(Context context, List<Item> listOfItems) {
        this.mContext = context;
        this.mListOfItems = listOfItems;
    }

    public int getCount() {
        return mListOfItems.size();
    }

    public Object getItem(int position) {
        return mListOfItems.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup viewGroup) {
    	Item entry = mListOfItems.get(position);
    	if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.custom_list_item, null);
        }
        
        RelativeLayout background = (RelativeLayout)convertView.findViewById(R.id.background);
        background.setBackground(mContext.getResources().getDrawable((entry.getBackgroundColor())));
        
        TextView mainText = (TextView) convertView.findViewById(R.id.text_main);
        mainText.setText(entry.getMain());
        mainText.setTextColor(entry.getTextColor());

        TextView secondText = (TextView) convertView.findViewById(R.id.text_secondary);
        secondText.setText(entry.getSecondary());
        secondText.setBackgroundResource(entry.getRightBackground());
        secondText.setTextColor(entry.getTextColor());
        
        ImageView progressImage = (ImageView) convertView.findViewById(R.id.progress_image);
        progressImage.setImageResource(entry.getProgressImage());
        
        return convertView;
    }
}
