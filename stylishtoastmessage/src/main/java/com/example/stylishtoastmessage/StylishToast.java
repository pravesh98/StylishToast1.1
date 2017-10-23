package com.example.stylishtoastmessage;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.IntDef;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Admin on 10/23/2017.
 */

public class StylishToast extends Toast {


    @IntDef({LENGTH_SHORT,LENGTH_LONG})
    public @interface Duration{}
    public static final int LENGTH_LONG=Toast.LENGTH_LONG;
    public static final int LENGTH_SHORT=Toast.LENGTH_SHORT;

    @IntDef({DEFAULT,SUCCESS,ERROR,WARNING,STATUS})
    public @interface MessageCode{}
    public static final int DEFAULT=1;
    public static final int SUCCESS=2;
    public static final int ERROR=3;
    public static final int WARNING=4;
    public static final int STATUS=5;

    @IntDef({CUSTOM})
    public @interface MessageCodeCustom{}
    public static final int CUSTOM=0;

    public StylishToast(Context context) {
        super(context);
    }

    public static Toast makeText(Context context, String message,@Duration int duration,@MessageCode int type)
    {
        GradientDrawable gradientDrawable=new GradientDrawable();
        gradientDrawable.setCornerRadius(50);
        Toast toast=new Toast(context);
        toast.setDuration(duration);
        View layout= LayoutInflater.from(context).inflate(R.layout.toast_layout,null,false);
        TextView textView=(TextView) layout.findViewById(R.id.message);
        ImageView imageView=(ImageView)layout.findViewById(R.id.toastIcon);
        switch (type)
        {
            case ERROR:
                imageView.setImageResource(R.drawable.error);
                gradientDrawable.setColor(Color.RED);
                break;
            case SUCCESS:
                imageView.setImageResource(R.drawable.success);
                gradientDrawable.setColor(Color.parseColor("#008000"));
                break;
            case STATUS:
                imageView.setImageResource(R.drawable.status);
                gradientDrawable.setColor(Color.parseColor("#CC0066"));
                break;
            case WARNING:
                imageView.setImageResource(R.drawable.warning);
                gradientDrawable.setColor(Color.parseColor("#ff8000"));
                break;
            default:break;
        }
        layout.setBackground(gradientDrawable);
        textView.setText(message);
        toast.setView(layout);
        return toast;
    }

    public static Toast makeText(Context context,String message,@Duration int duration,@MessageCodeCustom int type,int imageId)
    {
        GradientDrawable gradientDrawable=new GradientDrawable();
        gradientDrawable.setCornerRadius(50);
        gradientDrawable.setColor(Color.BLACK);
        Toast toast=new Toast(context);
        toast.setDuration(duration);
        View layout= LayoutInflater.from(context).inflate(R.layout.toast_layout,null,false);
        TextView textView=(TextView) layout.findViewById(R.id.message);
        ImageView imageView=(ImageView)layout.findViewById(R.id.toastIcon);
        textView.setText(message);
        imageView.setImageResource(imageId);
        layout.setBackground(gradientDrawable);
        toast.setView(layout);
        return toast;
    }

}
