package com.example.dell.lift;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.lift.Entities.Measurement;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ListofMeasurementsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ListofMeasurementsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListofMeasurementsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;


    ArrayList<Measurement> listitems = new ArrayList<>();
    RecyclerView MyRecyclerView;

    MeasurementListAdapter myAdapter;
    String Medications[] = {"Ritalin","Modafinil","Lithium", "Paracetamol", "Celebrex"};

    public ListofMeasurementsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListofMeasurementsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListofMeasurementsFragment newInstance(String param1, String param2) {
        ListofMeasurementsFragment fragment = new ListofMeasurementsFragment();
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

        initializeList();

        myAdapter = new MeasurementListAdapter(listitems);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_listof_measurements, container, false);

        LinearLayoutManager MyLayoutManager = new LinearLayoutManager(getActivity());
        MyLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        MyRecyclerView = (RecyclerView) view.findViewById(R.id.measurements_recycler_view);
        MyRecyclerView.setHasFixedSize(true);
        MyRecyclerView.setLayoutManager(MyLayoutManager);

        MyRecyclerView.setAdapter(myAdapter);
        registerForContextMenu(MyRecyclerView);


        FloatingActionButton myFab = (FloatingActionButton) view.findViewById(R.id.fab);
        myFab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //change to new med screen
                NewMeasurementScreen newMeasurementScreen = new NewMeasurementScreen();
                Log.d("My Message", "Hi");
                FragmentChangeListener fc=(FragmentChangeListener)getActivity();
                fc.replaceFragment(newMeasurementScreen);
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }



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

    public void initializeList() {
        listitems.clear();
        int measurementsSize = Medications.length;
        for(int i =0;i<measurementsSize;i++){
            Measurement measurement = new Measurement(Medications[i]);
            listitems.add(measurement);
        }

    }


}
