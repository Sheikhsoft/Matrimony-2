package com.matrimony.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.matrimony.Activity.ProfileDetailsActivity;
import com.matrimony.R;


/**
 * Created by SANTOSH on 09-10-2016.
 */
public class MatchFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        RecyclerView recyclerView = (RecyclerView) inflater.inflate(
                R.layout.recycler_view, container, false);
        ContentAdapter adapter = new ContentAdapter(recyclerView.getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return recyclerView;

    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView picture;
        public TextView name;
        public TextView description;
        public TextView address,packages;

        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_card, parent, false));
            picture = (ImageView) itemView.findViewById(R.id.card_image);
            name = (TextView) itemView.findViewById(R.id.card_title);
            description = (TextView) itemView.findViewById(R.id.tvEvents);
            address = (TextView) itemView.findViewById(R.id.tvAddress);
            packages= (TextView) itemView.findViewById(R.id.tvPackage);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, ProfileDetailsActivity.class);
                    context.startActivity(intent);
                }
            });
        }
    }
    /**
     * Adapter to display recycler view.
     */
    public static class ContentAdapter extends RecyclerView.Adapter<ViewHolder> {
        // Set numbers of List in RecyclerView.
        private static final int LENGTH = 18;
        private final String[] mPlaces;
        private final String[] mPlaceDesc;
        private final String[] mPackages;
        private final String[] mAddress;
        private final Drawable[] mPlacePictures;
        private final String[] urlPictures;
        private Context mContext;
        public ContentAdapter(Context context) {
            mContext=context;
            Resources resources = context.getResources();
            mPlaces = resources.getStringArray(R.array.places);
            mPlaceDesc = resources.getStringArray(R.array.event_desc);
            mPackages=resources.getStringArray(R.array.package_desc);
            mAddress=resources.getStringArray(R.array.place_locations);
            TypedArray a = resources.obtainTypedArray(R.array.places_picture);
            mPlacePictures = new Drawable[a.length()];
            urlPictures=resources.getStringArray(R.array.url_picture);
            for (int i = 0; i < mPlacePictures.length; i++) {
                mPlacePictures[i] = a.getDrawable(i);
            }
            a.recycle();
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
           holder.picture.setImageDrawable(mPlacePictures[position % mPlacePictures.length]);
            //Glide.with(mContext).load(urlPictures[position % mPlaces.length]).into(holder.picture);
            //Log.d("URL---->",""+urlPictures[position % mPlaces.length]);
            //holder.picture.setImageDrawable(mPlacePictures[position % mPlacePictures.length]);
            holder.name.setText(mPlaces[position % mPlaces.length]);
            holder.description.setText(mPlaceDesc[position % mPlaceDesc.length]);
            holder.address.setText(mAddress[position % mAddress.length]);
            holder.packages.setText(mPackages[position % mPackages.length]);
        }

        @Override
        public int getItemCount() {
            return LENGTH;
        }
    }
}
