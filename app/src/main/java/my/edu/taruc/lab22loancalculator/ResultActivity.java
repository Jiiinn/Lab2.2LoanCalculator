package my.edu.taruc.lab22loancalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView tvDownPayment, tvLoanPeriod, tvInterestRate, tvMonthRepayment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tvDownPayment = (TextView)findViewById(R.id.tvDownPayment);
        tvInterestRate = (TextView)findViewById(R.id.tvInterestRate);
        tvLoanPeriod = (TextView)findViewById(R.id.tvLoanPeriod);
        tvMonthRepayment = (TextView)findViewById(R.id.tvMonthRepayment);

        Intent intent = getIntent();
        double message_car_price = intent.getDoubleExtra(MainActivity.MESSAGE_CAR_PRICE, 0);
        double message_down_payment = intent.getDoubleExtra(MainActivity.MESSAGE_DOWN_PAYMENT, 0);
        int message_loan_period = intent.getIntExtra(MainActivity.MESSAGE_LOAN_PERIOD, 0);
        double message_interest_rate = intent.getDoubleExtra(MainActivity.MESSAGE_INTEREST_RATE, 0);

        tvDownPayment.setText(getString(R.string.tvDownPayment) + " : " + message_down_payment);
        tvLoanPeriod.setText(getString(R.string.tvLoanPeriod) + " : " + message_loan_period);
        tvInterestRate.setText(getString(R.string.tvInterestRate) + " : " + message_interest_rate);

        double car_loan, interest, monthly_repayment;

        car_loan = message_car_price - message_down_payment;
        interest = car_loan * message_interest_rate * (message_loan_period);
        monthly_repayment = (car_loan + interest) / (message_loan_period / 12);

        tvMonthRepayment.setText(getString(R.string.tvMonthRepayment) + " : " + monthly_repayment);

    }
}
