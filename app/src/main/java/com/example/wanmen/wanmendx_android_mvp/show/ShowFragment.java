package com.example.wanmen.wanmendx_android_mvp.show;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wanmen.wanmendx_android_mvp.R;
import com.example.wanmen.wanmendx_android_mvp.data.WanmenData;
import com.example.wanmen.wanmendx_android_mvp.recycler.ShowAdapter;
import com.trello.rxlifecycle.components.support.RxFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/** Created by yangyi on 2017/4/12. */
public class ShowFragment extends RxFragment implements ShowContract.View {

    @BindView(R.id.arguments)
    TextView arguments;

    @BindView(R.id.showRecyclerView)
    RecyclerView showRecyclerView;

    private static final String SHOWFRAGMENT = "ShowFragment";

    private String msg;

    private Unbinder unbinder;

    private ShowContract.Presenter presenter;

    private AlertDialog alertDialog;

    public static ShowFragment newInstance(String msg) {
        ShowFragment showFragment = new ShowFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(SHOWFRAGMENT, msg);
        showFragment.setArguments(bundle);
        return showFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            msg = (String) getArguments().getSerializable(SHOWFRAGMENT);
        }
    }

    @Nullable
    @Override
    public View onCreateView(
            LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.mvp_show, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initView();
    }

    //测试是否顺利接参
    public void initView() {
        arguments.setText(msg);
    }

    @Override
    public void onResume() {
        super.onResume();

        presenter.subscribe();
    }

    @Override
    public void onPause() {
        super.onPause();

        presenter.unsubscribe();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        unbinder.unbind();
    }

    @Override
    public void showLoading() {
        alertDialog =
                new AlertDialog.Builder(getActivity())
                        .setTitle("等待中...")
                        .setMessage("稍安勿躁...")
                        .setCancelable(false)
                        .create();
        alertDialog.show();
    }

    @Override
    public void showRecycler(List<WanmenData> wanmenDataList) {
        ShowAdapter showAdapter = new ShowAdapter(R.layout.mvp_show_item, wanmenDataList);
        showRecyclerView.setLayoutManager(
                new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        showRecyclerView.setAdapter(showAdapter);
    }

    @Override
    public void hideLoading() {
        alertDialog.hide();
    }

    @Override
    public void setPresenter(ShowContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
