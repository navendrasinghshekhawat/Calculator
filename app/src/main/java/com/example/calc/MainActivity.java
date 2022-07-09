package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.SuperscriptSpan;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//math library for expression handling
import org.mariuszgromada.math.mxparser.Expression;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    //Button variables and Edit Text Variables
    Button equalsTo;
    EditText etExpression,et1; //for portrait mode
    EditText etLandscape;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setting id for portrait mode
        etExpression=findViewById(R.id.et1);
        et1=findViewById(R.id.et2);
        equalsTo=findViewById(R.id.equalsTo);
        equalsTo.setOnClickListener(this);




//-------------------------------------------------------------------------------
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//--------Logic to make SuperScript font in buttons------------------
//        SpannableString xsquare = new SpannableString("X2");
//        xsquare.setSpan(new SuperscriptSpan(), 1, 2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//        squared.setText(xsquare);
//

//------------------------------------------------------------------
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    }

    //-----------Logical part for portrait mode------------------------------
    public void solve(View view) {
       String value=et1.getText().toString();
       switch (view.getId()){
           case R.id.one:
               et1.setText(value+"1");
               break;
           case R.id.two:
               et1.setText(value+"2");
               break;
           case R.id.three:
               et1.setText(value+"3");
               break;
           case R.id.four:
               et1.setText(value+"4");
               break;
           case R.id.five:
               et1.setText(value+"5");
               break;
           case R.id.six:
               et1.setText(value+"6");
               break;
           case R.id.seven:
               et1.setText(value+"7");
               break;
           case R.id.eight:
               et1.setText(value+"8");
               break;
           case R.id.nine:
               et1.setText(value+"9");
               break;
           case R.id.zero:
               et1.setText(value+"0");
               break;
           case R.id.dot:
               et1.setText(value+".");
               break;
           case R.id.add:
               et1.setText(value+"+");
               break;
           case R.id.minus:
               et1.setText(value+"-");
               break;
           case R.id.multiply:
               et1.setText(value+"*");
               break;
           case R.id.divide:
               et1.setText(value+"/");
               break;
           case R.id.ac:
               et1.setText(null);
               etExpression.setText(null);
               break;
           case R.id.percent:
               et1.setText(value+"%");
               break;
           case R.id.bracketOpen:
               et1.setText(value+"(");
               break;
           case R.id.bracketClose:
               et1.setText(value+")");
               break;
       }
    }

    //code for solving expression....embedded into equalsTo button for portrait mode
    @Override
    public void onClick(View v) {

        if(et1.getText().toString().matches("")){
            Toast.makeText(MainActivity.this, "Enter Something to Calculate", Toast.LENGTH_SHORT).show();
        } else{
            String val=et1.getText().toString();
            Expression e = new Expression(val);
            double answer= e.calculate();
            String ans= String.valueOf(answer);
            if(ans.equals("NaN")) {
                et1.setText("Expression_Error");
            }else {
                et1.setText(ans);
                etExpression.setText(val);
                System.out.println(ans);
            }

    }
    }
    //------------portrait mode code complete-----------------------------
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


}