package com.example.sriram.dalalstreet;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.jar.Attributes;

/**
 * Created by sriram on 17/2/16.
 */
public class Transaction_list_adapter extends ArrayAdapter<String>{

    static Context context;
    ArrayList<String> Names=new ArrayList<>();
    ArrayList<String> Current_Price=new ArrayList<>();
    ArrayList<String> Stocks_worth=new ArrayList<>();
    ArrayList<Integer> Stocks_bought=new ArrayList<>();
    ArrayList<Integer> updown=new ArrayList<>();

    public Transaction_list_adapter(Context context2,
                                    ArrayList<String> names_args,ArrayList<String> current,
                                    ArrayList<Integer> stocks_bought,
                                    ArrayList<String> stocks_worth,ArrayList<Integer> updown_args) {
        super(context2,-1,names_args);
        context=context2;
        Names=names_args;
        Current_Price=current;
        Stocks_bought=stocks_bought;
        Stocks_worth=stocks_worth;
        updown=updown_args;
        Log.d("trans adapter", "Names" + Names);


    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.transaction_item, parent, false);

        TextView textView_Names = (TextView) rowView.findViewById(R.id.stock_Name_transaction);
        TextViewWithImages textView_Current = (TextViewWithImages) rowView.findViewById(R.id.current_transaction);
        TextView textView_Stocks_bought=(TextView) rowView.findViewById(R.id.stock_bought_transaction);
        TextView textView_Stocks_worth=(TextView) rowView.findViewById(R.id.stock_worth_transaction);

        textView_Names.setText(Names.get(position));
        if(updown.get(position)==1) {
            textView_Current.setText("Current Price: " + Current_Price.get(position)+"[img src=green/]");
        }
        else if(updown.get(position)==0){
            textView_Current.setText("Current Price: " + Current_Price.get(position)+"[img src=red/]");
        }
        textView_Stocks_bought.setText("Stocks bought: "+Stocks_bought.get(position).toString());
        textView_Stocks_worth.setText("Stocks worth:" +Stocks_worth.get(position));
        return rowView;
    }




}
