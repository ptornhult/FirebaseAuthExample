package se.codeunlimited.firebaseauthexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import timber.log.Timber;

public abstract class LogActivity extends AppCompatActivity {

    private Timber.Tree getTimber() {
        return Timber.tag(getClass().getSimpleName());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getTimber().d("onCreate");
        super.onCreate(savedInstanceState);
        getTimber().v("onCreated");
    }

    @Override
    protected void onDestroy() {
        getTimber().d("onDestroy");
        super.onDestroy();
        getTimber().v("onDestroyed");
    }

    @Override
    protected void onStart() {
        getTimber().d("onStart");
        super.onStart();
        getTimber().v("onStarted");
    }

    @Override
    protected void onStop() {
        getTimber().d("onStop");
        super.onStop();
        getTimber().v("onStopped");
    }

    @Override
    protected void onPause() {
        getTimber().d("onPause");
        super.onPause();
        getTimber().v("onPaused");
    }

    @Override
    protected void onResume() {
        getTimber().d("onResume");
        super.onResume();
        getTimber().v("onResumed");
    }
}
