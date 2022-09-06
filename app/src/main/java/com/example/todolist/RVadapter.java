package com.example.todolist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todolist.databinding.EachRvBinding;

import org.jetbrains.annotations.NotNull;

import javax.security.auth.callback.Callback;

public class RVadapter extends ListAdapter<Note,RVadapter.ViewHolder> {

    public RVadapter() {
        super(CALLBACK);
    }
    private static final DiffUtil.ItemCallback<Note> CALLBACK=new DiffUtil.ItemCallback<Note>() {
        @Override
        public boolean areItemsTheSame(@NonNull @NotNull Note oldItem, @NonNull @NotNull Note newItem) {
            return oldItem.getId()== newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull @NotNull Note oldItem, @NonNull @NotNull Note newItem) {
            return oldItem.getTitle().equals(newItem.getTitle())
                    && oldItem.getDesc().equals(newItem.getDesc());
        }

    };
    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.each_rv,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
    Note note=getItem(position);
    holder.binding.titleRv.setText(note.getTitle());
    holder.binding.textRv.setText(note.getDesc());
    }
public Note getNote(int position)
{
    return getItem(position);

}
    public class ViewHolder extends RecyclerView.ViewHolder{
       EachRvBinding binding;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            binding=EachRvBinding.bind(itemView);
        }
    }
}
