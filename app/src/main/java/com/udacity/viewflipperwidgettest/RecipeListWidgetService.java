package com.udacity.viewflipperwidgettest;

import android.app.IntentService;
import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.Toast;

/**
 * Created by federico.creti on 09/04/2018.
 */

public class RecipeListWidgetService extends IntentService {
    public static final String NEXT_RECIPE_ACTION = "com.udacity.viewflipperwidgettest.action.nextrecipe";

    public RecipeListWidgetService(){
        super(RecipeListWidgetService.class.getSimpleName());
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        if (intent.getAction().equals(NEXT_RECIPE_ACTION)){
            Log.d("RecipeListWidgetService", "Next click received");
            int appWidgetId = intent.getIntExtra("APP_WIDGET_ID", 0);
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this.getApplicationContext());
            RemoteViews rv = new RemoteViews(getApplicationContext().getPackageName(), R.layout.view_flipper_widget);
            rv.showNext(R.id.widget_flipper);
            appWidgetManager.updateAppWidget(appWidgetId, rv);
        }
    }
}
