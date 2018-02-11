package com.aayush.listsexample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import com.aayush.listsexample.Utils.Person;
import com.bumptech.glide.Glide;

/**
 * Created by aayush on 2/10/18.
 */

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.CustomViewHolder> {
    ArrayList<Person> people;
    Context context;

    public PersonAdapter(Context context, ArrayList<Person> people) {
        this.people = people;
        this.context = context;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_view, parent,false);
        return new CustomViewHolder(view);

    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
         holder.bind(people.get(position));
    }

    @Override
    public int getItemCount() {
        return people.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView company, email, name;
        ImageView avatar;

        public CustomViewHolder(View itemView) {
            super(itemView);
            company = itemView.findViewById(R.id.company);
            email = itemView.findViewById(R.id.email);
            name = itemView.findViewById(R.id.name);
            avatar = itemView.findViewById(R.id.avatar);
        }

        void bind(Person person) {
            company.setText(person.company);
            email.setText(person.email);
            name.setText(String.format("%s %s", person.firstname, person.lastname));
            Glide.with(context).load(person.avatar).into(avatar);
        }
    }
}
