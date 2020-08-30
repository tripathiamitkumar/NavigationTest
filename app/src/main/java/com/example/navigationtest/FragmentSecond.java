package com.example.navigationtest;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentSecond extends Fragment {
    private onThirdFragmentBtnSelected listener2;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second,container,false);
        Button clickme2 = view.findViewById(R.id.loadThird);
        clickme2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener2.onButtonSeleted2();
            }
        });
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof onThirdFragmentBtnSelected){
            listener2 = (onThirdFragmentBtnSelected) context;
        }else {
            throw new ClassCastException(context.toString() + "must implement listener");
        }
    }
    public interface onThirdFragmentBtnSelected{
        public void onButtonSeleted2();
    }
}
