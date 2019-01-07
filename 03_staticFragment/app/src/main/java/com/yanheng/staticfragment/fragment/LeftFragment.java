package com.yanheng.staticfragment.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.yanheng.staticfragment.R;
import com.yanheng.staticfragment.util.L;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link LeftFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link LeftFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LeftFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private ArrayList<String> list;
    private ListView listView;

    public LeftFragment() {
        L.d();
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LeftFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LeftFragment newInstance(String param1, String param2) {
        L.d();
        LeftFragment fragment = new LeftFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        L.d();
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        L.d();
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        L.d();
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_left, container, false);
        listView = (ListView) view.findViewById(R.id.left_listview);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        L.d();
        initData();
        listView.setAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,list));

    }

    @Override
    public void onStart() {
        super.onStart();
        L.d();
    }

    @Override
    public void onResume() {
        super.onResume();
        L.d();
    }

    @Override
    public void onPause() {
        super.onPause();
        L.d();
    }

    @Override
    public void onStop() {
        super.onStop();
        L.d();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        L.d();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        L.d();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        L.d();
        mListener = null;
    }
    private void initData() {
        list = new ArrayList<>();
        for(int i=0;i<20;i++){
            list.add("fragment no. ="+i);
        }
    }

    // TODO: Rename method, update argument and hook method into UI event

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
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
