package pe.edu.pucp.tel306.ViewModels;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ContadorMainMin extends ViewModel {

    private MutableLiveData<Integer> contadorMin = new MutableLiveData<>();

    private Thread thread2 = null;

    public void iniciarContador2(final int minutos){

        setThread2(new Thread(new Runnable() {
            @Override
            public void run() {


                for(int contadorLocalMin=minutos;contadorLocalMin>=0;contadorLocalMin--){

                    Log.d("contadorMainMin",String.valueOf(contadorLocalMin));
                    getContadorMin().postValue(contadorLocalMin);
                    try {
                        Thread.sleep(60000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }

                }




            }
        }));

        getThread2().start();



    }


    public MutableLiveData<Integer> getContadorMin() {
        return contadorMin;
    }

    public void setContadorMin(MutableLiveData<Integer> contadorMin) {
        this.contadorMin = contadorMin;
    }


    public Thread getThread2() {
        return thread2;
    }

    public void setThread2(Thread thread2) {
        this.thread2 = thread2;
    }
}
