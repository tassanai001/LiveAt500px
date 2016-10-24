package com.example.tassanai.onlinecourse.liveat500px.adapter;

import android.graphics.drawable.Animatable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tassanai.onlinecourse.liveat500px.R;
import com.example.tassanai.onlinecourse.liveat500px.dao.PhotoItemCollectionDao;
import com.example.tassanai.onlinecourse.liveat500px.dao.PhotoItemDao;
import com.example.tassanai.onlinecourse.liveat500px.manager.PhotoListManager;
import com.example.tassanai.onlinecourse.liveat500px.view.PhotoListItem;

/**
 * Created by Tassanai on 10/16/2016.
 */
public class PhotoListAdapter extends BaseAdapter {

    PhotoItemCollectionDao dao;
    int lastPosition = -1;

    public void setDao(PhotoItemCollectionDao dao) {
        this.dao = dao;
    }

    @Override
    public int getCount() {
        if (dao == null)
            return 0;
        if (dao.getData() == null)
            return 0;
        return dao.getData().size();
    }

    @Override
    public Object getItem(int position) {
        return dao.getData().get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    //---- SinglewListViewType
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PhotoListItem item;
        if (convertView != null)
            item = (PhotoListItem) convertView;
        else
            item = new PhotoListItem(parent.getContext());

        PhotoItemDao dao = (PhotoItemDao) getItem(position);
        item.setNameText(dao.getCaption());
        item.setDescription(dao.getUsername() + "\n" + dao.getCamera());
        item.setImageUrl(dao.getImageUrl());

        if (position > lastPosition) {
            Animation anim = AnimationUtils.loadAnimation(parent.getContext(),
                    R.anim.up_from_bottom);
            item.startAnimation(anim);
            lastPosition = position;
        }

        return item;
    }

    //---- MultiListViewType...
//    @Override
//    public int getViewTypeCount() {
//        return 2;
//    }
//
//    @Override
//    public int getItemViewType(int position) {
//        return position % 2 == 0 ? 0 : 1;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        if (getItemViewType(position) == 0) {
//            PhotoListItem item;
//            if (convertView != null) {
//                item = (PhotoListItem) convertView;
//            } else {
//                item = new PhotoListItem(parent.getContext());
//            }
//            return item;
//        } else {
//            TextView item;
//            if (convertView != null) {
//                item = (TextView) convertView;
//            } else {
//                item = new TextView(parent.getContext());
//            }
//            item.setText("Position: " + position);
//            return item;
//        }
//    }
}
