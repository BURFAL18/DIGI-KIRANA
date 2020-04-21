package com.example.digikirana;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public class signupfragment extends Fragment {

    public signupfragment() {
        // Required empty public constructor
    }

    private TextView alreadyhaveaccount; /// for switch back to signin
    private FrameLayout pframelayout;
    /// exists in register layout thus access by get activity
    private EditText email;
    private EditText fullname;
    private EditText password;
    private EditText confirmpassword;
    private String emailpattern = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private ImageButton crossbtn;
    private Button signupbtn;

    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore firebaseFirestore;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment creating view (2)
        View view = inflater.inflate(R.layout.fragment_signupfragment, container, false);
        alreadyhaveaccount = view.findViewById(R.id.alreadyhaveaccount_signup);
        pframelayout = getActivity().findViewById(R.id.registerframelayout);
        email = view.findViewById(R.id.emailsignup);
        fullname = view.findViewById(R.id.namesignup);
        password = view.findViewById(R.id.passwordsignup);
        confirmpassword = view.findViewById(R.id.confirmpasssignup);

        // crossbtn=view.findViewById(R.id.crosssignup);
        signupbtn = view.findViewById(R.id.btnsignup);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        alreadyhaveaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new signinfragment());
            }
        });
        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //send data to fbase
                checkEmailAndPassword();
            }
        });
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slidefromleft, R.anim.slideoutfromright);
        fragmentTransaction.replace(pframelayout.getId(), fragment);
        fragmentTransaction.commit();
    }

    private void checkEmailAndPassword() // check mail and password valid
    {
        if (email.getText().toString().matches(emailpattern)) {
            if (password.getText().toString().equals(confirmpassword.getText().toString())) {  // send data to firebase from signup
                firebaseAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {// creates new intent and shifts to mainactivity(home)
                                if (task.isSuccessful()) {  //fn to store name in users using firestore
                                    Map<Object, String> userdata = new HashMap<>();
                                    userdata.put("fullname", fullname.getText().toString());
                                    firebaseFirestore.collection("USERS")
                                            .add(userdata)
                                            .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                                                @Override
                                                public void onComplete(@NonNull Task<DocumentReference> task) {
                                                    if (task.isSuccessful()) {
                                                        Intent mainintent = new Intent(getActivity(), MainActivity.class);
                                                        startActivity(mainintent);
                                                        getActivity().finish();
                                                    } else {
                                                        String error = task.getException().getMessage();
                                                        Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
                                                    }
                                                }
                                            });
                                } else {
                                    String error = task.getException().getMessage();
                                    Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
                                }

                            }
                        });
            } else {
                confirmpassword.setError("Password doesnt matched");
            }
        } else {
            email.setError("Invalid EMAIL!!");
        }
    } // end of emailand pswd check

}
