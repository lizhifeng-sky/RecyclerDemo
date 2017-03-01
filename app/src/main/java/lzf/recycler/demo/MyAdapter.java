package lzf.recycler.demo;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/1 0001.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Activity context;
    private List<Integer> list;
    public MyAdapter(Activity context) {
        this.context = context;
        list=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(1);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_recycler, parent, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.imageView.setImageResource(R.mipmap.ic_launcher);
        holder.bottom.setText(position+"  底部");
        if (list.get(position)==1){
            AnimatorUtils.translate(holder.imageView,0,0);
            AnimatorUtils.scale(holder.back,0,0);
        }
    }


    @Override
    public int getItemCount() {
        return 10;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        RelativeLayout back;
        TextView bottom;
        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.image);
            back= (RelativeLayout) itemView.findViewById(R.id.back);
            bottom= (TextView) itemView.findViewById(R.id.bottom);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(list.get(getAdapterPosition())==1) {
                        list.set(getAdapterPosition(),0);
                        AnimatorUtils.translate(v, -150,1000);
                        AnimatorUtils.scale(back, 1.2f,1000);
                    }else {
                        NextActivity.launch((AppCompatActivity) context,imageView,list.get(getAdapterPosition()));
                    }
                }
            });
        }
    }
}
