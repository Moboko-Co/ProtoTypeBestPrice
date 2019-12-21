package com.example.prototypebestprice.ui;

import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.prototypebestprice.R;

public class itemSearchFragment extends Fragment {
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_itemsearch, container, false);
        ImageButton barCodeImageButton = root.findViewById(R.id.barCodeImageButton);
        barCodeImageButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(getActivity(), "バーコード検索!", Toast.LENGTH_SHORT).show();
            }
        });

        return root;
    }
}
