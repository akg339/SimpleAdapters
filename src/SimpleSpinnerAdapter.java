package com.easylib.wrappers.adapters;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

public abstract class SimpleSpinnerAdapter<T> extends AbstractBaseAdapter<T>{

	public SimpleSpinnerAdapter(Context context, List<T> list) {
		super(context, list);
	
	}
	
	protected abstract View newView(int position);
	protected abstract void bindView(View view, int position, T item);

	@Override
	public final View getView(int position, View convertView, ViewGroup parent) {
		
		View view =null;
		if(convertView == null) {
			view = newView(position);
		} else {
			view = convertView;
		}
		
		bindView(view, position, mList.get(position));
		
		return view;
	}
	
	@Override
	public final View getDropDownView(int position, View convertView, ViewGroup parent) {
		View view =null;
		if(convertView == null) {
			view = newDropDownView(position);
		} else {
			view = convertView;
		}
		
		bindDropDownView(view, position, mList.get(position));
		
		return view;
	}
	
	protected View newDropDownView(int position) {
		return newView(position);
	}
	
	protected void bindDropDownView(View view, int position, T data) {
		bindView(view, position, data);
	}

}
