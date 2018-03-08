package com.example.lx.listfragment;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.lx.listfragment.DepBean.DepChild;

/**
 * @author LX
 * @date 2017/12/22
 */

public class DepExpandaLvAdapter extends BaseExpandableListAdapter {

    private LayoutInflater inflater;
    private DepChild depChild;

    public DepExpandaLvAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    public void setNewData(@Nullable DepChild depChild) {
        this.depChild = depChild;
        notifyDataSetChanged();
    }

    @Override
    public int getGroupCount() {
        return depChild.child.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return depChild.child.get(groupPosition).child.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return depChild.child.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return depChild.child.get(groupPosition).child.get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.layout_item_child, parent, false);
        }
        DepChild depChild = (DepChild) getGroup(groupPosition);
        TextView textView = convertView.findViewById(R.id.tv_child);
        textView.setText(depChild.deptName);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.layout_item_child, parent, false);
        }
        DepChild depChild = (DepChild) getChild(groupPosition, childPosition);
        TextView textView = convertView.findViewById(R.id.tv_child);
        textView.setTextSize(12);
        textView.setText(depChild.deptName);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
