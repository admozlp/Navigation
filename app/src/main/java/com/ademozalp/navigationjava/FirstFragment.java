package com.ademozalp.navigationjava;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FirstFragment extends Fragment {

    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button btn = view.findViewById(R.id.button);
        EditText editText = view.findViewById(R.id.editText);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt = editText.getText().toString();
                if(txt.matches(""))
                    txt = "0";
                gotoSecond(view, txt);
            }
        });
    }

    public void gotoSecond(View view, String age){
        //NavDirections direction = FirstFragmentDirections.actionFirstFragmentToSecondFragment();

        FirstFragmentDirections.ActionFirstFragmentToSecondFragment direction = FirstFragmentDirections.actionFirstFragmentToSecondFragment();
        direction.setAge(Integer.parseInt(age));
        Navigation.findNavController(view).navigate(direction);
    }
}