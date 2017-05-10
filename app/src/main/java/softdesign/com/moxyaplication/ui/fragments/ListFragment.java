package softdesign.com.moxyaplication.ui.fragments;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import softdesign.com.moxyaplication.R;
import softdesign.com.moxyaplication.mvp.models.intities.Contractor;
import softdesign.com.moxyaplication.mvp.view.ListView;
import softdesign.com.moxyaplication.mvp.presenters.ListPresenter;
import softdesign.com.moxyaplication.ui.adapters.RecyclerAdapter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.List;


public class ListFragment extends MvpFragment implements ListView {
    public static final String TAG = "ListFragment";

    @InjectPresenter
    ListPresenter mListPresenter;


    @BindView(R.id.my_recycler_view)
    RecyclerView mRecyclerView;

    @BindView(R.id.message_tv_listfragment)
    TextView tvMessage;

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;



    public static ListFragment newInstance() {
        ListFragment fragment = new ListFragment();

        Bundle args = new Bundle();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_list, container, false);

        ButterKnife.bind(this, view);

        initRcycledView();

        return view;
    }


    void initRcycledView(){
        mRecyclerView.setHasFixedSize(true);
        // используем linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        // создаем адаптер
    }

    @OnClick(R.id.message_tv_listfragment)
    public void clickFragment(){
        mListPresenter.click();
    }

    @Override
    public void onViewCreated(final View view, final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void showMessage(String mess) {
        tvMessage.setText(mess);
    }

    @Override
    public void showlist() {
        mAdapter = new RecyclerAdapter(mListPresenter.getContractors());
        mRecyclerView.setAdapter(mAdapter);
    }
}
