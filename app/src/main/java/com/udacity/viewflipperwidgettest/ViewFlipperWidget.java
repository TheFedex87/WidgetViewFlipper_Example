package com.udacity.viewflipperwidgettest;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of App Widget functionality.
 */
public class ViewFlipperWidget extends AppWidgetProvider {

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {


        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.view_flipper_widget);
        Intent intent = new Intent(context, FlipperWidgetService.class);
        views.setRemoteAdapter(R.id.widget_flipper, intent);

        Intent nextRecipeIntent = new Intent(context, RecipeListWidgetService.class);
        nextRecipeIntent.setAction(RecipeListWidgetService.NEXT_RECIPE_ACTION);
        nextRecipeIntent.putExtra("APP_WIDGET_ID", appWidgetId);
        PendingIntent pendingIntent = PendingIntent.getService(context, 0, nextRecipeIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        views.setOnClickPendingIntent(R.id.widget_next_view, pendingIntent);

        views.setDisplayedChild(R.id.widget_flipper, 2);

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

