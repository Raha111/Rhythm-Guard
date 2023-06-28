package com.example.rhythym_guard;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.HashMap;
import java.util.Map;

public class MainAdapter extends FirebaseRecyclerAdapter<MainModel,MainAdapter.myViewHolder> {
    private String name;
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public MainAdapter(@NonNull FirebaseRecyclerOptions<MainModel> options, String name) {
        super(options);
        this.name = name;
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull MainModel model) {
        holder.rate1.setText(model.getHeart_rate());
        holder.tm1.setText(model.getTime());
        holder.d_pres1.setText(model.getDiastolic_pressure());
        holder.dt1.setText(model.getDate());
        holder.s_pres1.setText(model.getSystolic_pressure());
        holder.comment.setText(model.getComment());

        holder.btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DialogPlus dialogPlus = DialogPlus.newDialog(holder.rate1.getContext())
                        .setContentHolder(new ViewHolder(R.layout.update_popup))
                        .setExpanded(true, 1400)
                        .create();

                View view1 = dialogPlus.getHolderView();
                EditText ss1 = view1.findViewById(R.id.ss1);
                EditText ht1 = view1.findViewById(R.id.ht1);
                EditText dd1 = view1.findViewById(R.id.dd1);
                EditText cm1 = view1.findViewById(R.id.cm1);
                Button btnupdate = view1.findViewById(R.id.btnupdate);

                ss1.setText(model.getSystolic_pressure());
                ht1.setText(model.getHeart_rate());
                dd1.setText(model.getDiastolic_pressure());
                cm1.setText(model.getComment());
                dialogPlus.show();

                btnupdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Map<String, Object> map = new HashMap<>();
                        map.put("heart_rate", ht1.getText().toString());
                        map.put("systolic_pressure", ss1.getText().toString());
                        map.put("diastolic_pressure", dd1.getText().toString());
                        map.put("comment", cm1.getText().toString());

                        FirebaseDatabase.getInstance().getReference()
                                .child("info")
                                .child(name)
                                .child(getRef(holder.getAdapterPosition()).getKey())
                                .updateChildren(map)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Toast.makeText(holder.rate1.getContext(), "Data Updated Successfully", Toast.LENGTH_SHORT).show();
                                        dialogPlus.dismiss();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(Exception e) {
                                        Toast.makeText(holder.rate1.getContext(), "Error While Updating", Toast.LENGTH_SHORT).show();
                                        dialogPlus.dismiss();
                                    }
                                });

                    }
                });
            }
        });
        holder.btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(holder.rate1.getContext());
                builder.setTitle("Are You Sure?");
                builder.setMessage("Deleted Data Can't be Undo");


                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        FirebaseDatabase.getInstance().getReference()
                                .child("info")
                                .child(name)
                                .child(getRef(holder.getAdapterPosition()).getKey()).removeValue();

                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(holder.rate1.getContext(), "Cancelled", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
            }
        });
    }


    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item,parent,false);
        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder{
        TextView rate1,d_pres1,s_pres1,dt1,tm1,comment;
        Button btn1,btn2;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            rate1=(TextView) itemView.findViewById(R.id.rate1);
            d_pres1=(TextView) itemView.findViewById(R.id.d_pres1);
            s_pres1=(TextView) itemView.findViewById(R.id.s_pres1);
            dt1=(TextView) itemView.findViewById(R.id.dt1);
            tm1=(TextView) itemView.findViewById(R.id.tm1);
            comment=(TextView) itemView.findViewById(R.id.comment);
            btn1=(Button) itemView.findViewById(R.id.btn1);
            btn2=(Button) itemView.findViewById(R.id.btn2);


        }
    }
}
