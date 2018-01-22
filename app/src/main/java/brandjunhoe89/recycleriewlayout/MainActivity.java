package brandjunhoe89.recycleriewlayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    private RecyclerView recyclerView;
    private ArrayList<Item> mItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        Button linear = (Button) findViewById(R.id.linearLayout);
        Button grid = (Button) findViewById(R.id.gridLayout);
        Button staggered = (Button) findViewById(R.id.staggeredGridLayout);

        initData();

        linear.setOnClickListener(this);
        grid.setOnClickListener(this);
        staggered.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.linearLayout) {
            RecyclerAdapter adapter = new RecyclerAdapter(mItems, R.layout.row, this);
            LinearLayoutManager manager = new LinearLayoutManager(this);


            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(manager);
        }else if(view.getId() == R.id.gridLayout){

            RecyclerAdapter adapter = new RecyclerAdapter(mItems, R.layout.row, this);
            GridLayoutManager manager = new GridLayoutManager(this, 2);

            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(manager);
        }else if(view.getId() == R.id.staggeredGridLayout){
            RecyclerAdapter adapter = new RecyclerAdapter(mItems, R.layout.row, this);
            StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(manager);
        }


    }

    private void initData(){

        mItems.add(new Item(R.drawable.banana, "바나나"));
        mItems.add(new Item(R.drawable.apple, "사과"));
        mItems.add(new Item(R.drawable.podo, "포도"));


        RecyclerAdapter adapter = new RecyclerAdapter(mItems, R.layout.row, this);
        LinearLayoutManager manager = new LinearLayoutManager(this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager);
    }
}
