package fr.clbonnefoy1.projet_if26_android;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Contact extends AppCompatActivity {

    private Context mContext;

    private TextView tv_nom_proprio;
    private TextView tv_email_proprio;
    private TextView tv_tel_proprio;

    private EditText et_nom;
    private EditText et_email;
    private EditText et_message;

    private Button bt_annuler;
    private Button bt_envoyer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        mContext = this;

        Intent intent = getIntent();
        String id_proprio = intent.getStringExtra("id_proprio");

        ModulePersistance mp = new ModulePersistance(this);

        Proprietaire p = mp.getProprietaire(id_proprio);

        tv_nom_proprio = (TextView)findViewById(R.id.tv_nom_proprio);
        tv_nom_proprio.setText(String.format("Nom : %s", p.getNom()));

        tv_email_proprio = (TextView)findViewById(R.id.tv_email_proprio);
        tv_email_proprio.setText(String.format("Email : %s", p.getEmail()));

        tv_tel_proprio = (TextView)findViewById(R.id.tv_tel_proprio);
        tv_tel_proprio.setText(String.format("Téléphone : %s", p.getTel()));

        et_nom = (EditText)findViewById(R.id.et_nom);
        et_email = (EditText)findViewById(R.id.et_email);
        et_message = (EditText)findViewById(R.id.et_message);

        bt_annuler = (Button)findViewById(R.id.bt_annuler);
        bt_annuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, MainActivity.class);
                startActivity(intent);
            }
        });

        bt_envoyer = (Button)findViewById(R.id.bt_envoyer);
        bt_envoyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //TODO Envoyer le message.

                Intent intent = new Intent(mContext, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
