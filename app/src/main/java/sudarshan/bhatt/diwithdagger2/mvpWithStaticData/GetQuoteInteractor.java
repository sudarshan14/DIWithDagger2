package sudarshan.bhatt.diwithdagger2.mvpWithStaticData;

public interface GetQuoteInteractor {


    interface OnFinishedListener {


        void onFinished(String string);

    }

     void getNextQuotes(OnFinishedListener onFinishedListener);
}
