package com.example.dell.lift;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.LabelFormatter;
import com.jjoe64.graphview.helper.DateAsXAxisLabelFormatter;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MoodOverviewFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MoodOverviewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MoodOverviewFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    DateFormat df = new SimpleDateFormat("MM/dd/yyyy");


    View rootView;
    GraphView positiveEffectGraph;
    GraphView negativeEffectGraph;
    GraphView engagementGraph;
    GraphView pleasantnessGraph;

    private OnFragmentInteractionListener mListener;

    public MoodOverviewFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MoodOverviewFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MoodOverviewFragment newInstance(String param1, String param2) {
        MoodOverviewFragment fragment = new MoodOverviewFragment();
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
        // Inflate the layout for this fragment
         rootView =  inflater.inflate(R.layout.fragment_mood_overview, container, false);

        makeDatesAppearOnPositiveEffectGraph();
        makeDatesAppearOnNegativeEffectGraph();
        makeDatesAppearOnEngagementGraph();
        makeDatesAppearOnPleasantnessEffectGraph();

//positiveEffectGraph.setDrawBackground(true);
  //
        //      positiveEffectGraph.setBackgroundColor(Color.LTGRAY);



        return rootView;
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

    public void makeDatesAppearOnPositiveEffectGraph(){

        Calendar calendar = Calendar.getInstance();
        Date d1 =  calendar.getTime();
        calendar.add(Calendar.DATE, 1);
        Date d2 =  calendar.getTime();
        calendar.add(Calendar.DATE, 1);
        Date d3 = calendar.getTime();

        positiveEffectGraph = (GraphView) rootView.findViewById(R.id.positiveEffectGraph);

// you can directly pass Date objects to DataPoint-Constructor
// this will convert the Date to double via Date#getTime()
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(d1, 1),
                new DataPoint(d2, 0),
                new DataPoint(d3, 0)
        });

        series.setDrawBackground(true);
        series.setBackgroundColor(Color.CYAN);
        positiveEffectGraph.getViewport().setScrollable(true); // enables horizontal scrolling

        positiveEffectGraph.getViewport().setMinY(0);
        positiveEffectGraph.getViewport().setMaxY(1);
        positiveEffectGraph.getViewport().setYAxisBoundsManual(true);

        positiveEffectGraph.addSeries(series);

        positiveEffectGraph.getGridLabelRenderer().setNumVerticalLabels(2);


// set date label formatter
      //  positiveEffectGraph.getGridLabelRenderer().setLabelFormatter(new DateAsXAxisLabelFormatter(getActivity()));
        positiveEffectGraph.getGridLabelRenderer().setNumHorizontalLabels(3); // only 4 because of the space

// set manual x bounds to have nice steps
        /*positiveEffectGraph.getViewport().setMinX(d1.getTime());
        positiveEffectGraph.getViewport().setMaxX(d3.getTime());
        positiveEffectGraph.getViewport().setXAxisBoundsManual(true);*/

        positiveEffectGraph.getGridLabelRenderer().setHumanRounding(false);


        StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(positiveEffectGraph);
        staticLabelsFormatter.setVerticalLabels(new String[] {"Drowsy", "Active"});
        staticLabelsFormatter.setHorizontalLabels(new String[] {df.format(d1.getTime()), df.format(d2.getTime()), df.format(d3.getTime())});
        positiveEffectGraph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);



    }


    public void makeDatesAppearOnNegativeEffectGraph(){

        Calendar calendar = Calendar.getInstance();
        Date d1 =  calendar.getTime();
        calendar.add(Calendar.DATE, 1);
        Date d2 =  calendar.getTime();
        calendar.add(Calendar.DATE, 1);
        Date d3 = calendar.getTime();

        negativeEffectGraph = (GraphView) rootView.findViewById(R.id.negativeEffectGraph);
        negativeEffectGraph.getViewport().setScrollable(true); // enables horizontal scrolling

        negativeEffectGraph.getViewport().setMinY(0);
        negativeEffectGraph.getViewport().setMaxY(1);
        negativeEffectGraph.getViewport().setYAxisBoundsManual(true);




// you can directly pass Date objects to DataPoint-Constructor
// this will convert the Date to double via Date#getTime()
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(d1, 1),
                new DataPoint(d2, 0),
                new DataPoint(d3, 1)
        });

        series.setDrawBackground(true);
        negativeEffectGraph.addSeries(series);

// set date label formatter
     //   negativeEffectGraph.getGridLabelRenderer().setLabelFormatter(new DateAsXAxisLabelFormatter(getActivity()));
        negativeEffectGraph.getGridLabelRenderer().setNumHorizontalLabels(3); // only 4 because of the space

        negativeEffectGraph.getGridLabelRenderer().setNumVerticalLabels(2);

