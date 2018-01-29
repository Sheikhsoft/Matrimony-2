package com.matrimony.Adapters;

/**
 * Created by SANTOSH on 09-10-2016.
 */
/*
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private ArrayList<DataModel> dataSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        TextView textViewPackage,textViewAddress,textViewEvents;
        ImageView imageViewIcon;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewName = (TextView) itemView.findViewById(R.id.textViewName);
            this.textViewAddress = (TextView) itemView.findViewById(R.id.tvAddress);
            this.textViewEvents = (TextView) itemView.findViewById(R.id.tvEvents);
            this.textViewPackage = (TextView) itemView.findViewById(R.id.tvPackage);
            this.imageViewIcon = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }

    public CustomAdapter(ArrayList<DataModel> data) {
        this.dataSet = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cards_layout, parent, false);

        view.setOnClickListener(FeedFragment.myOnClickListener);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        TextView textViewName = holder.textViewName;
        TextView textViewEvent = holder.textViewEvents;
        TextView textViewAddress = holder.textViewAddress;
        TextView textViewPackage = holder.textViewPackage;
        ImageView imageView = holder.imageViewIcon;

        textViewName.setText(dataSet.get(listPosition).getName());
        textViewAddress.setText(dataSet.get(listPosition).getAddress());
        textViewEvent.setText(dataSet.get(listPosition).getEvents());
        textViewPackage.setText(dataSet.get(listPosition).getPackages());
        imageView.setImageResource(dataSet.get(listPosition).getImage());


    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}*/
