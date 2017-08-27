package se.codeunlimited.firebaseauthexample;

import android.arch.lifecycle.LifecycleFragment;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import timber.log.Timber;

public class MyFragment extends LifecycleFragment {
    private Unbinder unbinder;

    private MyViewModel myViewModel;
    @BindView(R.id.text) TextView text;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Timber.d("onCreate");
        super.onCreate(savedInstanceState);

        myViewModel = ViewModelProviders.of(getActivity()).get(MyViewModel.class);
    }

    @Override
    public void onDestroy() {
        Timber.d("onDestroy");
        super.onDestroy();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Timber.d("onViewCreated");
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);

        text.setOnClickListener(v -> {
            myViewModel.incCounter();
        });
    }

    @Override
    public void onDestroyView() {
        Timber.d("onDestroyView");
        unbinder.unbind();
        super.onDestroyView();
    }

    @Override
    public void onStart() {
        Timber.d("onStart");
        super.onStart();
    }

    @Override
    public void onStop() {
        Timber.d("onStop");
        super.onStop();
    }

    @Override
    public void onPause() {
        Timber.d("onPause");
        super.onPause();
    }

    @Override
    public void onResume() {
        Timber.d("onResume");
        super.onResume();
    }
}
