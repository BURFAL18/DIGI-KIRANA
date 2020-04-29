package com.example.digikirana;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;


/*** A simple {@link Fragment} subclass.*/
public class signinfragment extends Fragment {

    public signinfragment() {
        // Required empty public constructor
    }
private TextView donthaveaccount;
private FrameLayout parentframelayout;
/// exists in register layout thus access by get activity
    private EditText email;
    private EditText password;
    private String emailpattern = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    // private ImageButton crossbtn;
    private Button signinbtn;

    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore firebaseFirestore;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_signinfragment, container, false);
        donthaveaccount= view.findViewById(R.id.donthaveaccount_signin);
        parentframelayout=getActivity().findViewById(R.id.registerframelayout);
        email = view.findViewById(R.id.emailsignin);
        password = view.findViewById(R.id.passwordsignin);
        signinbtn=view.findViewById(R.id.btnsignin);
        // crossbtn=view.findViewById(R.id.crosssignup);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
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

  signinbtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          checkEmailandpassword();
      }
  });

       }

       private void checkEmailandpassword() {
           if (email.getText().toString().matches(emailpattern)) {
               firebaseAuth.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                       .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                           @Override
                           public void onComplete(@NonNull Task<AuthResult> task) {
                               if (task.isSuccessful()) {    // creates new intent and shifts to mainactivity(home)
                                   mainIntent();
                               } else {
                                   String error = task.getException().getMessage();
                                   Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
                               }
                           }
                       });
           } else {
               Toast.makeText(getActivity(), "INCORRECT EMAIL /PASSWORD ", Toast.LENGTH_SHORT).show();
           }
       }


    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = (getActivity()).getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(parentframelayout.getId(),fragment);
            fragmentTransaction.commit();
            fragmentTransaction.setCustomAnimations(R.anim.slidefromright ,R.anim.slideoutleft);

    }

    private void mainIntent() {
        Intent mainIntent = new Intent(getActivity(), MainActivity.class);
        startActivity(mainIntent);
        getActivity().finish();
    }
    }


