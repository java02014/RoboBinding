/**
 * Copyright 2012 Cheng Wei, Robert Taylor
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions
 * and limitations under the License.
 */
package org.robobinding.viewattribute.listview;

import java.util.Set;

import org.junit.Before;
import org.robobinding.viewattribute.AbstractPropertyViewAttributeTest;
import org.robobinding.viewattribute.PropertyViewAttribute;
import org.robobinding.viewattribute.RandomValues;

import android.R;
import android.util.SparseBooleanArray;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.xtremelabs.robolectric.Robolectric;

/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
public abstract class AbstractCheckedItemPositionsAttributeTest<ViewType extends ListView, PropertyViewAttributeType extends PropertyViewAttribute<? super ViewType>> extends AbstractPropertyViewAttributeTest<ViewType, PropertyViewAttributeType>
{
	private ListAdapter adapter;
	@Before
	public void setUp()
	{
		Robolectric.bindShadowClass(ShadowListView.class);
		Robolectric.bindShadowClass(ShadowSparseBooleanArray.class);
		super.initializeViewAndAttribute();
		
		adapter = new MockArrayAdapter(R.layout.simple_list_item_multiple_choice);
		view.setAdapter(adapter);
		view.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
	}
	
	protected void setItemsChecked(Set<Integer> checkedItemPositions)
	{
		for(Integer checkedItemPosition : checkedItemPositions)
		{
			view.setItemChecked(checkedItemPosition, true);
		}
	}
	
	protected SparseBooleanArray anySparseBooleanArray()
	{
		SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
		for(int i=0; i<adapter.getCount(); i++)
		{
			int selector = RandomValues.nextInt(3);
			if(selector == 0)
			{
				sparseBooleanArray.put(i, true);
			}else if(selector == 1)
			{
				sparseBooleanArray.put(i, false);
			}else
			{
			}
		}
		return sparseBooleanArray;
	}
}