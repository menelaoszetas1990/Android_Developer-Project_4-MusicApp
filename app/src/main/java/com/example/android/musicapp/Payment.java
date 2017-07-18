// Based to https://www.youtube.com/watch?v=mTcM8sYZHas

package com.example.android.musicapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;
import com.paypal.android.sdk.payments.PaymentConfirmation;

import java.math.BigDecimal;

public class Payment extends AppCompatActivity {

    TextView m_response;
    PayPalConfiguration m_configuration;
    // this id is the link to the paypal account that is created for test reasons inside paypal app
    String m_paypalClientId = "AdLT2Bau0l3ZwMvSAuvPiFQFs8n0Ci0ufGRMiqIMuCS8dwnn9ZjIK-IM2TsB6ub2b7Rw1eDymeZvJb6y";
    Intent m_service;
    int m_paypalRequestCode = 999; //any code


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        m_response = (TextView) findViewById(R.id.response);

        m_configuration = new PayPalConfiguration()
                .environment(PayPalConfiguration.ENVIRONMENT_SANDBOX) //for the test. needs production for real
                .clientId(m_paypalClientId);

        m_service = new Intent(this, PayPalService.class);
        m_service.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, m_configuration);
        startService(m_service); // paypal service, listening to calls to paypal app

        Button donate = (Button) findViewById(R.id.buttonDonate10$);

        donate.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                PayPalPayment payment = new PayPalPayment(new BigDecimal(10), "USD", "Test payment", PayPalPayment.PAYMENT_INTENT_SALE);

                Intent intent = new Intent(Payment.this, PaymentActivity.class);
                intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, m_configuration);
                intent.putExtra(PaymentActivity.EXTRA_PAYMENT, payment);
                startActivityForResult(intent, m_paypalRequestCode);
            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == m_paypalRequestCode) {
            if (resultCode == Activity.RESULT_OK) {
                //payment confirmation
                PaymentConfirmation confirmation = data.getParcelableExtra(PaymentActivity.EXTRA_RESULT_CONFIRMATION);

                if (confirmation != null) {
                    String state = confirmation.getProofOfPayment().getState();

                    if (state.equals("approved")) {
                        m_response.setText("payment approved");
                    } else {
                        m_response.setText("error in the payment");
                    }
                } else {
                    m_response.setText("confirmation is null");
                }
            }
        }

    }

}
