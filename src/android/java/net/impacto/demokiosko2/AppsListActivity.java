package net.impacto.demokiosko2;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import net.impacto.demokiosko2.models.AppDetail;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by impacto on 23/02/2018.
 */

public class AppsListActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(getResources().getIdentifier("activity_apps_list", "layout", getPackageName()));

        loadApps();
        loadListView();
        addClickListener();
    }

    private PackageManager manager;
    private List<AppDetail> apps;
    private void loadApps(){
        manager = getPackageManager();
        apps = new ArrayList<AppDetail>();

        Intent i = new Intent(Intent.ACTION_MAIN, null);
        i.addCategory(Intent.CATEGORY_LAUNCHER);

        List<ResolveInfo> availableActivities = manager.queryIntentActivities(i, 0);
        for(ResolveInfo ri:availableActivities){
            AppDetail app = new AppDetail();
            app.label = ri.loadLabel(manager);
            app.name = ri.activityInfo.packageName;
            app.icon = ri.activityInfo.loadIcon(manager);
            apps.add(app);
        }
    }

    private ListView list;
    private void loadListView(){
      
        list = (ListView)findViewById(getResources().getIdentifier("apps_list", "id", getPackageName()));

        ArrayAdapter<AppDetail> adapter = new ArrayAdapter<AppDetail>(this,
                getResources().getIdentifier("list_item", "layout", getPackageName()),
                apps) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if(convertView == null){
                    convertView = getLayoutInflater().inflate(getResources().getIdentifier("list_item", "layout", getPackageName()), null);
                }

                ImageView appIcon = (ImageView)convertView.findViewById(getResources().getIdentifier("item_app_icon", "id", getPackageName()));
                appIcon.setImageDrawable(apps.get(position).icon);

                TextView appLabel = (TextView)convertView.findViewById(getResources().getIdentifier("item_app_label", "id", getPackageName()));
                appLabel.setText(apps.get(position).label);

                TextView appName = (TextView)convertView.findViewById(getResources().getIdentifier("item_app_name", "id", getPackageName()));
                appName.setText(apps.get(position).name);

                return convertView;
            }
        };

        list.setAdapter(adapter);
    }

    private void addClickListener(){
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> av, View v, int pos,
                                    long id) {
                Intent i = manager.getLaunchIntentForPackage(apps.get(pos).name.toString());
                AppsListActivity.this.startActivity(i);
            }
        });
    }


}
