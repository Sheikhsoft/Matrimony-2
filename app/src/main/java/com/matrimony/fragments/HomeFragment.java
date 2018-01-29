package com.matrimony.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.matrimony.R;

/**
 * Created by SANTOSH on 09-10-2016.
 */
public class HomeFragment extends Fragment {
    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_profile, container, false);
       /* NetworkImageView avatar = (NetworkImageView) rootView.findViewById(R.id.twitter_avatar);

        Log.d("HOME", "Home Fragment");

       // mRequestQueue = Volley.newRequestQueue(getActivity());
        mRequestQueue = VolleySingleton.getInstance().getRequestQueue();
        mImageLoader=VolleySingleton.getInstance().getImageLoader();
       *//* mImageLoader = new ImageLoader(mRequestQueue, new ImageLoader.ImageCache() {
            private final LruCache<String, Bitmap> mCache = new LruCache<String, Bitmap>(10);

            public void putBitmap(String url, Bitmap bitmap) {

                Log.d("HOME","ImageLoader putBitmap");
                mCache.put(url, bitmap);
            }

            public Bitmap getBitmap(String url) {

                Log.d("HOME","ImageLoader getBitmap");
                return mCache.get(url);
            }
        });*//*
        Log.d("HOME", "Home Fragment");
        avatar.setImageUrl("https://blog.xamarin.com/wp-content/uploads/2012/05/android-i86.png", mImageLoader);
        ImageView imageView = (ImageView) rootView.findViewById(R.id.imageView);

        Glide.with(this).load("https://blog.xamarin.com/wp-content/uploads/2012/05/android-i86.png").into(imageView);*/

        return rootView;
    }
}
