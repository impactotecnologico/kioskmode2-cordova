package net.impacto.demokiosko2.plugin;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import android.widget.Button;
import android.content.Intent;
import android.net.Uri;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaInterface;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import org.apache.cordova.PluginResult;

import net.impacto.demokiosko2.AppsListActivity;

public class Plugin extends CordovaPlugin {

  private Activity activity;
  private Context context;
  private String action;
  
  private int counter = 1;
  private int counterRemove = 1;

  public void initialize(CordovaInterface cordova, CordovaWebView webView) {
    super.initialize(cordova, webView);
  }

  @Override
  public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
    this.context = cordova.getActivity().getApplicationContext();
    this.activity = cordova.getActivity();
    this.action = action;
    
    System.out.println("------------>>>>>>> PLuGIN -> " + action);
    
    boolean result = false;
    
    if (action.equals("apps")){
      this.showApps();
    } else if (action.equals("onBackPressed")) {
      this.onBackPressed();
    } else {
      callbackContext.error("\"" + action + "\" is not a recognized action.");
      return false;
    }
    
    PluginResult pluginResult = new PluginResult(PluginResult.Status.OK);
    callbackContext.sendPluginResult(pluginResult);
    return true;      
    

  }
  
  public void showApps(){
      Intent i = new Intent(this.context, AppsListActivity.class);

      if (this.counter == 7){
          this.counter = 0;
          this.cordova.getActivity().startActivity(i);
      } else {
          this.counter++;
      }
      System.out.println("---->>>>>>> showApps " + this.counter);
  }
  
  public void onBackPressed() {
      if (this.counterRemove == 7) {
          this.counterRemove = 0;
          Intent intent = new Intent(Intent.ACTION_DELETE);
          intent.setData(Uri.parse("package:"+this.context.getPackageName()));
          this.cordova.getActivity().startActivity(intent);
      } else {
          this.counterRemove++;
      }
      System.out.println("---->>>>>>> onBackPressed " + this.counterRemove);
  }

}
