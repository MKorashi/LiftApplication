package com.example.dell.lift;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.dell.lift.Entities.Medication;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MedsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MedsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MedsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ArrayList<Medication> listitems = new ArrayList<>();
    RecyclerView MyRecyclerView;

    MedicationListAdapter myAdapter;
    String Medications[] = {"Ritalin","Modafinil","Lithium", "Paracetamol", "Celebrex"};

   // private FloatingActionMenu fam;
   // private FloatingActionButton fabNewMed, fabNewReminder, fabScanMed, fabNewMeasurement;

    private OnFragmentInteractionListener mListener;

    public MedsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MedsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MedsFragment newInstance(String param1, String param2) {
        MedsFragment fragment = new MedsFragment();
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

        myAdapter = new MedicationListAdapter(listitems);


        //LinearLayoutManager MyLayoutManager = new LinearLayoutManager(getActivity());
      //  MyLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
      //  if (listitems.size() > 0 & MyRecyclerView != null) {
           // MedicationListAdapter MyAdapter = new MedicationListAdapter(listitems);
           // MyRecyclerView.setAdapter(MyAdapter);
        }
        //MyRecyclerView.setLayoutManager(MyLayoutManager);


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meds, container, false);

      // LinearLayoutManager MyLayoutManager = new LinearLayoutManager(getActivity());
       // MyLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

       /* MyRecyclerView = (RecyclerView) view.findViewById(R.id.meds_recycler_view);
        MyRecyclerView.setHasFixedSize(true);
        MyRecyclerView.setLayoutManager(MyLayoutManager);

        MyRecyclerView.setAdapter(myAdapter);*/


       /* fabNewReminder = (FloatingActionButton) view.findViewById(R.id.fab2);
        fabScanMed = (FloatingActionButton) view.findViewById(R.id.fab3);
        fabNewMed = (FloatingActionButton) view.findViewById(R.id.fab1);
        fabNewMeasurement = (FloatingActionButton) view.findViewById(R.id.fab4);
        fam = (FloatingActionMenu) view.findViewById(R.id.fab_menu);

        fam.setOnMenuToggleListener(new FloatingActionMenu.OnMenuToggleListener() {
            @Override
            public void onMenuToggle(boolean opened) {
                if (opened) {
                    showToast("Menu is opened");
                } else {
                    showToast("Menu is closed");
                }
            }
        });*/

        /*//handling each floating action button clicked
        fabNewMed.setOnClickListener(onButtonClick());
        fabNewReminder.setOnClickListener(onButtonClick());
        fabNewMeasurement.setOnClickListener(onButtonClick());
        fabScanMed.setOnClickListener(onButtonClick());

        fam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fam.isOpened()) {
                    fam.close(true);
                }
            }
        });*/


        // Setting ViewPager for each Tabs
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        // Set Tabs inside Toolbar
        TabLayout tabs = (TabLayout) view.findViewById(R.id.result_tabs);
        tabs.setupWithViewPager(viewPager);


        return view;


    }


    private View.OnClickListener onButtonClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*if (view == fabNewMed) {
                    showToast("Button Add Medication clicked");
                    NewMedScreen newMedScreen = new NewMedScreen();
                    Log.d("My Message", "Hi");
                    FragmentChangeListener fc=(FragmentChangeListener)getActivity();
                    fc.replaceFragment(newMedScreen);
                } else if (view == fabNewReminder) {
                    showToast("Button Add Reminder clicked");
                } else if (view == fabScanMed) {
                    showToast("Button Scan Medication clicked");
                } else{
                    showToast("Button New Measurement clicked");
                    NewMeasurementScreen newMeasurementScreen = new NewMeasurementScreen();
                    Log.d("My Message", "Hi");
                    FragmentChangeListener fc=(FragmentChangeListener)getActivity();
                    fc.replaceFragment(newMeasurementScreen);
                }
                fam.close(true);*/
            }
        };
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }


  /*  @Override
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



    public void initializeList() {
        listitems.clear();
        int medicationsSize = Medications.length;
        for(int i =0;i<medicationsSize;i++){
            Medication Med = new Medication(Medications[i]);
            listitems.add(Med);
        }

    }


    // Add Fragments to Tabs
    private void setupViewPager(ViewPager viewPager) {

        Adapter adapter = new Adapter(getChildFragmentManager());
        adapter.addFragment(new ListofMedGroupsFragment(), "Groups");
        adapter.addFragment(new ListofMedsFragment(), "Medications");
        adapter.addFragment(new ListofMeasurementsFragment(), "Measurements");
        viewPager.setAdapter(adapter);

    }



    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private void showToast(String msg) {
        Toast.makeText(this.getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public Adapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }


}

