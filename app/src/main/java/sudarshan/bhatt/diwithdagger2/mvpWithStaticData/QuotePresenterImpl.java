package sudarshan.bhatt.diwithdagger2.mvpWithStaticData;

public class QuotePresenterImpl implements QuotePresenter, GetQuoteInteractor.OnFinishedListener {


    /*
     This class implements the Presenter and nested interface from GetQuoteInteractor.
     Moreover it instantiates the QuoteView and GetQuoteInteractor interfaces (View and Model respectively).
     */
    private QuoteView quoteView;
    private GetQuoteInteractor getQuoteInteractor;


    public QuotePresenterImpl(QuoteView quoteView, GetQuoteInteractor getQuoteInteractor) {

        this.quoteView = quoteView;
        this.getQuoteInteractor = getQuoteInteractor;
    }


    @Override
    public void onFinished(String string) {

        if(quoteView !=null){
            quoteView.setQuote(string);
            quoteView.hideProgressBar();
        }


    }

    @Override
    public void onButtonClick() {

        if (quoteView != null) {
            quoteView.showProgressBar();
        }
        getQuoteInteractor.getNextQuotes(this);

    }

    @Override
    public void onDestroy() {
        quoteView = null;
    }
}
