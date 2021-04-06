package com.example.kidmath;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.luolc.emojirain.EmojiRainLayout;

public class ShowEmojiActivity extends AppCompatActivity {

    int total=0;
    TextView tvTotalDisplay;
    ImageView ivEmoji;
    EmojiRainLayout mContainer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_emoji);
        total=Integer.parseInt(getIntent().getStringExtra("total"));
        init();
        showEmoji();
    }

    private void init() {
        tvTotalDisplay=findViewById(R.id.tvTotalDisplay);
        ivEmoji=findViewById(R.id.ivEmoji);
    }

    private void showEmoji(){
        if(total>=6){
            ivEmoji.setVisibility(View.VISIBLE);
            tvTotalDisplay.setVisibility(View.VISIBLE);
            tvTotalDisplay.setText("Congrtulation you got result  "+total);
            getAnimation();
        }
        else {
            ivEmoji.setImageDrawable(getResources().getDrawable(R.drawable.sad));
            ivEmoji.setVisibility(View.VISIBLE);
            tvTotalDisplay.setVisibility(View.VISIBLE);
            tvTotalDisplay.setText("OPS! better luck for next time  "+total);
        }

    }
    private void getAnimation(){
        mContainer = (EmojiRainLayout) findViewById(R.id.group_emoji_container);

        // add emoji sources
        mContainer.addEmoji(R.drawable.smily);
        mContainer.addEmoji(R.drawable.star);
        mContainer.addEmoji(R.drawable.chokolate);
        mContainer.addEmoji(R.drawable.emoji_4_3);
        mContainer.addEmoji(R.drawable.emoji_5_3);

        // set emojis per flow, default 6
        mContainer.setPer(10);

        // set total duration in milliseconds, default 8000
        mContainer.setDuration(7200);

        // set average drop duration in milliseconds, default 2400
        mContainer.setDropDuration(2400);

        // set drop frequency in milliseconds, default 500
        mContainer.setDropFrequency(500);
        mContainer.startDropping();

    }
}
