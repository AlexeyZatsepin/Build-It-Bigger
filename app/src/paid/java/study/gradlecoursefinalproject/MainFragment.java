package study.gradlecoursefinalproject;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.ButterKnife;
import butterknife.InjectView;
import study.jokelibrary.JokeActivity;

import static study.gradlecoursefinalproject.RefreshAction.getJoke;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    @InjectView(R.id.submit)
    Button button;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.inject(this,root);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent = new Intent(getActivity(),JokeActivity.class);
                    intent.putExtra("joke",getJoke());
                    intent.putExtra("action",new RefreshAction());
                    startActivity(intent);
            }
        });
        return root;
    }





}
