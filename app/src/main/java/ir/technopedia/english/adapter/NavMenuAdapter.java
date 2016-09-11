package ir.technopedia.english.adapter;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.List;

import ir.technopedia.english.R;
import ir.technopedia.english.databinding.ItemNavMenuBinding;
import ir.technopedia.english.model.NavMenuModel;

/**
 * Created by TheLoneWolf on 9/3/2016.
 */
public class NavMenuAdapter extends RecyclerView.Adapter<NavMenuAdapter.BindingHolder> {

    private List<NavMenuModel> list;

    public NavMenuAdapter(List<NavMenuModel> list) {
        this.list = list;
    }

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemNavMenuBinding postBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_nav_menu,
                parent,
                false);
        return new BindingHolder(postBinding);
    }

    @Override
    public void onBindViewHolder(BindingHolder holder, int position) {
        ItemNavMenuBinding postBinding = holder.binding;
        postBinding.setNavmodel(list.get(position));
        setAnimation(holder.itemView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setItems(List<NavMenuModel> posts) {
        this.list = posts;
        notifyDataSetChanged();
    }

    public void addItem(NavMenuModel post) {
        list.add(post);
        notifyDataSetChanged();
    }

    private void setAnimation(View viewToAnimate) {
        Animation animation = AnimationUtils.loadAnimation(viewToAnimate.getContext(), R.anim.slide_in_right);
        viewToAnimate.startAnimation(animation);
    }

    @Override
    public void onViewDetachedFromWindow(BindingHolder holder) {
        holder.clearAnimation();
        super.onViewDetachedFromWindow(holder);
    }

    @BindingAdapter("bind:imageUrl")
    public static void loadImage(ImageView imageView, int url) {
        imageView.setImageResource(url);
    }

    public static class BindingHolder extends RecyclerView.ViewHolder {
        private ItemNavMenuBinding binding;

        public BindingHolder(ItemNavMenuBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void clearAnimation() {
            this.itemView.clearAnimation();
        }
    }
}