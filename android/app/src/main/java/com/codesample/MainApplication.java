package com.codesample;

import android.app.Application;
import android.util.Log;

import com.facebook.react.ReactApplication;
import com.microsoft.codepush.react.CodePush;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;

import com.microsoft.codepush.react.ReactInstanceHolder;

import java.util.Arrays;
import java.util.List;

// public class ReactNativeHost extends ReactNativeHost implements ReactInstanceHolder {
//   // ... usual overrides
// }

public class MainApplication extends Application implements ReactApplication {

  private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {

    @Override
    protected String getJSBundleFile() {
      return CodePush.getJSBundleFile();
    }

    @Override
    protected boolean getUseDeveloperSupport() {
      return BuildConfig.DEBUG;
    }

    @Override
    protected List<ReactPackage> getPackages() {
      return Arrays.<ReactPackage>asList(
          new MainReactPackage(),
            // new CodePush(null, getApplicationContext(), BuildConfig.DEBUG)
            new CodePush("87vio2k8rgYaEZiNu_zPcJXz0lSd4kx1rCJib", MainApplication.this, BuildConfig.DEBUG)
            //  new CodePush(BuildConfig.CODEPUSH_KEY, MainApplication.this, BuildConfig.DEBUG);
      );
    }
  };

  @Override
  public ReactNativeHost getReactNativeHost() {
      return mReactNativeHost;
  }

  @Override
  public void onCreate() {
    CodePush.setReactInstanceHolder(mReactNativeHost);
    super.onCreate();
  }
}
