package com.meitu.sww.commonlistdialog.common;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.meitu.sww.commonlistdialog.common.model.FeedbackItemModel;

import java.util.List;

/**
 * 负反馈弹窗是适配器
 * @author ShaoWenWen
 * @date 2019-07-08
 */
public class FeedbackAdapter extends RecyclerView.Adapter<FeedbackAdapter.Holder> {

    private List<FeedbackItemModel> itemList;
    private OnItemClickListener onItemClickListener;

    public FeedbackAdapter(List<FeedbackItemModel> itemList) {
        this.itemList = itemList;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new Holder(new FeedbackItemView(viewGroup.getContext()));
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, @SuppressLint("RecyclerView") final int position) {
        ((FeedbackItemView) holder.itemView).updateViewByData(itemList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) onItemClickListener.onItemClick(itemList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList == null ? 0 : itemList.size();
    }

    static class Holder extends RecyclerView.ViewHolder {
        Holder(View itemView) {
            super(itemView);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(FeedbackItemModel feedbackItemModel);
    }

}
