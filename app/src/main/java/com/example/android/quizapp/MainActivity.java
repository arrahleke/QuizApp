package com.example.android.quizapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //mark counter
    int counter = 0;
    //response is the String variable which collects all correct responses entered by the user
    String response = "", email, tel, name;
    //Boolean variables for all questions
    boolean answer1, answer2, answer3, answer4, answer5;
    Switch res_switch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
    }

    //Collecting personal data i.e name and email
    private String personalData() {
        //name
        EditText user_name = (EditText) findViewById( R.id.name_edit );
        name = user_name.getText().toString();
        //email
        EditText user_email = (EditText) findViewById( R.id.email_edit );
        email = user_email.getText().toString();
        //Telephone number
        EditText user_tel = (EditText) findViewById( R.id.tel_edit );
        tel = user_tel.getText().toString();

        return "Your personal details are as follows:\n"
                + "Name : " + name + "\n"
                + "Email : " + email + "\n"
                + "Telephone : " + tel;
    }

    //Correct answers for each question
    //Question 1
    public boolean answer1(View view) {
        RadioButton php_1 = (RadioButton) findViewById( R.id.php_1_radio );
        boolean php_radio = php_1.isChecked();
        // Check which radio button was clicked
        if (php_radio){
            counter += 1;
            response += " 1, ";
            answer1 = true;
        }
        return true;
    }

    //Question 2
    public boolean answer2(View view) {

        CheckBox javaCheckBox = (CheckBox) findViewById( R.id.java_check );
        boolean java_check = javaCheckBox.isChecked();

        CheckBox cCheckBox = (CheckBox) findViewById( R.id.c_check );
        boolean c_check = cCheckBox.isChecked();

        CheckBox phpCheckBox = (CheckBox) findViewById( R.id.php_check );
        boolean php_check = phpCheckBox.isChecked();

        CheckBox pythonCheckBox = (CheckBox) findViewById( R.id.python_check );
        boolean python_check = pythonCheckBox.isChecked();

        CheckBox c_sCheckBox = (CheckBox) findViewById( R.id.c_sharp_check );
        boolean c_sharp_check = c_sCheckBox.isChecked();

        // Check which checkbox was clicked
        if (java_check && php_check && python_check && c_sharp_check) {
            counter += 1;
            response += " 2, ";
            answer2 = true;
        }
        return true;
    }

    //Answer for question 3
    public boolean answer3(View view) {
        EditText q3_edit = (EditText) findViewById( R.id.q3_edit );
        String freeAnswer = q3_edit.getText().toString();
        String expected_answer = "python";
        if (freeAnswer.equalsIgnoreCase( expected_answer )) {
            counter += 1;
            response += " 3, ";
            answer3 = true;
        }
        return true;
    }

    //Answer for question 4
    public boolean answer4(View view) {
        CheckBox wpCheckBox = (CheckBox) findViewById( R.id.wordpress_check );
        boolean wp_check = wpCheckBox.isChecked();

        CheckBox druCheckBox = (CheckBox) findViewById( R.id.drupal_check );
        boolean drupal_check = druCheckBox.isChecked();

        CheckBox jsfCheckBox = (CheckBox) findViewById( R.id.jsf_check );
        boolean jsf_check = jsfCheckBox.isChecked();

        CheckBox springCheckBox = (CheckBox) findViewById( R.id.spring_check );
        boolean spring_check = springCheckBox.isChecked();

        CheckBox joomlaCheckBox = (CheckBox) findViewById( R.id.joomla_check );
        boolean joomla_check = joomlaCheckBox.isChecked();

        // Check which checkbox was clicked
        if (wp_check && drupal_check && joomla_check) {
            counter += 1;
            response += " 4, ";
            answer4 = true;
        }
        return true;
    }
    //Answer for question 5
    public boolean answer5(View view) {
        RadioButton right = (RadioButton) findViewById( R.id.right_radio );
        boolean right_radio = right.isChecked();

        // Check which radio button was clicked
                if (right_radio == true){
                    counter += 1;
                    response += " 5. ";
                    answer5 = true;
                }
        return true;
    }
    //This method returns the full correction of the quiz
     public String quizCorrection(View view){

        String correction="The correct answers to the quiz are:";
        correction += "\n Question 1 : PHP";
        correction += "\n Question 2 : Java, PHP, Python and C#";
        correction += "\n Question 3 : Python";
        correction += "\n Question 4 : WordPress, Drupal and Joomla";
        correction += "\n Question 5 : Internet of Things";

        Toast.makeText( this, correction, Toast.LENGTH_LONG ).show();
        return correction;
     }

     public String detailedResults(View view){
         // String variable for the detailed results
         String details = "Your detailed results are as follows: \n";
         if (answer1)
         {
            details += "Question 1 : Correct\n";
         }
         else {
             details += "Question 1 : Incorrect\n";
         }

         if (answer2)
         {
             details += "Question 2 : Correct\n";
         }
         else {
             details += "Question 2 : Incorrect\n";
         }

         if (answer3)
         {
             details += "Question 3 : Correct\n";
         }
         else {
             details += "Question 3 : Incorrect\n";
         }
         if (answer4)
         {
             details += "Question 4 : Correct\n";
         }
         else {
             details += "Question 4 : Incorrect\n";
         }
         if (answer5)
         {
             details += "Question 5 : Correct";
         }
         else {
             details += "Question 5 : Incorrect";
         }
         details += "\n\n Total score : "+counter+"/5";
         Toast.makeText( this, details, Toast.LENGTH_LONG ).show();
         return details;
     }

    //The method which generate results when the submit button is clicked
    public void results(View view) {
        answer3( findViewById( R.id.q3_edit ) );
        Button see_correction_button = (Button) findViewById( R.id.correction_button );
        Button see_detail_button = (Button) findViewById( R.id.detail_button );
        ImageView congrat = (ImageView) findViewById( R.id.congrat_image );
        ImageView try_again = (ImageView) findViewById( R.id.try_again_image );

        res_switch = (Switch) findViewById( R.id.results_switch );
        if (counter >= 3) {

            Toast.makeText( this, "CONGRATULATIONS!!! You scored " + counter + "/5", Toast.LENGTH_SHORT ).show();

            //This is show the congratulations animated gif
            if (congrat.getVisibility() == View.INVISIBLE) {
                congrat.setVisibility( View.VISIBLE );
            }
            if (res_switch.getVisibility() == View.INVISIBLE) {
                    res_switch.setVisibility( View.VISIBLE );
            }
        }

        else {
            TextView poor_view = (TextView) findViewById( R.id.poor );
            if (poor_view.getVisibility() == View.INVISIBLE) {
                poor_view.setVisibility( View.VISIBLE );
                Toast.makeText( this, "Sorry!!! You scored only " + counter + "/5", Toast.LENGTH_LONG ).show();
                //This is show the congratulations animated gif
                if (try_again.getVisibility() == View.INVISIBLE) {
                    try_again.setVisibility( View.VISIBLE );
                }
            }
        }
        Toast.makeText( this, "These are your correct answers " + response, Toast.LENGTH_LONG ).show();

        //This is show the correction of the quiz when the correction button is clicked
        if (see_correction_button.getVisibility() == View.INVISIBLE) {
            see_correction_button.setVisibility( View.VISIBLE );
        }
        //This is show the detailed results of the quiz when the button is clicked
        if (see_detail_button.getVisibility() == View.INVISIBLE) {
            see_detail_button.setVisibility( View.VISIBLE );
        }

    }
   public void sendMail(View view) {
         //checking the switch button to send a mail to the user
      res_switch = (Switch) findViewById( R.id.results_switch );
       boolean mail = res_switch.isChecked();

       EditText user_email = (EditText) findViewById( R.id.email_edit );
       email = user_email.getText().toString();

        if (mail == true) {
            Intent intent = new Intent( Intent.ACTION_SENDTO );
            intent.setData( Uri.parse( "mailto: " + email ) ); // only email apps should handle this
            intent.putExtra( Intent.EXTRA_SUBJECT, "The results of your quiz " );
            intent.putExtra( Intent.EXTRA_TEXT, personalData().toString() + "\n\n" +detailedResults( findViewById( R.id.detail_button )).toString() +"\n\n"+ quizCorrection(findViewById( R.id.correction_button )).toString() );
            if (intent.resolveActivity( getPackageManager() ) != null) {
                startActivity( intent );
            }
        }
    }
}


