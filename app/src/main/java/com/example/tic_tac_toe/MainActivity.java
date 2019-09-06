package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView B1,B2,B3,B4,B5,B6,B7,B8,B9,x_score,o_score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


         B1 = findViewById(R.id.b1);
         B2 = findViewById(R.id.b2);
         B3 = findViewById(R.id.b3);
         B4 = findViewById(R.id.b4);
         B5 = findViewById(R.id.b5);
         B6 = findViewById(R.id.b6);
         B7 = findViewById(R.id.b7);
         B8 = findViewById(R.id.b8);
         B9 = findViewById(R.id.b9);
         x_score = findViewById(R.id.X_score);
         o_score = findViewById(R.id.O_score);



    }

    @Override
    protected void onResume() {
        super.onResume();

        Toast.makeText(this, "X play first", Toast.LENGTH_LONG).show();

    }

    int round=1;
    boolean finish=false;
    int x=0;
    public void onRestartClick(View view)
    {
        Button mybtn=((Button) view);
        B1.setText("");
        B2.setText("");
        B3.setText("");
        B4.setText("");
        B5.setText("");
        B6.setText("");
        B7.setText("");
        B8.setText("");
        B9.setText("");
        round=1;
        finish=false;


    }

    public void onPlay(View view)
    {

        TextView Mytv=((TextView) view);
        String val =Mytv.getText().toString();

        if(val.isEmpty() && finish==false )
        {
            if (round % 2 == 0) {
                Mytv.setTextColor(this.getResources().getColor(R.color.txt_clr));
                Mytv.setText("O");
                if(checkWininng()) {
                    Toast.makeText(this, "Player O Won ", Toast.LENGTH_SHORT).show();
                    increment_o_score();
                }
                else
                 round++;
            }

            else {
                Mytv.setTextColor(this.getResources().getColor(R.color.colorPrimaryDark));
                Mytv.setText("X");
                if(checkWininng()) {
                    Toast.makeText(this, "Player X Won ", Toast.LENGTH_SHORT).show();
                    increment_x_score();
                }
                else
                    round++;
            }
        }

        else if(finish)
            Toast.makeText(this, "Game has ended , Restart to play again", Toast.LENGTH_SHORT).show();
        else
            {
                return;
            }
    }

    private void increment_x_score()
    {
        String x = x_score.getText().toString();
        int score = Integer.parseInt(x);
        score++;
        x=""+score;
        x_score.setText(x);
    }

    public void increment_o_score()
    {
        String o = o_score.getText().toString();
        int score = Integer.parseInt(o);
        score++;
        o=""+score;
        o_score.setText(o);
    }


    public Boolean checkWininng()
    {
        String Box1=B1.getText().toString();
        String Box2=B2.getText().toString();
        String Box3=B3.getText().toString();
        String Box4=B4.getText().toString();
        String Box5=B5.getText().toString();
        String Box6=B6.getText().toString();
        String Box7=B7.getText().toString();
        String Box8=B8.getText().toString();
        String Box9=B9.getText().toString();


        boolean win=false;

        if(Box1.equals(Box2) && Box1.equals(Box3) && Box1!="" )
        {
            win=true;
            finish=true;
        }
        else if(Box4.equals(Box5) && Box4.equals(Box6) && Box4!="")
        {
            win=true;
            finish=true;
        }
        else if(Box7.equals(Box8) && Box7.equals(Box9)  && Box7!="")
        {
            win=true;
            finish=true;
        }

        else if(Box1.equals(Box4) && Box1.equals(Box7)  && Box1!="")
        {
            win=true;
            finish=true;
        }
        else if(Box2.equals(Box5) && Box2.equals(Box8)  && Box2!="")
        {
            win=true;
            finish=true;
        }
        else if(Box3.equals(Box6) && Box3.equals(Box9)  && Box3!="")
        {
            win=true;
            finish=true;
        }

        else if(Box1.equals(Box5) && Box1.equals(Box9)  && Box1!="")
        {
            win=true;
            finish=true;
        }
        else if(Box3.equals(Box5) && Box3.equals(Box7) && Box3!="")
        {
            win=true;
            finish=true;
        }


        else
            win=false;

        return win;

    }


}
