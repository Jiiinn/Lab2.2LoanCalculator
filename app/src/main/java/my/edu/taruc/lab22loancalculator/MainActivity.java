package my.edu.taruc.lab22loancalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    public static final String MESSAGE_CAR_PRICE = "MainActivity.carPrice";
    public static final String MESSAGE_DOWN_PAYMENT = "MainActivity.downPayment";
    public static final String MESSAGE_LOAN_PERIOD = "MainActivity.loanPeriod";
    public static final String MESSAGE_INTEREST_RATE = "MainActivity.interestRate";

    private EditText editCarPrice, editDownPayment, editLoanPeriod, editInterestRate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editCarPrice = (EditText)findViewById(R.id.editCarPrice);
        editDownPayment = (EditText)findViewById(R.id.editDownPayment);
        editLoanPeriod = (EditText)findViewById(R.id.editLoanPeriod);
        editInterestRate = (EditText)findViewById(R.id.editInterestRate);
    }

    public void calculateLoan(View v){
        Intent intent = new Intent(this, ResultActivity.class);

        double car_price, down_payment, interest_rate;
        int loan_period;

        car_price = Double.parseDouble(editCarPrice.getText().toString());
        down_payment = Double.parseDouble(editDownPayment.getText().toString());
        interest_rate = Double.parseDouble(editInterestRate.getText().toString());
        loan_period = Integer.parseInt(editLoanPeriod.getText().toString());

        intent.putExtra(MESSAGE_CAR_PRICE, car_price);
        intent.putExtra(MESSAGE_DOWN_PAYMENT, down_payment);
        intent.putExtra(MESSAGE_INTEREST_RATE, interest_rate);
        intent.putExtra(MESSAGE_LOAN_PERIOD, loan_period);

        startActivity(intent);
    }
}
