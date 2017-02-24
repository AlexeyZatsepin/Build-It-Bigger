package study.gradlecoursefinalproject;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.ExecutionException;

import study.jokelibrary.Action;
import timber.log.Timber;

class RefreshAction implements Action<String> {
    private static final long serialVersionUID = 7526472295622776147L;
    @Override
    public String method() {
        return getJoke();
    }
    private void readObject(
            ObjectInputStream aInputStream
    ) throws ClassNotFoundException, IOException {
        //always perform the default de-serialization first
        aInputStream.defaultReadObject();

        //make defensive copy of the mutable Date field
    }

    /**
     * This is the default implementation of writeObject.
     * Customise if necessary.
     */
    private void writeObject(
            ObjectOutputStream aOutputStream
    ) throws IOException {
        //perform the default serialization for all non-transient, non-static fields
        aOutputStream.defaultWriteObject();
    }

    public static String getJoke(){
        try {
            return new EndpointAsyncTask().execute().get();
        } catch (InterruptedException | ExecutionException e) {
            Timber.e(e.getMessage());
        }
        return null;
    }
}