package com.example.propertyanimationexercise;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends Activity {


    private List<String> list;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);

        String[] stringArray = getResources().getStringArray(R.array.animation_list);
        list = Arrays.asList(stringArray);
        RecyclerView animation = findViewById(R.id.animation_list);

        System.out.println(list.size());
        LinearLayoutManager  layoutManager = new LinearLayoutManager(this);
        animation.setLayoutManager(layoutManager);

        AnimationListAdapter animationListAdapter = new AnimationListAdapter();
        animation.setAdapter(animationListAdapter);
        if(list!= null) {
            animationListAdapter.setList(list);
            animationListAdapter.notifyDataSetChanged();
        }

    }

    private class AnimationListAdapter extends RecyclerView.Adapter<AnimationListViewHolder> {

        private List<String> animationList;


        void setList(List<String> animationList) {
            this.animationList = animationList;
        }

        void addAnimationToList(String name) {
            this.animationList.add(name);
            notifyDataSetChanged();
        }

        @NonNull
        @Override
        public AnimationListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            final View view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.recycleview_content, viewGroup, false);
            return new AnimationListViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull AnimationListViewHolder animationListViewHolder, int i) {
            System.out.print(animationList.get(i));
            animationListViewHolder.textView.setText(animationList.get(i));
        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }

    private class AnimationListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView textView;

        public AnimationListViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.animation_text_name);
            textView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Toast toast = Toast.makeText(getApplicationContext(), textView.getText(), Toast.LENGTH_LONG);
            toast.show();
        }
    }

}
