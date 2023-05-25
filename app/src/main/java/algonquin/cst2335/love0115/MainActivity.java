package algonquin.cst2335.love0115;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import algonquin.cst2335.love0115.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private MainViewmodel model;
    private ActivityMainBinding variableBinding;
    private ViewModelProvider viewModelProvider;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model = new ViewModelProvider(this).get(MainViewmodel.class);

        variableBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(variableBinding.getRoot());//loads XML on screen


        TextView theText=variableBinding.textview;
        Button myButton= variableBinding.buttonId;
        ImageButton myImageButton = variableBinding.myimagebutton;


        model.editString.observe(this,s -> {
            variableBinding.textview.setText("Your edit text has "+s);

        });


        variableBinding.buttonId.setOnClickListener(click -> {
            model.editString.postValue(variableBinding.myedittext.getText().toString());
            // model.editString = variableBinding.myedittext.getText().toString();
            // variableBinding.textview.setText("Your edit has:" + model.editString);
        });

//show a toast message

        //calling setOnCheckedChangeListener method on each button
        CheckBox mycheckbox=variableBinding.mycheckbox;
        Switch mySwitch=variableBinding.mySwitch;
        RadioButton myRadiobutton=variableBinding.myRadiobutton;
        ImageView myImageView=variableBinding.myImageView;

        mycheckbox.setOnCheckedChangeListener((mycheckboxox,isChecked)->{
            //b is a new value on/off
            model.isSelected.postValue(isChecked);
        });
        mySwitch.setOnCheckedChangeListener((s,isChecked)->{
            model.isSelected.postValue(isChecked);
        });
        myRadiobutton.setOnCheckedChangeListener((radio,isChecked)->{
            model.isSelected.postValue(isChecked);
        });
        /*mycheckbox.setOnCheckedChangeListener((a,b)->{
            //b is a new value on/off
            theText.setText("Do you drink coffee?"+b);
        });

         mySwitch.setOnCheckedChangeListener((a,b)->{
             theText.setText("Do you drink coffe?"+b);
        });

         myRadiobutton.setOnCheckedChangeListener((a,b)->{
             theText.setText("Do you drink coffee?"+b);
         });

         */
        model.isSelected.observe(this,selected->{
            mycheckbox.setChecked(selected);
            mySwitch.setChecked(selected);
            myRadiobutton.setChecked(selected);
            // Show a toast message
            String toastMessage = "The value is now: " + selected;
            Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();

        });

        //ser image fresource for image view
        myImageView.setImageResource(R.drawable.c);
        model.editString.observe(this,s -> {
            variableBinding.textview.setText("Your edit text has"+s);


        });


        ///variableBinding.textview.setText(model.editString);
        variableBinding.buttonId.setOnClickListener(click -> {
            model.editString.postValue(variableBinding.myedittext.getText().toString());
            // model.editString = variableBinding.myedittext.getText().toString();
            // variableBinding.textview.setText("Your edit has:" + model.editString);
        });
        //ImageButton myImageButton = variableBinding.myimagebutton;
        myImageButton.setOnClickListener(click -> {
            int width = myImageButton.getWidth();
            int height = myImageButton.getHeight();
            String toastMessage = "The width = " + width + " and height = " + height;
            Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();
        });



    }
}








///part5
//theText.setText(model.editString);
        /*CheckBox mycheckbox=variableBinding.mycheckbox;
        Switch mySwitch=variableBinding.mySwitch;

        mycheckbox.setOnCheckedChangeListener((a,b)->{
            //b is a new value on/off
            theText.setText("Do you drink coffee?"+b);
        });

       mySwitch.setOnCheckedChangeListener((a,b)->{theText.setText("Do you drink coffe?"+b);
       });

         */





///part2

        /*setContentView(R.layout.activity_main);

        TextView mytext = findViewById(R.id.textview);//this will lok for something with id in text and it does return something or null
        //TextView mytext=variableBinding.textview;

        Button btn = findViewById(R.id.button_id);//it should matches the button tag in .xml

        EditText myedit = findViewById(R.id.myedittext);
        String editString = myedit.getText().toString();

        btn.setText("something new here");




            //onclick function with v parameter , body
       btn.setOnClickListener((vw) -> {

            mytext.setText( "Your edit text is "+editString );
            btn.setText("something new here");
        });




        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
               String editString = myedit.getText().toString();
                mytext.setText( "Your edit text has "+editString );
                btn.setText("something new here");

         */

