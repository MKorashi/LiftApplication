package com.example.dell.lift;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SignUpFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SignUpFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SignUpFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private EditText editText_name;
    private EditText editText_date;
    private EditText editText_email;
    private EditText editText_password1;
    private EditText editText_password2;
    private EditText editText_weightValue;
    private EditText editText_icd10;

    private Spinner genderDropDown;
    private Spinner countryDropDown;
    private Spinner weightDropDown;

    private Button next_signup;

    private Context activity = this.getActivity();


    private  String name;
    private Gender gender;
    private String dateOfBirth;
    private String email;
    private String password;
    private String country;
    private WeightUnit weightUnit;
    private int weightValue;
    private String ICD_10;


    private OnFragmentInteractionListener mListener;

    public SignUpFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SignUpFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SignUpFragment newInstance(String param1, String param2) {
        SignUpFragment fragment = new SignUpFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_sign_up, container, false);

        next_signup = (Button) rootView.findViewById(R.id.button_signup_next);

        genderDropDown = (Spinner) rootView.findViewById(R.id.spinner2);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this.getContext(),
                R.array.gender_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        genderDropDown.setAdapter(adapter);
        genderDropDown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent,
                                       View view, int pos, long id) {
                //weightUnit = parent.getItemAtPosition(pos).toString();

                String z = parent.getItemAtPosition(pos).toString();

                switch(z){
                    case "Female": gender = Gender.Female;break;
                    case "Male": gender = Gender.Male;break;
                    case "Other": gender = Gender.Other;

                }

                Toast.makeText(parent.getContext(),
                        "OnItemSelectedListener : " + gender.toString(),
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });


        countryDropDown = (Spinner) rootView.findViewById(R.id.spinner3);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this.getContext(),
                R.array.countries_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        countryDropDown.setAdapter(adapter2);
        countryDropDown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent,
                                       View view, int pos, long id) {
                //weightUnit = parent.getItemAtPosition(pos).toString();

                country =  parent.getItemAtPosition(pos).toString();
                Log.wtf("Country","Country "+ country.toString());

                Toast.makeText(parent.getContext(),
                        "OnItemSelectedListener : " + country.toString(),
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });


        weightDropDown = (Spinner) rootView.findViewById(R.id.spinner4);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this.getContext(),
                R.array.weight_unit_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        weightDropDown.setAdapter(adapter3);
        weightDropDown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent,
                                       View view, int pos, long id) {
                //weightUnit = parent.getItemAtPosition(pos).toString();

                String x = parent.getItemAtPosition(pos).toString();

                switch(x){
                    case "Kgs": weightUnit = WeightUnit.kg;break;
                    case "Lbs": weightUnit = WeightUnit.lb;
                }
                Log.wtf("Weight","Weight Unit: "+ weightUnit.toString());
                Toast.makeText(parent.getContext(),
                        "OnItemSelectedListener : " + weightUnit.toString(),
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });




        next_signup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button

//check that none of the fields are empty, assign mandatory fields


                Intent intent = new Intent(getContext(), ContactsActivity.class);
                startActivity(intent);

            }
        });

        return rootView;
    }


    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)

       /* if(view.getId() == R.id.spinner2){//gender

            String x = parent.getItemAtPosition(pos).toString();

            switch(x){
                case "female": this.gender = Gender.Female;
                case "male": this.gender = Gender.Male;
                case "other": this.gender = Gender.Other;

            }
            Log.wtf("Gender","Gender: "+ this.gender.toString());

        } else if(view.getId() == R.id.spinner3){//country

          this.country =  parent.getItemAtPosition(pos).toString();
            Log.wtf("Country","Country "+ this.country.toString());



        }else if (view.getId() == R.id.spinner4){//weightUnit

           String x = parent.getItemAtPosition(pos).toString();

            switch(x){
                case "Kgs": this.weightUnit = WeightUnit.kg;
                case "Lbs": this.weightUnit = WeightUnit.lb;
            }
            Log.wtf("Weight","Weight Unit: "+ this.weightUnit.toString());

        }

*/

    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

   /* @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }*/

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }






}
