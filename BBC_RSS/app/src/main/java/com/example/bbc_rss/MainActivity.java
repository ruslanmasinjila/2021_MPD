package com.example.bbc_rss;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    RSSReader rssReader = new RSSReader();
    RSSParser rssParser = new RSSParser();

    private ListView ListView_LIST;
    private TextView TextView_TEXTVIEW;
    private ArrayAdapter arrayAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView_LIST = findViewById(R.id.ListView_LIST);
        TextView_TEXTVIEW = findViewById(R.id.TextView_TEXTVIEW);


        ListView_LIST.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Get the selected name
                String selectedTitle = (String)parent.getItemAtPosition(position);

                // Look for Selected Title, once found
                // Display the details of the Title in TextView_TEXTVIEW
                for(int i = 0; i < rssParser.topStoryList.size();i++)
                {
                    if(selectedTitle.equals(rssParser.topStoryList.get(i).getTitle()))
                    {
                        TextView_TEXTVIEW.setText(rssParser.topStoryList.get(i).toString());
                        break;
                        // END
                    }
                }


            }
        });

    }

    public void Refresh(View view)
    {
        asyncRefresh(view);
    }

    public void asyncRefresh(View view)
    {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        executor.execute(new Runnable() {

            @Override
            public void run() {

                ///////////////////////////////////////////////////////////////////////////////////
                // Update Top stories
                LinkedList<TopStory> topStoryList = null;

                // Fetch RSS data from BBC News
                rssReader.FetchRSS();

                // Parse the xml of the RSS into a LinkedList of Top Stories
                rssParser.parseRSSString(rssReader.getRssString());

                arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, rssParser.titleList);

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        ListView_LIST.setAdapter(arrayAdapter);
                        TextView_TEXTVIEW.setText("");

                    }
                });



            }
        });
    }




}