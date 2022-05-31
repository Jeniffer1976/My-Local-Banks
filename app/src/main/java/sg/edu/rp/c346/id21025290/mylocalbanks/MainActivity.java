package sg.edu.rp.c346.id21025290.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnDBS, btnOCBC, btnUOB;
    String bankClicked = "";
    boolean isBlackDbs = true;
    boolean isBlackOcbc = true;
    boolean isBlackUob = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDBS = findViewById(R.id.buttonDBS);
        btnOCBC = findViewById(R.id.buttonOCBC);
        btnUOB = findViewById(R.id.buttonUOB);

        registerForContextMenu(btnDBS);
        registerForContextMenu(btnOCBC);
        registerForContextMenu(btnUOB);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_main, menu);

        if (v == btnDBS) {
            bankClicked = "dbs";
        } else if (v == btnOCBC) {
            bankClicked = "ocbc";
        } else if (v == btnUOB) {
            bankClicked = "uob";
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_2, menu);
        return true;
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();
        if (bankClicked.equals("dbs")) {
            if (id == R.id.websiteSelection) {
                Intent intentView = new Intent(Intent.ACTION_VIEW, Uri.parse(getResources().getString(R.string.dbsWebsite)));
                startActivity(intentView);
                return true;

            } else if (id == R.id.contactSelection) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getResources().getString(R.string.dbsNo)));
                startActivity(intentCall);
                return true;

            } else if (id == R.id.toggleFavourite) {
                if(isBlackDbs) {
                    btnDBS.setBackgroundColor(Color.RED);
                    isBlackDbs = false;
                } else{
                    btnDBS.setBackgroundColor(Color.BLACK);
                    isBlackDbs = true;
                }
            } else {
                Toast.makeText(MainActivity.this, "Selection Error", Toast.LENGTH_SHORT).show();
            }
        }
        if (bankClicked.equals("ocbc")) {
            if (id == R.id.websiteSelection) {
                Intent intentView = new Intent(Intent.ACTION_VIEW, Uri.parse(getResources().getString(R.string.ocbcWebsite)));
                startActivity(intentView);
                return true;

            } else if (id == R.id.contactSelection) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getResources().getString(R.string.ocbcNo)));
                startActivity(intentCall);
                return true;

            } else if (id == R.id.toggleFavourite) {
                if(isBlackOcbc) {
                    btnOCBC.setBackgroundColor(Color.RED);
                    isBlackOcbc = false;
                } else{
                    btnOCBC.setBackgroundColor(Color.BLACK);
                    isBlackOcbc = true;
                }

            } else {
                Toast.makeText(MainActivity.this, "Selection Error", Toast.LENGTH_SHORT).show();
            }
        }

        if (bankClicked.equals("uob")) {
            if (id == R.id.websiteSelection) {
                Intent intentView = new Intent(Intent.ACTION_VIEW, Uri.parse(getResources().getString(R.string.uobWebsite)));
                startActivity(intentView);
                return true;

            } else if (id == R.id.contactSelection) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getResources().getString(R.string.uobNo)));
                startActivity(intentCall);
                return true;

            } else if (id == R.id.toggleFavourite) {
                if(isBlackUob) {
                    btnUOB.setBackgroundColor(Color.RED);
                    isBlackUob = false;
                } else{
                    btnUOB.setBackgroundColor(Color.BLACK);
                    isBlackUob = true;
                }
            } else {
                Toast.makeText(MainActivity.this, "Selection Error", Toast.LENGTH_SHORT).show();
            }
        }
        return super.onContextItemSelected(item);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            btnDBS.setText(getResources().getString(R.string.dbsEng));
            btnOCBC.setText(getResources().getString(R.string.ocbcEng));
            btnUOB.setText(getResources().getString(R.string.uobEng));
            return true;

        } else if (id == R.id.ChineseSelection) {
            btnDBS.setText(getResources().getString(R.string.dbsChi));
            btnOCBC.setText(getResources().getString(R.string.ocbcChi));
            btnUOB.setText(getResources().getString(R.string.uobChi));
            return true;

        } else {
            Toast.makeText(MainActivity.this, "Translation Error", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }
}
