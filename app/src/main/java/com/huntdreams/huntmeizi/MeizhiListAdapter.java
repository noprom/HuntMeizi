package com.huntdreams.huntmeizi;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.huntdreams.huntmeizi.model.Meizi;
import com.huntdreams.huntmeizi.util.ToastUtils;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by noprom on 15/6/27.
 */
public class MeizhiListAdapter extends RecyclerView.Adapter<MeizhiListAdapter.ViewHolder> {

    private List<Meizi> mList;
    private Context mContext;

    public MeizhiListAdapter(Context context, List<Meizi> list) {
        this.mList = list;
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_meizi, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Meizi meizi = mList.get(position);
        holder.meizi = meizi;
        Picasso.with(mContext).load(meizi.getUrl()).into(holder.meiziImgView);
        holder.titleView.setText(meizi.getMid());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        Meizi meizi;
        ImageView meiziImgView;
        TextView titleView;

        public ViewHolder(View itemView) {
            super(itemView);
            meiziImgView = (ImageView) itemView.findViewById(R.id.iv_meizhi);
            titleView = (TextView) itemView.findViewById(R.id.tv_title);
            meiziImgView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            // TODO
            ToastUtils.showShort("View = " + view);
        }
    }
}
