package com.example.jsondata;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.jsondata.model.User;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<User> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        load();
    }

    private void load(){
        AsyncTask<Void, Void, String> asyncTask = new AsyncTask<Void, Void, String>(){
            @Override
            protected String doInBackground(Void... voids) {
                //return 1+"";
                return Remote.getData("https://api.github.com/users");
            }

            @Override
            protected void onPostExecute(String jsonString) {
                //super.onPostExecute(o);
                // data = 결과
                System.out.println("Hello" + jsonString);
                list = parse(jsonString);
                //Log.d("찾기", list.get(0).getLogin());
                setList();

            }
        };
        asyncTask.execute();
    }

    private  List<User> parse(String json){
        Toast.makeText(this, "하하", Toast.LENGTH_SHORT).show();
        ArrayList<User> list = new ArrayList<>();
        String first = json.substring(json.indexOf(34));
        System.out.println("=================" + "\n" + first);
        String second = first.substring(0, first.lastIndexOf(125));
        System.out.println("=================" + "\n" + second);
        String firstArray[] = second.split("\\},\\{");
        System.out.println("Insup Jung" + firstArray[0]);
        for(String s : firstArray){
            User user = new User();
            String ar[] = s.split(",");
            System.out.println(ar[0]);
            user.setLogin(ar[0].substring(ar[0].indexOf(":\"")+2, ar[0].length()-1));
            System.out.println("Insup Jung" + user.getLogin());
            user.setId(ar[1].substring(ar[1].indexOf(":")+1, ar[1].length()));
            user.setAvatar_url(ar[2].substring(ar[2].indexOf(":\"")+2, ar[2].length()-1));

            list.add(user);

        }

        return list;
    }


    private void setList(){
        MyAdapter myAdapter = new MyAdapter((ArrayList) list, this);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }
}
