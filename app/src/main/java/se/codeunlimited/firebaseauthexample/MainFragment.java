package se.codeunlimited.firebaseauthexample;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import timber.log.Timber;

public class MainFragment extends LogFragment {
    private Unbinder unbinder;

    private AuthViewModel authViewModel;
    @BindView(R.id.text) TextView text;
    @BindView(R.id.signin) Button signin;
    @BindView(R.id.signout) Button signout;
    @BindView(R.id.revoke) Button revoke;
    @BindView(R.id.button) Button button;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Share state with activity
        authViewModel = ViewModelProviders.of(getActivity()).get(AuthViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);

        signin.setOnClickListener(v -> ((MainActivity)getActivity()).signIn());
        signout.setOnClickListener(v -> ((MainActivity)getActivity()).signOut());
        revoke.setOnClickListener(v -> ((MainActivity)getActivity()).revokeAccess());

        button.setOnClickListener(v -> {
            FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.placeholder, new SecondFragment());
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        });
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }

    @Override
    public void onStart() {
        super.onStart();
        authViewModel.getLoggedIn().observe(this, this::onLoginUpdate);
    }

    @Override
    public void onStop() {
        authViewModel.getLoggedIn().removeObservers(this);
        super.onStop();
    }

    private void onLoginUpdate(@NonNull Boolean loggedIn) {
        Timber.d("Is logged in: %b", loggedIn);
        text.setText(getString(loggedIn ? R.string.loggedin : R.string.loggedout));
        signin.setEnabled(!loggedIn);
        revoke.setEnabled(loggedIn);
    }
}
