package com.easylib.wrappers.adapters;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

public abstract class SimpleNonRecyclableListAdapter<T> extends AbstractBaseAdapter<T>{
	
	protected ViewGroup mParent;

	public SimpleNonRecyclableListAdapter(Context context, List<T> list) {
		super(context, list);
		
	}
	
	protected abstract View newView(int position);
	protected abstract void bindView(View view, int position, T item);
	
	@Override
	public final View getView(int position, View convertView, ViewGroup parent) {
		
		if(mParent != null) {
			mParent = parent;
		}
		
		View view = newView(position);
		bindView(view, position, mList.get(position));
		
		return view;
	}

	public boolean removeItem(int position) {
		mList.remove(position);
		return true;
	}

}
