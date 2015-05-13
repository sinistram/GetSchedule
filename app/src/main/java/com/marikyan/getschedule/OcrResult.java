package com.marikyan.getschedule;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

import com.marikyan.handling.XLSXHandling;


public class OcrResult extends Activity {


    public final static String outputFilePath = "result.xlsx";
    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ocr_result);
        String imagePath = getIntent().getExtras().getString("IMAGE_PATH");
        Toast.makeText(this, imagePath, Toast.LENGTH_LONG).show();
        new AsyncUploadFileProcessTask(this).execute(imagePath, outputFilePath);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ocr_result, menu);
        return true;
    }

    public void updateResults(Boolean success) {
        if (!success)
            return;
        try {

            StringBuffer contents = new StringBuffer();
            File xlsxFile = new File(getFilesDir() + "/" + outputFilePath);
            List<List<String>> res = XLSXHandling.getDataList(xlsxFile);
         //   FileInputStream fis = openFileInput(outputFilePath);
//
//            if (xlsxFile.exists()) {
//                Toast.makeText(this, fis.getFD().toString(), Toast.LENGTH_LONG).show();
//            } else {
//                Toast.makeText(this, fis.getChannel().toString(), Toast.LENGTH_LONG).show();
//            }

            try {
//                Reader reader = new InputStreamReader(fis, "UTF-8");
//                BufferedReader bufReader = new BufferedReader(reader);
//                String text = null;
//
//                while ((text = bufReader.readLine()) != null) {
//                    contents.append(text).append(System.getProperty("line.separator"));
                for (List<String> stringList:res) {
                    contents.append(stringList.toString());
                }
//                }
            } finally {
               // fis.close();
            }
            showText(contents.toString());
            displayMessage(contents.toString());
        } catch (Exception e) {
            showText("Error: " + e.getMessage());
        }
    }

    public void showText(String text) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder
                .setMessage(text)
                .setCancelable(true);
        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();

    }

    public void displayMessage(String text) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder
                .setMessage(text)
                .setCancelable(true);
        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
    }

    class MessagePoster implements Runnable {
        public MessagePoster(String message) {
            _message = message;
        }

        public void run() {
            tv.append(_message + "\n");
            setContentView(tv);
        }

        private final String _message;
    }
}
