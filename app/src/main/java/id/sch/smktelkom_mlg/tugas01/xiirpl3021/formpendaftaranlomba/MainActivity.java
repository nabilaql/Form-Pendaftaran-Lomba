package id.sch.smktelkom_mlg.tugas01.xiirpl3021.formpendaftaranlomba;

import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNama ;
    Spinner spKelas;
    RadioButton rbl,rbp;
    CheckBox cb1,cb2,cb3;
    Button bSubmit;
    TextView tvHasil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.nama);
        spKelas = (Spinner) findViewById(R.id.kelas);
        rbp = (RadioButton) findViewById(R.id.rbpr);
        rbl = (RadioButton) findViewById (R.id.rblk);
        cb1 = (CheckBox) findViewById(R.id.checkBox);
        cb2 = (CheckBox) findViewById (R.id.checkBox2);
        cb3 = (CheckBox) findViewById(R.id.checkBox3);
        bSubmit = (Button) findViewById (R.id.button);
        tvHasil = (TextView) findViewById (R.id.tvHasil);


        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doClick();
            }
        });

    }
    private void doClick()
    {
     if (isValid()) {
        String nama = etNama.getText().toString();

        String kelas = spKelas.getSelectedItem().toString();

        String jk = "Not Choosen";

        if (rbl.isChecked()) {
            jk = rbl.getText().toString();
        }else if (rbp.isChecked()) {
            jk = rbp.getText().toString();
        }


        String lomba = "Lomba yang diikuti : \n";
        int startlength = lomba.length();
        if (cb1.isChecked()) lomba += cb1.getText() + "\n";
        if (cb2.isChecked()) lomba += cb2.getText() + "\n";
        if (cb3.isChecked()) lomba += cb3.getText() + "\n";

        if (lomba.length() == startlength) lomba += "No object was choosen";

        tvHasil.setText("Name : " + nama + "\n" + "Kelas : "+ kelas +"\n" + "Jenis Kelamin :" + jk + "\n" + lomba);
    }
}

public boolean isValid() {
    boolean valid = true;

    String nama = etNama.getText().toString();
    String jk = "";

    if (nama.isEmpty()) {
        etNama.setError("Name can not empty");
        valid = false;
    } else if (nama.length() < 3) {
        etNama.setError("Name must have min. 3 character");
        valid = false;
    } else {
        etNama.setError(null);
    }
    return valid;
}
}