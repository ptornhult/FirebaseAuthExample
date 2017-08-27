package se.codeunlimited.firebaseauthexample;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import timber.log.Timber;


public class AuthViewModel extends ViewModel {
    private final MutableLiveData<Boolean> loggedIn = new MutableLiveData<>();

    public AuthViewModel() {
        super();
        Timber.d("constructor");
    }

    public LiveData<Boolean> getLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        Boolean isLoggedIn = this.loggedIn.getValue();
        if (isLoggedIn == null || isLoggedIn != loggedIn) {
            this.loggedIn.setValue(loggedIn);
        }
    }

    @Override
    protected void onCleared() {
        Timber.d("onCleared");
        super.onCleared();
    }
}
