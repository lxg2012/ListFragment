package com.example.lx.listfragment;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ExpandableListView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends AppCompatActivity implements BaseQuickAdapter.OnItemClickListener {


    private RecyclerView rcy;
    private ExpandableListView epl;
    private LeftRvAdapter leftRvAdapter;
    private DepExpandaLvAdapter depExpandaLvAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcy = (RecyclerView) findViewById(R.id.rcy);
        epl = (ExpandableListView) findViewById(R.id.epl);
        leftRvAdapter = new LeftRvAdapter();
        leftRvAdapter.setNewData(new Gson().fromJson(JsonEntry.josn1, DepBean.class).data);
        depExpandaLvAdapter = new DepExpandaLvAdapter(getLayoutInflater());
        rcy.setAdapter(leftRvAdapter);
        leftRvAdapter.setOnItemClickListener(this);
        rcy.performClick();
    }

    private class LeftRvAdapter extends BaseQuickAdapter<DepBean.DepChild, BaseViewHolder> {

        private LeftRvAdapter() {
            super(R.layout.layout_item_left);
        }

        @Override
        protected void convert(BaseViewHolder helper, DepBean.DepChild item) {
            helper.setText(R.id.tv, item.deptName);
        }
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        DepBean.DepChild depChild = (DepBean.DepChild) adapter.getItem(position);
        depExpandaLvAdapter.setNewData(depChild.child.get(position));
    }

}