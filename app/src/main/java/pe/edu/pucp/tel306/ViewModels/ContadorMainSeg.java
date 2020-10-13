package pe.edu.pucp.tel306.ViewModels;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ContadorMainSeg extends ViewModel {

    private MutableLiveData<Integer> contadorSeg = new MutableLiveData<>();

    private Thread thread = null;

    public void iniciarContador(){

        setThread(new Thread(new Runnable() {
            @Override
            public void run() {

                for(int contadorLocalSeg=59;contadorLocalSeg==0;contadorLocalSeg--){

                    Log.d("contadorApp",String.valueOf(contadorLocalSeg));
                    getContadorSeg().postValue(contadorLocalSeg);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }

                }



            }
        }));

        getThread().start();



    }


    public MutableLiveData<Integer> getContadorSeg() {
        return contadorSeg;
    }

    public void setContadorSeg(MutableLiveData<Integer> contadorSeg) {
        this.contadorSeg = contadorSeg;
    }

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }
}
