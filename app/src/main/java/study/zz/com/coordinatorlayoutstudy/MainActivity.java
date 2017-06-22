package study.zz.com.coordinatorlayoutstudy;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    List<String> strings = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        collapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.collapse_toolbar);

        //设置一些recyclerView的内容
        for(int i=0;i<60;i++){
            strings.add(i+"");
        }
        //RecyclerView必须要做的几步
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        MyAdapter mAdapter=new MyAdapter();
        recyclerView.setAdapter(mAdapter);
    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

        @Override
        public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.item,null);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyAdapter.MyViewHolder holder, int position) {
            holder.tv.setText(strings.get(position));
        }

        @Override
        public int getItemCount() {
            return strings.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder{
            AppCompatTextView tv;
            public MyViewHolder(View itemView) {
                super(itemView);
                tv = (AppCompatTextView)itemView.findViewById(R.id.item_text);
            }
        }
    }
}
