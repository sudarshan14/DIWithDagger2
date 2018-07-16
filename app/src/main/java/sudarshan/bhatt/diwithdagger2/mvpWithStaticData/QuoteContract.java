package sudarshan.bhatt.diwithdagger2.mvpWithStaticData;

public interface QuoteContract {

    interface QuoteView {


        public void showProgressBar();

        public void hideProgressBar();

        public void setQuote(String quote);
    }

    interface GetQuoteInteractor {


        interface OnFinishedListener {


            void onFinished(String string);

        }

        void getNextQuotes(GetQuoteInteractor.OnFinishedListener onFinishedListener);
    }

    interface QuotePresenter {

        void onButtonClick();

        void onDestroy();
    }
}
