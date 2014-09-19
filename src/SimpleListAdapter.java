package com.easylib.wrappers.adapters;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

public abstract class SimpleListAdapter<T> extends AbstractBaseAdapter<T>{

	public SimpleListAdapter(Context context, List<T> list) {
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
	
    /**
     * An animation specially for listview items
     * @param view View for which animation has to be applied
     * @param currentPosition listview current position
     * @param lastPosition listview last position
     * */
    public  void setListViewItemAnimation(View view, int currentPosition, int lastPosition){
    	if(view==null){
    		return;
    	}
    	Animation animation = new TranslateAnimation(0, 0, (currentPosition > lastPosition) ? 150 : -150, 0);
        animation.setDuration(400);
        view.startAnimation(animation);
    }
}
