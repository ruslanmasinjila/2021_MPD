package com.example.pullparser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.StringReader;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private String widgetString =
            "<WidgetCollection> " +
                    "<Widget> " +
                    "<Bolt>M8 x 100</Bolt>	" +
                    "<Nut>M8 Hex</Nut>	" +
                    "<Washer>M8 Penny Washers</Washer>	" +
                    "</Widget>" +
                    "<Widget> " +
                    "<Bolt>M8 x 150</Bolt>	" +
                    "<Nut>M8 Hex</Nut>	" +
                    "<Washer>M8 Penny Washers</Washer>	" +
                    "</Widget>" +
                    "<Widget> " +
                    "<Bolt>M6 x 100</Bolt>	" +
                    "<Nut>M6 Hex</Nut>	" +
                    "<Washer>M6 Penny Washers</Washer>	" +
                    "</Widget>" +
                    "</WidgetCollection>";

    ////////////////////////////////////////////////////////////////////////////////////////////////
    private ListView ListView_LIST;
    private ArrayAdapter arrayAdapter;
    ////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        LinkedList<WidgetClass> alist = null;
        alist = parseData(widgetString);
        ListView_LIST = findViewById(R.id.ListView_LIST);
        arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, alist);
        ListView_LIST.setAdapter(arrayAdapter);


    }

    private LinkedList<WidgetClass> parseData(String dataToParse) {
        WidgetClass widget = null;
        LinkedList<WidgetClass> alist = null;
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(new StringReader(dataToParse));
            int eventType = xpp.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                // Found a start tag
                if (eventType == XmlPullParser.START_TAG) {
                    // Check which Tag we have
                    if (xpp.getName().equalsIgnoreCase("widgetcollection")) {
                        alist = new LinkedList<WidgetClass>();
                    } else if (xpp.getName().equalsIgnoreCase("widget")) {
                        Log.e("MyTag", "Item Start Tag found");
                        widget = new WidgetClass();
                    } else if (xpp.getName().equalsIgnoreCase("bolt")) {
                        // Now just get the associated text
                        String temp = xpp.nextText();
                        // Do something with text
                        Log.e("MyTag", "Bolt is " + temp);
                        widget.setBolt(temp);
                    } else
                        // Check which Tag we have
                        if (xpp.getName().equalsIgnoreCase("Nut")) {
                            // Now just get the associated text
                            String temp = xpp.nextText();
                            // Do something with text
                            Log.e("MyTag", "Nut is " + temp);
                            widget.setNut(temp);
                        } else
                            // Check which Tag we have
                            if (xpp.getName().equalsIgnoreCase("Washer")) {
                                // Now just get the associated text
                                String temp = xpp.nextText();
                                // Do something with text
                                Log.e("MyTag", "Washer is " + temp);
                                widget.setWasher(temp);
                            }
                } else if (eventType == XmlPullParser.END_TAG) {
                    if (xpp.getName().equalsIgnoreCase("widget")) {
                        Log.e("MyTag", "widget is " + widget.toString());
                        alist.add(widget);
                    } else if (xpp.getName().equalsIgnoreCase("widgetcollection")) {
                        int size;
                        size = alist.size();
                        Log.e("MyTag", "widgetcollection size is " + size);
                    }
                }


                // Get the next event
                eventType = xpp.next();

            } // End of while


        } catch (XmlPullParserException ae1) {
            Log.e("MyTag", "Parsing error" + ae1.toString());
        } catch (IOException ae1) {
            Log.e("MyTag", "IO error during parsing");
        }

        Log.e("MyTag", "End document");

        return alist;

    }
}