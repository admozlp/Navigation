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
import android.widget.TextView;

public class SecondFragment extends Fragment {

    public SecondFragment() {//constructor method
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }//fragment oluşturulduğu an

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }// görünüm oluşturulduğu an layout a bağla

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {// görünüm oluşturuldu yapılacaklar
        super.onViewCreated(view, savedInstanceState);

        Button btn = view.findViewById(R.id.button2);
        TextView textView = view.findViewById(R.id.textView);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoFirst(view);
            }
        });

        if(getArguments() != null){
            int age = SecondFragmentArgs.fromBundle(getArguments()).getAge();
            textView.setText("Age " + age);
        }
    }

    public void gotoFirst(View view){
        NavDirections direction = SecondFragmentDirections.actionSecondFragmentToFirstFragment();
        Navigation.findNavController(view).navigate(direction);
    }
}