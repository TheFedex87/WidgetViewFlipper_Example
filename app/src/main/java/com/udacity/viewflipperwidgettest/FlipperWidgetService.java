package com.udacity.viewflipperwidgettest;

import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by federico.creti on 09/04/2018.
 */

public class FlipperWidgetService extends RemoteViewsService {

    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        return new FlipperRemoteViewFactory(getApplicationContext());
    }
}

class FlipperRemoteViewFactory implements RemoteViewsService.RemoteViewsFactory {
    private Context context;
    private List<String> stringList;

    public FlipperRemoteViewFactory(Context context){
        this.context = context;

        stringList = new ArrayList<String>();
        stringList.add("Ciao");
        stringList.add("Come");
        stringList.add("Stai");
        stringList.add("?");
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDataSetChanged() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public int getCount() {
        return stringList.size();
    }

    @Override
    public RemoteViews getViewAt(int i) {
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.single_recipe_widget);
        views.setTextViewText(R.id.text_copntainer, stringList.get(i));

        return views;
    }

    @Override
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }
}
