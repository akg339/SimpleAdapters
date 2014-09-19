package com.easylib.wrappers.adapters;

import java.util.List;

import android.content.Context;

public abstract class AbstractPaginatedListAdapter <T> extends SimpleListAdapter<T>{
	
	public AbstractPaginatedListAdapter(Context context, List<T> list) {
		super(context, list);
	}

	public void addData(List<T> list) {
		mList.addAll(list);
		notifyDataSetChanged();
	}	
}
