package id.ac.upj.tif.menghitungluas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class Main2Activity extends AppCompatActivity {
    TextView txtHasil;
    EditText txtLuas,txtLs,txtLt;
    Button btnHitung;
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final Bundle b = getIntent().getExtras();
        TextView intensitas =  findViewById(R.id.namaValue);
        intensitas.setText(b.getCharSequence("Intensitasku"));

        final Spinner spinner =  findViewById(R.id.spinner);
        txtHasil = findViewById(R.id.txtHasil);
        txtLuas = findViewById(R.id.txtLuas);
        //txtLs = findViewById(R.id.txtLs);
        //txtLt = findViewById(R.id.txtLt);
        btnHitung = findViewById(R.id.btnHitung);

        //String jalur = spinner.getSelectedItem().toString();
        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double A, Qs, C, Cs, tc, to, td, Lt, Ls, Vs, St;
                double intensitas;

                A = Double.parseDouble(txtLuas.getText().toString());
                intensitas = Double.parseDouble( b.getString("Intensitasku"));
                C = Double.parseDouble(spinner.getSelectedItem().toString());
                //Ls = Double.parseDouble(txtLs.getText().toString());
                //Lt = Double.parseDouble(txtLt.getText().toString());
                Vs = 0.95;
                St= 0.02; // kemiringan lahan (%)
                String jalur = spinner.getSelectedItem().toString();

                Double Stkuadrat =Math.pow(St,0.5);
               // Double abc = Math.pow((Lt / Stkuadrat),0.77);
                //to = 0.0197* abc ;
                //td= Ls /(60 * Vs);
                //tc = to + td;
                //Cs = (2 * tc) / ((2 * tc )+ td);

                Qs = 0.00278 * C * intensitas *  A;
                txtHasil.setText("Debit Banjir Maks: " +Qs);

                Intent intent = new Intent(getApplicationContext(), Main3Activity.class);
                Intent koefisi = new Intent(getApplicationContext(), Main4Activity.class);
                Bundle d = new Bundle();

                //untuk menyimpan data debit
                String hasil = new Double(Qs).toString();
                d.putString("Debitku", hasil);
                d.putString("koefisenku", Double.toString(C));
                intent.putExtras(d);
                //memulai Activity ketiga
                startActivity(intent);
            }
        });


    }
}