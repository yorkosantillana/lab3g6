package pe.edu.pucp.tel306.ViewModels;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ContadorMainMin extends ViewModel {

    private MutableLiveData<Integer> contadorMin = new MutableLiveData<>();

    private Thread thread = null;

    public void iniciarContador(){

        setThread(new Thread(new Runnable() {
            @Override
            public void run() {


                for(int contadorLocalMin=25;contadorLocalMin==0;contadorLocalMin--){

                    Log.d("contadorApp",String.valueOf(contadorLocalMin));
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

        getThread().start();



    }


    public MutableLiveData<Integer> getContadorMin() {
        return contadorMin;
    }

    public void setContadorMin(MutableLiveData<Integer> contadorMin) {
        this.contadorMin = contadorMin;
    }

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }
}
