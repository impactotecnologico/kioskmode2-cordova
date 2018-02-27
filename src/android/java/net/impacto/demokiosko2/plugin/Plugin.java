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

import net.impacto.demokiosko2.MainActivity;

public class Plugin extends CordovaPlugin {

  private Activity activity;
  private Context context;
  private String action;
  
  private int counter = 1;


  public void initialize(CordovaInterface cordova, CordovaWebView webView) {
    super.initialize(cordova, webView);
  }

  @Override
  public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
    this.context = cordova.getActivity().getApplicationContext();
    this.activity = cordova.getActivity();
    this.action = action;
    
    Intent intent = new Intent(context, MainActivity.class);
    this.cordova.getActivity().startActivity(intent);
    
    System.out.println("------------>>>>>>> PLuGIN - " + action);

    return true;
  }

}
