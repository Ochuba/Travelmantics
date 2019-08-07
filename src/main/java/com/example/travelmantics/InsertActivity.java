package com.example.travelmantics;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

// this class is in charge of handling the activity that saves data to the firebase that other users can use
public class InsertActivity extends AppCompatActivity {
    private FirebaseDatabase mFirebaseDatabase ; // creates a variable of the firebase
    private DatabaseReference mDatabaseReference; // database reference is the location in our firebase that database is stored
    private EditText txtTitle; // no need to explain this
    private EditText txtPrice;
    private EditText txtDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        FirebaseUtil.openFbReference("traveldeals"); // executes the code im the firebase util class and passes in the string into it
        mFirebaseDatabase = FirebaseUtil.mFirebaseDatabase; //refers to the public static method in the ap
        mDatabaseReference = FirebaseUtil.mDatabaseReference;

        txtTitle = (EditText) findViewById(R.id.txtTitle);// gets the id of the editText fields in pour Xml app
        txtPrice = (EditText) findViewById(R.id.txtPrice);
        txtDescription = (EditText) findViewById(R.id.txtDescription);
    }
    // this method is in charge of displaying our menu in our activity remember the menu is set to show as always
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater =getMenuInflater(); // gets the menuInflater and passes it into a variable
        inflater.inflate(R.menu.save_menu, menu); // inflates the menu and in the argument the menu id is passed in and menu
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.save_menu:
                saveDeal(); //this method saves the deal
                Toast.makeText(this, "Item Saved!!", Toast.LENGTH_LONG).show();
                clean(); //cleans immediately the toast is shown for you to insert a new deal
                default:
                    return super.onOptionsItemSelected(item);
                    
        }
       
    }

    private void clean() {
        txtDescription.setText(""); // now i know i to clear a textfield simple but impressive
        txtPrice.setText("");
        txtTitle.setText("");
        txtTitle.requestFocus(); // was a little bit confused here but finally discovered it pushes the cursor back to the specified editText field
    }

    private void saveDeal() {
        String Title = txtTitle.getText().toString();
        String Description = txtDescription.getText().toString();
        String Price = txtPrice.getText().toString();
        TravelDeal deal = new TravelDeal(Title, Description, Price, "");
        mDatabaseReference.push().setValue(deal);
    }
}
// last one for the boy clean this ....... check on firebase at the end of module 2
// done by samuel in case for suggestions or corrections @samenstein on twitter or esambooks@gmail.com