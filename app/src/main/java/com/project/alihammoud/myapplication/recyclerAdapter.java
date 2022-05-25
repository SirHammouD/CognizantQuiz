package com.project.alihammoud.myapplication;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.ViewHolder>{

    List<data> data;
    Context context;
    int count;
    String correctAnswer = "";

    public recyclerAdapter(List<data> data, Context context, int count) {
        notifyDataSetChanged();
        this.data = data;
        this.context = context;
        this.count = count;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem, parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        data options = data.get(count);
        String answer = options.getAnswer();

      holder.answer1.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              correctAnswer = holder.answer1.getText().toString();
              toast(answer);

          }
      });

        holder.answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correctAnswer = holder.answer2.getText().toString();
                toast(answer);
            }
        });

        holder.answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correctAnswer = holder.answer3.getText().toString();
                toast(answer);
            }
        });

        holder.answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correctAnswer = holder.answer4.getText().toString();
                toast(answer);
            }
        });
        holder.title.setText(options.getTitle());
        holder.answer1.setText(options.getOptions().get(0));
        holder.answer2.setText(options.getOptions().get(1));
        holder.answer3.setText(options.getOptions().get(2));
        holder.answer4.setText(options.getOptions().get(3));




    }


    @Override
    public int getItemCount() {
        return 1;
    }
    public void toast(String answer){
        if (answer.equals(correctAnswer)){
            Toast.makeText(context, correctAnswer + " is the correct choice!", Toast.LENGTH_SHORT).show();
        }
        else if (!answer.equals("")) {
            Toast.makeText(context, correctAnswer + " is the wrong choice!", Toast.LENGTH_SHORT).show();
        }
    }

    public static class ViewHolder extends  RecyclerView.ViewHolder {
        TextView answer1,answer2, answer3, answer4, title;
        Button next;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            answer1 = itemView.findViewById(R.id.answer1);
            answer2 = itemView.findViewById(R.id.answer2);
            answer3 = itemView.findViewById(R.id.answer3);
            answer4 = itemView.findViewById(R.id.answer4);
            next = itemView.findViewById(R.id.button);

        }


    }


}
