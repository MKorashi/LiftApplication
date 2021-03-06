package com.example.dell.lift;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link NewMedScreen.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link NewMedScreen#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewMedScreen extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Button btnNext;

     boolean is_checked;

    private CheckBox isPlannedCheckBox;
    private TextView txtViewDuration;
    private TextView txtViewIntakeFrequency;
    private Spinner spinnerDuration;
    private Spinner spinnerIntakeFrequency;
    private Spinner spinnerUnit;

    private OnFragmentInteractionListener mListener;

    public NewMedScreen() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NewMedScreen.
     */
    // TODO: Rename and change types and number of parameters
    public static NewMedScreen newInstance(String param1, String param2) {
        NewMedScreen fragment = new NewMedScreen();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_new_med_screen, container, false);

        isPlannedCheckBox = (CheckBox)view.findViewById(R.id.checkBox_Planned);
        txtViewDuration = (TextView) view.findViewById(R.id.textView_Duration);
        txtViewIntakeFrequency = (TextView) view.findViewById(R.id.textView_IntakeFrequency);
       // spinnerDuration = (Spinner) view.findViewById(R.id.spinner_duration);
       // spinnerIntakeFrequency = (Spinner) view.findViewById(R.id.spinner_intakeFrequency);
        spinnerUnit = (Spinner) view.findViewById(R.id.spinner_Unit);

         btnNext = (Button) view.findViewById(R.id.nextToReminder);

        isPlannedCheckBox.setOnCheckedChangeListener(new myCheckBoxChnageClicker());




        // Inflate the layout for this fragment
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

  //  @Override
   /* public void onAttach(Context context) {
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


    class myCheckBoxChnageClicker implements CheckBox.OnCheckedChangeListener
    {

        @Override
        public void onCheckedChanged(CompoundButton buttonView,
                                     boolean isChecked) {
            // TODO Auto-generated method stub

            // Toast.makeText(CheckBoxCheckedDemo.this, &quot;Checked =&gt; &quot;+isChecked, Toast.LENGTH_SHORT).show();

            if(isChecked) {
                //set the visibility to true for the spinners and the text views.
                txtViewDuration.setVisibility(View.VISIBLE);
                txtViewIntakeFrequency.setVisibility(View.VISIBLE);
              //  spinnerDuration
                //        .setVisibility(View.VISIBLE);
              //  spinnerIntakeFrequency.setVisibility(View.VISIBLE);
                is_checked = true;
            } else {
                txtViewDuration.setVisibility(View.INVISIBLE);
                txtViewIntakeFrequency.setVisibility(View.INVISIBLE);
             //   spinnerDuration
               //         .setVisibility(View.INVISIBLE);
               // spinnerIntakeFrequency.setVisibility(View.INVISIBLE);
                is_checked = false;
            }
        }
    }


    void NextScreen(){

        if(is_checked){

            //yeb2a planned, yeb2a add a reminder screen

        } else if (!is_checked) {
            
            //just add that new medication to the list w 5alas
            //include details
        }

       // Fragment fr=new NewDisplayingFragment();
       // FragmentChangeListener fc=(FragmentChangeListener)getActivity();
       // fc.replaceFragment(fr);


    }
}
