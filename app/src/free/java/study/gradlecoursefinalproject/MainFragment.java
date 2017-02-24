package study.gradlecoursefinalproject;


import android.os.Bundle;
import android.support.v4.BuildConfig;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.util.concurrent.ExecutionException;

import butterknife.ButterKnife;
import butterknife.InjectView;
import timber.log.Timber;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    @InjectView(R.id.submit)
    Button button;

    @InjectView(R.id.textView)
    TextView textView;

    @InjectView(R.id.adView)
    AdView mAdView;

    InterstitialAd mInterstitialAd;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.inject(this,root);
        AdRequest adRequest = new AdRequest.Builder()
                    .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                    .addTestDevice(getString(R.string.MEIZU_M2_NOTE))
                    .build();
            mAdView.loadAd(adRequest);
        mInterstitialAd = new InterstitialAd(getContext());
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();
                action();
            }
        });

        requestNewInterstitial();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                action();
            }
        });
        return root;
    }

    private void action(){
        try {
            String joke = new EndpointAsyncTask().execute().get();
            textView.setText(joke);
            Timber.d(joke);
        } catch (InterruptedException | ExecutionException e) {
            Timber.e(e.getMessage());
        }
    }

    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice("SEE_YOUR_LOGCAT_TO_GET_YOUR_DEVICE_ID")
                .build();

        mInterstitialAd.loadAd(adRequest);
    }

}
