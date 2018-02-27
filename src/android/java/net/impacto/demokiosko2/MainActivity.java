package net.impacto.demokiosko2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

public class MainActivity extends Activity {

    private int counter = 1;
    private int counterRemove = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getResources().getIdentifier("activity_main", "layout", getPackageName()));
    }

    public void showApps(View v){
        Intent i = new Intent(this, AppsListActivity.class);

        if (this.counter == 7){
            this.counter = 0;
            startActivity(i);
        } else {
            this.counter++;
        }
    }

    @Override
    public void onBackPressed() {
        if (this.counterRemove == 7) {
            this.counterRemove = 0;
            Intent intent = new Intent(Intent.ACTION_DELETE);
            //Enter app package name that app you wan to install
            intent.setData(Uri.parse("package:io.ionic.starter"));
            startActivity(intent);
        } else {
            this.counterRemove++;
        }
    }
}
