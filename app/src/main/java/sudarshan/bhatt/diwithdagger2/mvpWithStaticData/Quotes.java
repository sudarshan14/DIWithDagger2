package sudarshan.bhatt.diwithdagger2.mvpWithStaticData;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import sudarshan.bhatt.diwithdagger2.R;

public class Quotes extends AppCompatActivity implements QuoteContract.QuoteView {
    private TextView textView;
    private Button button;
    private ProgressBar progressBar;
    QuoteContract.QuotePresenter quotePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotes);

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        progressBar = findViewById(R.id.progressBar);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                quotePresenter.onButtonClick();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        quotePresenter = new QuotePresenterImpl(this, new GetQuoteInteractorImpl());
        quotePresenter.onButtonClick();
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
        textView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
        textView.setVisibility(View.VISIBLE);
    }

    @Override
    public void setQuote(String quote) {
        textView.setText(quote);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        quotePresenter.onDestroy();
    }
}