// set manual x bounds to have nice steps
        negativeEffectGraph.getViewport().setMinX(d1.getTime());
        negativeEffectGraph.getViewport().setMaxX(d3.getTime());
        negativeEffectGraph.getViewport().setXAxisBoundsManual(true);

        negativeEffectGraph.getGridLabelRenderer().setHumanRounding(false);

        StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(negativeEffectGraph);
        staticLabelsFormatter.setVerticalLabels(new String[] {"Calm", "Fearful"});
        staticLabelsFormatter.setHorizontalLabels(new String[] {df.format(d1.getTime()), df.format(d2.getTime()), df.format(d3.getTime())});
        negativeEffectGraph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);

    }

    public void makeDatesAppearOnEngagementGraph(){

        Calendar calendar = Calendar.getInstance();
        Date d1 =  calendar.getTime();
        calendar.add(Calendar.DATE, 1);
        Date d2 =  calendar.getTime();
        calendar.add(Calendar.DATE, 1);
        Date d3 = calendar.getTime();

        engagementGraph = (GraphView) rootView.findViewById(R.id.engagement_graph);
        engagementGraph.getViewport().setScrollable(true); // enables horizontal scrolling

        engagementGraph.getViewport().setMinY(0);
        engagementGraph.getViewport().setMaxY(1);
        engagementGraph.getViewport().setYAxisBoundsManual(true);




// you can directly pass Date objects to DataPoint-Constructor
// this will convert the Date to double via Date#getTime()
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(d1, 0),
                new DataPoint(d2, 0),
                new DataPoint(d3, 1)
        });

        series.setDrawBackground(true);

        engagementGraph.addSeries(series);
        engagementGraph.getGridLabelRenderer().setNumVerticalLabels(2);

// set date label formatter
        engagementGraph.getGridLabelRenderer().setLabelFormatter(new DateAsXAxisLabelFormatter(getActivity()));
        engagementGraph.getGridLabelRenderer().setNumHorizontalLabels(3); // only 4 because of the space

// set manual x bounds to have nice steps
        engagementGraph.getViewport().setMinX(d1.getTime());
        engagementGraph.getViewport().setMaxX(d3.getTime());
        engagementGraph.getViewport().setXAxisBoundsManual(true);

        engagementGraph.getGridLabelRenderer().setHumanRounding(false);

        StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(engagementGraph);
        staticLabelsFormatter.setVerticalLabels(new String[] {"Still", "Surprised"});
        staticLabelsFormatter.setHorizontalLabels(new String[] {df.format(d1.getTime()), df.format(d2.getTime()), df.format(d3.getTime())});
        engagementGraph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);

    }

    public void makeDatesAppearOnPleasantnessEffectGraph(){

        Calendar calendar = Calendar.getInstance();
        Date d1 =  calendar.getTime();
        calendar.add(Calendar.DATE, 1);
        Date d2 =  calendar.getTime();
        calendar.add(Calendar.DATE, 1);
        Date d3 = calendar.getTime();

        pleasantnessGraph = (GraphView) rootView.findViewById(R.id.pleasantness_graph);
        pleasantnessGraph.getViewport().setScrollable(true); // enables horizontal scrolling


        pleasantnessGraph.getViewport().setMinY(0);
        pleasantnessGraph.getViewport().setMaxY(1);
        pleasantnessGraph.getViewport().setYAxisBoundsManual(true);


// you can directly pass Date objects to DataPoint-Constructor
// this will convert the Date to double via Date#getTime()
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(d1, 1),
                new DataPoint(d2, 0),
                new DataPoint(d3, 0)
        });




        series.setDrawBackground(true);

        pleasantnessGraph.addSeries(series);


// set date label formatter
        pleasantnessGraph.getGridLabelRenderer().setLabelFormatter(new DateAsXAxisLabelFormatter(getActivity()));
        pleasantnessGraph.getGridLabelRenderer().setNumHorizontalLabels(3); // only 4 because of the space

        pleasantnessGraph.getGridLabelRenderer().setNumVerticalLabels(2);


// set manual x bounds to have nice steps
        pleasantnessGraph.getViewport().setMinX(d1.getTime());
        pleasantnessGraph.getViewport().setMaxX(d3.getTime());
        pleasantnessGraph.getViewport().setXAxisBoundsManual(true);

        pleasantnessGraph.getGridLabelRenderer().setHumanRounding(false);

        StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(pleasantnessGraph);
        staticLabelsFormatter.setVerticalLabels(new String[] {"Unhappy", "Satisfied"});
        staticLabelsFormatter.setHorizontalLabels(new String[] {df.format(d1.getTime()), df.format(d2.getTime()), df.format(d3.getTime())});
        pleasantnessGraph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);

        //pleasantnessGraph.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter(new DateAsXAxisLabelFormatter(getActivity()), staticLabelsFormatter));

    }
}
