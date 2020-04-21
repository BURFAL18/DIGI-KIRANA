package com.example.digikirana;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.Objects;


/*** A simple {@link Fragment} subclass.*/
public class signinfragment extends Fragment {

    public signinfragment() {
        // Required empty public constructor
    }
private TextView donthaveaccount;
private FrameLayout parentframelayout;
/// exists in register layout thus access by get activity

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_signinfragment, container, false);
        donthaveaccount= view.findViewById(R.id.donthaveaccount_signin);
        parentframelayout=getActivity().findViewById(R.id.registerframelayout);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
 donthaveaccount.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View v) {
         setFragment(new signupfragment());
     }
 });
       }
        private void setFragment(Fragment fragment) {
       FragmentTransaction fragmentTransaction= Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(parentframelayout.getId(),fragment);
            fragmentTransaction.commit();
            fragmentTransaction.setCustomAnimations(R.anim.slidefromright ,R.anim.slideoutleft);
        }
    }

